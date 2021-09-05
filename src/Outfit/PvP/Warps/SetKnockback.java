package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class SetKnockback implements Listener, CommandExecutor {
	public static Main plugin;

	public SetKnockback(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kbset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("kb.x", p.getLocation().getX());
				plugin.getConfig().set("kb.y", p.getLocation().getY());
				plugin.getConfig().set("kb.z", p.getLocation().getZ());
				plugin.getConfig().set("kb.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("kb.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("kb.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Knockback foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
