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
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class MDR implements Listener, CommandExecutor {
	public static Main plugin;

	public MDR(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mdr")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("mdr.world"));
			double x = plugin.getConfig().getDouble("mdr.x");
			double y = plugin.getConfig().getDouble("mdr.y");
			double z = plugin.getConfig().getDouble("mdr.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("mdr.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("mdr.yaw"));
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
			p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aTeleportado com sucesso");
			TheTitle.sendTitle(p, "§d§lMDR");
			TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
			int i;
			if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
				Main.admins.remove(p.getName());
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você saiu do modo §c§lADMIN");
				Player[] var17;
				int var16 = (var17 = Bukkit.getOnlinePlayers()).length;

				for (i = 0; i < var16; ++i) {
					Player players = var17[i];
					players.showPlayer(p);
				}
			}

			p.setAllowFlight(false);
			p.setFlying(false);
			Habilidade.setAbility(p, "Warp");
			MenuWarps.RemoveWarp(p);
			KitAPI.remove(p);
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			WarpAPI.setWarp(p, "Evento");
			ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);

			for (i = 0; i < 36; ++i) {
				p.getInventory().setItem(i, sopa);
			}

			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.setHealthScale(20.0D);
			Proteção.setImortal(p, false);
			Proteção.isImortal(p);
			p.setFireTicks(0);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
