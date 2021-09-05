package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class SetS1 implements Listener, CommandExecutor {
	public static Main plugin;

	public SetS1(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("s1set")) && ((sender instanceof Player))) {
			if (!sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				p.sendMessage("§cVoce não tem permissão para isso.");
			}
			if (sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				plugin.getConfig().set("s1.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("s1.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("s1.z", Double.valueOf(p.getLocation().getZ()));
				plugin.getConfig().set("s1.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("s1.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("s1.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.prefix) + "§7-> §S1 foi setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
