package Outfit.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class Parkour implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public Parkour(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("parkour")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("parkour.world"));
			double x = plugin.getConfig().getDouble("parkour.x");
			double y = plugin.getConfig().getDouble("parkour.y");
			double z = plugin.getConfig().getDouble("parkour.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("parkour.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("parkour.yaw"));
			p.teleport(lobby);
			p.getInventory().clear();
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aTeleportado com sucesso");
			TheTitle.sendTitle(p, "§d§lPARKOUR");
			TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
			if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
				OutfitPvP.admins.remove(p.getName());
				p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você saiu do modo §c§lADMIN");
				Player[] var17;
				int var16 = (var17 = Bukkit.getOnlinePlayers()).length;

				for (int var15 = 0; var15 < var16; ++var15) {
					Player players = var17[var15];
					players.showPlayer(p);
				}
			}

			p.setAllowFlight(false);
			p.setFlying(false);
			KitAPI.remove(p);
			Habilidade.removeAbility(p);
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			if (WarpAPI.getWarp(p) != "Parkour") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "Parkour");
				MenuWarps.AddWarp(p);
			}

			p.getInventory().setBoots(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setHelmet(null);
			p.setHealthScale(20.0D);
			Proteção.setImortal(p, true);
			Proteção.isImortal(p);
			ItemStack KitPadrao2 = new ItemStack(Material.REDSTONE, 1, (short) 0);
			ItemMeta kKitPadrao2 = KitPadrao2.getItemMeta();
			kKitPadrao2.setDisplayName("§c§lVOLTAR");
			KitPadrao2.setItemMeta(kKitPadrao2);
			p.getInventory().setItem(4, KitPadrao2);
			p.setFireTicks(0);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
