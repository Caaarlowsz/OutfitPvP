package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class IniciarCommand implements CommandExecutor {
	public static boolean evento;
	public static boolean fullkit;

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("iniciar")) {
			if (!p.hasPermission("zey.pvp.iniciar")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cErrado, utilize a sintaxe correta: /iniciar [Evento] [FullKit]");
				return true;
			}

			if (args[0].equalsIgnoreCase("evento")) {
				if (evento) {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO Evento [Evento] já foi iniciado.");
					return true;
				}

				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVocê iniciou o Evento [Evento].");
				Bukkit.broadcastMessage(String.valueOf(Main.prefix)
						+ " §8➸ §aUm Evento foi iniciado, para entrar use o comando /evento§a.");
				evento = true;
				return true;
			}

			if (args[0].equalsIgnoreCase("fullkit")) {
				if (fullkit) {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO beneficio FullKit já está liberado.");
					return true;
				}

				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVocê liberou o beneficio FullKit para todos.");
				Bukkit.broadcastMessage(String.valueOf(Main.prefix)
						+ " §8➸ §aO beneficio FullKit está liberado para todos, aproveitem.");
				fullkit = true;
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cErrado, utilize a sintaxe correta: /iniciar [Evento] [FullKit]");
				return true;
			}
		}

		return false;
	}
}
