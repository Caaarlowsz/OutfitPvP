package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;

public class DoarCommand implements CommandExecutor, Listener {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException var2) {
			return false;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("doar")) {
			if (!p.hasPermission("zey.pvp.doar")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
			} else {
				if (args.length == 0) {
					sender.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §cErrado, utilize a sintaxe correta: /doar [jogador(a)] [quantidade]");
					return true;
				}

				Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					sender.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
					return true;
				}

				if (isNumeric(args[1])) {
					int coins = Integer.parseInt(args[1].replace("-", ""));
					if (ZeyCoins.getPlayerMoney(p) < coins) {
						p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVoce nao tem dolls suficientes!");
						return true;
					}

					ZeyCoins.addMoney(target, coins);
					ZeyCoins.removeMoney(p, coins);
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você doou ao jogador(a): §d" + target.getName()
							+ " §7» §2" + coins + " Dolls§7.");
					target.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você recebeu do jogador(a): §d"
							+ p.getName() + " §7» §2" + coins + " Dolls§7.");
				}
			}
		}

		return false;
	}
}
