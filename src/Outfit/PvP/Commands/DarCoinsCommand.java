package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;

public class DarCoinsCommand implements CommandExecutor, Listener {
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
		if (cmd.getName().equalsIgnoreCase("darcoins")) {
			if (!p.hasPermission("zey.pvp.darcoins")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
			} else {
				if (args.length == 0) {
					sender.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §cErrado, utilize a sintaxe correta: /darcoins [jogador(a)] [quantidade]");
					return true;
				}

				Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					sender.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
					return true;
				}

				if (isNumeric(args[1])) {
					int coins = Integer.parseInt(args[1]);
					ZeyCoins.addMoney(target, coins);
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVocê deu ao jogador(a): §e" + target.getName()
							+ "§a " + coins + " Dolls");
					target.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVocê recebeu do jogador(a): §e"
							+ p.getName() + "§a " + coins + " Dolls");
				}
			}
		}

		return false;
	}
}
