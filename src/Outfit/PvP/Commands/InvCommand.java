package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class InvCommand implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cApenas jogadores podem usar isso.");
			return true;
		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("inv")) {
				if (sender.hasPermission("zey.pvp.inv")) {
					sender.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §cErrado, utilize a sintaxe correta: /inv [Jogador(a)]");
					if (args.length > 0) {
						Player player = Bukkit.getPlayer(args[0]);
						if (player == null) {
							sender.sendMessage(
									String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
							return true;
						}

						sender.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Inventario §a§lABERTO§7 com sucesso.");
						p.openInventory(player.getInventory());
					}
				} else {
					p.sendMessage("§cVocê não tem permissão para isso.");
				}

				return true;
			} else {
				return true;
			}
		}
	}
}
