package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetS2 implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public SetS2(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("s2set")) && ((sender instanceof Player))) {
			if (!sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				p.sendMessage("§cVoce nao tem permissao para isso.");
			}
			if (sender.hasPermission("zey.pvp.set")) {
				Player p = (Player) sender;
				plugin.getConfig().set("s2.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("s2.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("s2.z", Double.valueOf(p.getLocation().getZ()));
				plugin.getConfig().set("s2.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("s2.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("s2.world", p.getLocation().getWorld().getName());
				plugin.saveConfig();
				p.sendMessage(OutfitPvP.prefix + " §7-> §aA S2 foi setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
