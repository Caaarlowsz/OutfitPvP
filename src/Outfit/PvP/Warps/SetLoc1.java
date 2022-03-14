package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetLoc1 implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetLoc1(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("loc1set") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("loc1.x", p.getLocation().getX());
				plugin.getConfig().set("loc1.y", p.getLocation().getY());
				plugin.getConfig().set("loc1.z", p.getLocation().getZ());
				plugin.getConfig().set("loc1.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("loc1.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("loc1.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aLOC1 foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
