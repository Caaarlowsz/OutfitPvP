package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class TpHereCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("tphere") && !cmd.getName().equalsIgnoreCase("here")) {
			return false;
		} else if (!p.hasPermission("zey.pvp.tp.here")) {
			p.sendMessage("§cVocê não tem permissão para isso.");
			return true;
		} else if (args.length == 0) {
			p.sendMessage(String.valueOf(Main.prefix)
					+ " §8➸ §cErrado, utilize a sintaxe correta: /tphere ou /here para puxar um jogador até você.");
			return true;
		} else {
			Player k = Bukkit.getPlayer(args[0]);
			if (k == null) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
				return true;
			} else {
				k.teleport(p);
				p.sendMessage(
						String.valueOf(Main.prefix) + " §8➸ §7Você puxou o jogador: §e" + k.getName() + " §7até você.");
				return true;
			}
		}
	}
}
