package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Config.Status;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class LigaCommand implements CommandExecutor {
	public static String Rank(Player p) {
		double a = Status.getKills(p);
		if (a <= 100.0D) {
			return "§8[§f-§8]";
		} else if (a <= 200.0D) {
			return "§8[§a\u2663§8]";
		} else if (a <= 300.0D) {
			return "§8[§e\u2665§8]";
		} else if (a <= 400.0D) {
			return "§8[§1✥§8]";
		} else if (a <= 500.0D) {
			return "§8[§7✯§8]";
		} else if (a <= 600.0D) {
			return "§8[§6✪§8]";
		} else if (a <= 700.0D) {
			return "§8[§b❈§8]";
		} else if (a <= 800.0D) {
			return "§8[§2✸§8]";
		} else if (a <= 900.0D) {
			return "§8[§c✹§8]";
		} else if (a <= 1000.0D) {
			return "§8[§3✷§8]";
		} else {
			return "§8[§4✪§8]";
		}
	}

	public static String getRankConfig(Player p) {
		double a = Status.getKills(p);
		if (a <= 100.0D) {
			return "§7Unranked";
		} else if (a <= 200.0D) {
			return "§aINICIANTE";
		} else if (a <= 300.0D) {
			return "§eAPRENDIZ";
		} else if (a <= 400.0D) {
			return "§1EXPERT";
		} else if (a <= 500.0D) {
			return "§7SILVER";
		} else if (a <= 600.0D) {
			return "§6GOLD";
		} else if (a <= 700.0D) {
			return "§bDIAMOND";
		} else if (a <= 800.0D) {
			return "§2EMERALD";
		} else if (a <= 900.0D) {
			return "§cRUBY";
		} else if (a <= 1000.0D) {
			return "§3SAFIRA";
		} else {
			return "§4LENDARIO";
		}
	}

	public static String getNomeRank(Player p) {
		double a = Status.getKills(p);
		if (a <= 100.0D) {
			return "§7Unranked";
		} else if (a <= 200.0D) {
			return "§aINICIANTE";
		} else if (a <= 300.0D) {
			return "§eAPRENDIZ";
		} else if (a <= 400.0D) {
			return "§1EXPERT";
		} else if (a <= 500.0D) {
			return "§7SILVER";
		} else if (a <= 600.0D) {
			return "§6GOLD";
		} else if (a <= 700.0D) {
			return "§bDIAMOND";
		} else if (a <= 800.0D) {
			return "§2EMERALD";
		} else if (a <= 900.0D) {
			return "§CRUBY";
		} else if (a <= 1000.0D) {
			return "§3SAFIRA";
		} else {
			return "§4LENDARIO";
		}
	}

	public static String Liga(Player p) {
		double a = Status.getKills(p);
		if (a <= 100.0D) {
			return "§7Unranked";
		} else if (a <= 200.0D) {
			return "§aINICIANTE";
		} else if (a <= 300.0D) {
			return "§eAPRENDIZ";
		} else if (a <= 400.0D) {
			return "§1EXPERT";
		} else if (a <= 500.0D) {
			return "§7SILVER";
		} else if (a <= 600.0D) {
			return "§6GOLD";
		} else if (a <= 700.0D) {
			return "§bDIAMOND";
		} else if (a <= 800.0D) {
			return "§2EMERALD";
		} else if (a <= 900.0D) {
			return "§cRUBY";
		} else if (a <= 1000.0D) {
			return "§3SAFIRA";
		} else {
			return "§4LENDARIO";
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("liga") && args.length == 0) {
			p.sendMessage(" ");
			p.sendMessage(
					OutfitPvP.prefix + " §8➸ §fAqui estão há lista de todas as Ligas/Ranks, do servidor:");
			p.sendMessage("                              ");
			p.sendMessage("§8[§4✪§8] §4LENDARIO §f- §71001 a 1500 Kills");
			p.sendMessage("§8[§3✷§8] §3SAFIRA §f- §7901 a 1000 Kills");
			p.sendMessage("§8[§c✸§8] §cRUBY §f- §7801 a 900 Kills");
			p.sendMessage("§8[§2✸§8] §2EMERALD §f- §7701 a 800 Kills");
			p.sendMessage("§8[§b❈§8] §bDIAMOND §f- §7601 a 700 Kills");
			p.sendMessage("§8[§6✪§8] §6GOLD §f- §7501 a 600 Kills");
			p.sendMessage("§8[§7✯§8] §7SILVER §f- §7401 a 500 Kills");
			p.sendMessage("§8[§1✥§8] §1EXPERT §f- §7301 a 400 Kills");
			p.sendMessage("§8[§e\u2665§8] §eAPRENDIZ §f- §7201 a 300 Kills");
			p.sendMessage("§8[§a\u2663§8] §aINICIANTE §f- §7101 a 200 Kills");
			p.sendMessage("§8[§f-§8] §7Unranked §f- §70 a 100 Kills");
			p.sendMessage("                              ");
			p.sendMessage(OutfitPvP.prefix
					+ " §8➸ §fVocê pode adquirir estas Ligas/Ranks, matando jogadores. Apos matar os jogadores você ganhara kills, e com essas kills você ira upar! Boa sorte.");
			p.sendMessage(" ");
		}

		return false;
	}
}
