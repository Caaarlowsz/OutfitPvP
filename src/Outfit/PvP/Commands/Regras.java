package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class Regras implements CommandExecutor {
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player player = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("regras")) {
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage(String.valueOf(Main.prefix) + " §8➸ §c§lREGRAS DO SERVIDOR!");
			player.sendMessage("§7 ");
			player.sendMessage("§8➸ §d§l1º §7Nao peça pra ler seu formulario!");
			player.sendMessage("§8➸ §d§l2º §7Nao peça informações sobre o plugin do servidor!");
			player.sendMessage("§8➸ §d§l3º §7Nao xingue os staffers!");
			player.sendMessage("§8➸ §d§l4º §7Nao divulgue servidores!");
			player.sendMessage("§8➸ §d§l5º §7Nao abuse de Bugs!");
			player.sendMessage("§8➸ §d§l6º §7Nao pergunte coisas que não tem haver com o servidor!");
			player.sendMessage("§8➸ §d§l7º §7Nao use hack!");
			player.sendMessage("§8➸ §d§l8º §7Nao finja ser hack!");
			player.sendMessage("§8➸ §d§l9º §7Respeite os superiores!");
			player.sendMessage("§8➸ §d§l10º §7Nao flode no chat!");
			player.sendMessage("§7 ");
		}

		return false;
	}
}
