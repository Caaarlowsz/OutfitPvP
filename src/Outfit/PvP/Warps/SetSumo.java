package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetSumo implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetSumo(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("sumoset")) && ((sender instanceof Player))) {
			if (!sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				p.sendMessage(OutfitPvP.prefix + " §7» §cSem permissao.");
			}
			if (sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				plugin.getConfig().set("sumo.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("sumo.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("sumo.z", Double.valueOf(p.getLocation().getZ()));
				plugin.getConfig().set("sumo.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("sumo.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("sumo.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp Sumo foi setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
