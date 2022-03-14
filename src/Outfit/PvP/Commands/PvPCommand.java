package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class PvPCommand implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp") && (sender.hasPermission("zey.pvp.pvp") || sender.isOp())) {
			if (p.getWorld().getPVP()) {
				p.getWorld().setPVP(false);
				Bukkit.getServer().broadcastMessage(
						OutfitPvP.prefix + " §8➸ §7O PvP do servidor foi §c§lDESATIVADO§7.");
				return true;
			} else {
				p.getWorld().setPVP(true);
				Bukkit.getServer()
						.broadcastMessage(OutfitPvP.prefix + " §8➸ §7O PvP do servidor foi §a§lATIVADO§7.");
				return true;
			}
		} else {
			return false;
		}
	}
}
