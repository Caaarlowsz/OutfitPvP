package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetLava implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetLava(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("challengeset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("lava.x", p.getLocation().getX());
				plugin.getConfig().set("lava.y", p.getLocation().getY());
				plugin.getConfig().set("lava.z", p.getLocation().getZ());
				plugin.getConfig().set("lava.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("lava.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("lava.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp Challenge foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
