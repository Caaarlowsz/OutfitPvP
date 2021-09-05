package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class Set1v1 implements Listener, CommandExecutor {
	public static Main plugin;

	public Set1v1(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("1v1set") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("1v1.x", p.getLocation().getX());
				plugin.getConfig().set("1v1.y", p.getLocation().getY());
				plugin.getConfig().set("1v1.z", p.getLocation().getZ());
				plugin.getConfig().set("1v1.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("1v1.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("1v1.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §§aWarp 1v1 foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
