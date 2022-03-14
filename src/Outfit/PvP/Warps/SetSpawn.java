package Outfit.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SetSpawn implements CommandExecutor, Listener {
	public static OutfitPvP plugin;

	public SetSpawn(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawnset") && sender instanceof Player) {
			Player p1;
			if (!sender.hasPermission("zey.pvp.set")) {
				p1 = (Player) sender;
				p1.sendMessage("§cVocê não tem permissão para isso.");
			}

			if (sender.hasPermission("zey.pvp.set")) {
				p1 = (Player) sender;
				plugin.getConfig().set("spawn.x", p1.getLocation().getX());
				plugin.getConfig().set("spawn.y", p1.getLocation().getY());
				plugin.getConfig().set("spawn.z", p1.getLocation().getZ());
				plugin.getConfig().set("spawn.pitch", p1.getLocation().getPitch());
				plugin.getConfig().set("spawn.yaw", p1.getLocation().getYaw());
				plugin.getConfig().set("spawn.world", p1.getLocation().getWorld().getName());
				plugin.saveConfig();
				p1.sendMessage(OutfitPvP.prefix + " §7» §aWarp Spawn foi setado com sucesso");
				p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(),
						p1.getLocation().getBlockZ());
			}

			return false;
		} else {
			return false;
		}
	}
}
