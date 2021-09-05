package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class CcCommand implements CommandExecutor, Listener {
	public CcCommand(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cApenas jogadores podem usar isso.");
			return false;
		} else {
			Player p = (Player) sender;
			if (commandLabel.equalsIgnoreCase("cc")) {
				if (p.hasPermission("zey.pvp.cc")) {
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §d§lO CHAT FOI LIMPO.");
				} else {
					sender.sendMessage("§cVocê não tem permissão para isso.");
				}
			}

			return false;
		}
	}
}
