package Outfit.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.OneVsOne.Join1v1;
import Outfit.PvP.Utils.Proteção;

public class Warp1v1 implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public Warp1v1(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("1v1")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("1v1.world"));
			double x = plugin.getConfig().getDouble("1v1.x");
			double y = plugin.getConfig().getDouble("1v1.y");
			double z = plugin.getConfig().getDouble("1v1.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("1v1.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("1v1.yaw"));
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
			TheTitle.sendTitle(p, "§d§l1v1");
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
			Habilidade.setAbility(p, "1v1");
			KitAPI.remove(p);
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			if (WarpAPI.getWarp(p) != "1v1") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "1v1");
				MenuWarps.AddWarp(p);
			}

			Proteção.setImortal(p, true);
			Proteção.isImortal(p);
			p.getInventory().setBoots(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setHelmet(null);
			p.setHealthScale(20.0D);
			p.getInventory().setItem(3, Join1v1.Item_);
			p.getInventory().setItem(5, Join1v1.Cinza);
			p.updateInventory();
			p.setFireTicks(0);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
