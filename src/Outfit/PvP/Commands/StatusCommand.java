package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Account.Grupos;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Score.SPlayer;

public class StatusCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("status")) {
			if (args.length == 0) {
				p.sendMessage("§a");
				p.sendMessage("§8» §d§lMEU STATUS");
				p.sendMessage("§a");
				p.sendMessage("§4» §fGrupo: " + Grupos.getGrupos(p));
				p.sendMessage("§c» §fRank: " + SPlayer.Liga(p));
				p.sendMessage("§d» §fMarca: " + SPlayer.Marca(p));
				p.sendMessage("§a");
				p.sendMessage("§5» §fMatou: §a"
						+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
				p.sendMessage("§9» §fKillStreak: §6"
						+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".ks"));
				p.sendMessage("§3» §fMorreu: §c"
						+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
				p.sendMessage("§b» §fDolls: §2$" + ZeyCoins.getPlayerMoney(p));
				p.sendMessage("§a» §fClan: §d" + SPlayer.Clan(p));
				p.sendMessage("§a");
				return true;
			}

			if (args.length > 0 && args.length < 2) {
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if (t != null) {
					p.sendMessage("§a");
					p.sendMessage("§8» §d§lSTATUS§f: §7§n" + t.getName());
					p.sendMessage("§a");
					p.sendMessage("§4» §fGrupo: " + Grupos.getGrupos(t));
					p.sendMessage("§c» §fRank: " + SPlayer.Liga(t));
					p.sendMessage("§d» §fMarca: " + SPlayer.Marca(t));
					p.sendMessage("§a");
					p.sendMessage("§5» §fMatou: §a"
							+ Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".kills"));
					p.sendMessage("§9» §fKillStreak: §6"
							+ Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".ks"));
					p.sendMessage("§3» §fMorreu: §c"
							+ Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".mortes"));
					p.sendMessage("§b» §fDolls: §2$" + ZeyCoins.getPlayerMoney(t));
					p.sendMessage("§a» §fClan: §d" + SPlayer.Clan(t));
					p.sendMessage("§a");
					return true;
				}
			}
		}

		return false;
	}
}
