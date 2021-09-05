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
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Sumo.JoinSumo;
import Outfit.PvP.Utils.Proteção;

public class WarpSumo implements Listener, CommandExecutor {
	public static Main plugin;

	public WarpSumo(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sumo")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("sumo.world"));
			double x = plugin.getConfig().getDouble("sumo.x");
			double y = plugin.getConfig().getDouble("sumo.y");
			double z = plugin.getConfig().getDouble("sumo.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("sumo.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("sumo.yaw"));
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
			p.sendMessage(String.valueOf(Main.prefix) + " §8-> §aTeleportado com sucesso");
			TheTitle.sendTitle(p, "§d§lSUMO");
			TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
			if ((p.hasPermission("zey.pvp.admin")) && (WarpAPI.getWarp(p) == "Nenhuma")) {
				Main.admins.remove(p.getName());
				p.sendMessage(String.valueOf(Main.prefix) + " §8-> §7Voce saiu do modo §c§lADMIN");
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player players = arrayOfPlayer[i];
					players.showPlayer(p);
				}
			}
			p.setAllowFlight(false);
			p.setFlying(false);
			Habilidade.setAbility(p, "Sumo");
			KitAPI.remove(p);
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			if (WarpAPI.getWarp(p) != "Sumo") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "Sumo");
				MenuWarps.AddWarp(p);
			}
			Proteção.setImortal(p, true);
			Proteção.isImortal(p);
			p.getInventory().setBoots(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setHelmet(null);
			p.setHealthScale(20.0D);
			p.getInventory().setItem(3, JoinSumo.ItemS_);
			p.getInventory().setItem(5, JoinSumo.CinzaS);
			p.updateInventory();
			p.setFireTicks(0);
			for (PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
