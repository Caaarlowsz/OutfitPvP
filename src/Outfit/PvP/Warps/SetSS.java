package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetSS implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetSS(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ssset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("ss.x", p.getLocation().getX());
				plugin.getConfig().set("ss.y", p.getLocation().getY());
				plugin.getConfig().set("ss.z", p.getLocation().getZ());
				plugin.getConfig().set("ss.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("ss.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("ss.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp SS foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
