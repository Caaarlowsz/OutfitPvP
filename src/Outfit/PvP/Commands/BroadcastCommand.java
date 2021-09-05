package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Main.Main;

public class BroadcastCommand implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
			if (sender.hasPermission("zey.pvp.bc")) {
				if (args.length == 0) {
					sender.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe Correta: /bc [Mensagem]");
					return true;
				}

				String msg = "";
				String[] var9 = args;
				int var8 = args.length;

				int var7;
				for (var7 = 0; var7 < var8; ++var7) {
					String msg2 = var9[var7];
					msg = String.valueOf(String.valueOf(String.valueOf(msg))) + msg2 + " ";
				}

				Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §f" + msg.replace("&", "§"));
				Player[] var11;
				var8 = (var11 = Bukkit.getOnlinePlayers()).length;

				for (var7 = 0; var7 < var8; ++var7) {
					Player players = var11[var7];
					TheTitle.sendTitle(players, "§6§lKombo§f§lPvP");
					TheTitle.sendSubTitle(players, "§f" + msg.replace("&", "§"));
				}

				return true;
			}

			sender.sendMessage("§cVocê não tem permissão para isso.");
		}

		return false;
	}
}
