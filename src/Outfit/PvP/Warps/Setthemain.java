package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Setthemain implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public Setthemain(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mainset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("themain.x", p.getLocation().getX());
				plugin.getConfig().set("themain.y", p.getLocation().getY());
				plugin.getConfig().set("themain.z", p.getLocation().getZ());
				plugin.getConfig().set("themain.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("themain.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("themain.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp Main foi setado com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
