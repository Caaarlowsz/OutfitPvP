package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetEvento implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetEvento(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("eventoset") && sender instanceof Player) {
			Player p;
			if (!sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p = (Player) sender;
				plugin.getConfig().set("evento.x", p.getLocation().getX());
				plugin.getConfig().set("evento.y", p.getLocation().getY());
				plugin.getConfig().set("evento.z", p.getLocation().getZ());
				plugin.getConfig().set("evento.pitch", p.getLocation().getPitch());
				plugin.getConfig().set("evento.yaw", p.getLocation().getYaw());
				plugin.getConfig().set("evento.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7» §aWarp Evento foi setada com sucesso");
			}

			return true;
		} else {
			return false;
		}
	}
}
