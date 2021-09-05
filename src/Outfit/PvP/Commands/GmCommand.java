package Outfit.PvP.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class GmCommand implements CommandExecutor, Listener {
	public GmCommand(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println(String.valueOf(Main.prefix) + " §8➸ §cApenas jogadores podem usar isso.");
				return true;
			}

			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /gm [0/1]");
			} else if (args.length == 1) {
				if (!p.hasPermission("zey.pvp.gm") && !p.isOp()) {
					p.sendMessage("§cVocê não tem permissão para isso.");
				} else if (!args[0].equalsIgnoreCase("1") && !args[0].equalsIgnoreCase("criativo")) {
					if (!args[0].equalsIgnoreCase("0") && !args[0].equalsIgnoreCase("sobrevivencia")) {
						p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cGamemode Inexistente.");
					} else {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(String.valueOf(Main.prefix)
								+ " §8➸ §7Seu gamemode foi alterado para §c§lSOBREVIVENCIA§7.");
					}
				} else {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §7Seu gamemode foi alterado para §a§lCRIATIVO§7.");
				}
			}
		}

		return false;
	}
}
