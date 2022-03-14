package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetTextura implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetTextura(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("txset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("tx.x", p.getLocation().getX());
				plugin.getConfig().set("tx.y", p.getLocation().getY());
				plugin.getConfig().set("tx.z", p.getLocation().getZ());
				plugin.getConfig().set("tx.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("tx.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("tx.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp Textura foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
