package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class SetParkour implements Listener, CommandExecutor {
	public static Main plugin;

	public SetParkour(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("parkourset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("parkour.x", p.getLocation().getX());
				plugin.getConfig().set("parkour.y", p.getLocation().getY());
				plugin.getConfig().set("parkour.z", p.getLocation().getZ());
				plugin.getConfig().set("parkour.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("parkour.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("parkour.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Parkour foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
