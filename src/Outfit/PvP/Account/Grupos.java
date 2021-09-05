package Outfit.PvP.Account;

import org.bukkit.entity.Player;

public class Grupos {

	public static String getGrupos(Player p) {
		if (p.getName().equalsIgnoreCase("sdadasdas") || p.getName().equalsIgnoreCase("dsadasda")) {
			return "§4§lDONA";
		}
		if (p.hasPermission("grupo.dono")) {
			return "§4§lDONO";
		}
		if (p.hasPermission("grupo.dona")) {
			return "§4§lDONA";
		}
		if (p.hasPermission("grupo.subdono")) {
			return "§4§lS-DONO";
		}
		if (p.hasPermission("grupo.diretor")) {
			return "§6§lDIRETOR";
		}
		if (p.hasPermission("grupo.subdona")) {
			return "§4§lS-DONA";
		}
		if (p.hasPermission("grupo.developer")) {
			return "§3§lDEV";
		}
		if (p.hasPermission("grupo.gerente")) {
			return "§c§lGERENTE";
		}
		if (p.hasPermission("grupo.admingc")) {
			return "§c§lADMINGC";
		}
		if (p.hasPermission("grupo.admin")) {
			return "§c§lADMIN";
		}
		if (p.hasPermission("grupo.mod+")) {
			return "§5§lMOD+";
		}
		if (p.hasPermission("grupo.modgc")) {
			return "§5§lMODGC";
		}
		if (p.hasPermission("grupo.mod")) {
			return "§5§lMOD";
		}
		if (p.hasPermission("grupo.manager")) {
			return "§6§lMANAGER";
		}
		if (p.hasPermission("grupo.gc")) {
			return "§1§lGC";
		}
		if (p.hasPermission("grupo.trial")) {
			return "§d§lTRIAL";
		}
		if (p.hasPermission("grupo.helper")) {
			return "§e§lHELPER";
		}
		if (p.hasPermission("grupo.builder")) {
			return "§3§lBUILDER";
		}
		if (p.hasPermission("grupo.youtuber+")) {
			return "§3§lYT+";
		}
		if (p.hasPermission("grupo.youtuber")) {
			return "§b§lYT";
		}
		if (p.hasPermission("grupo.beta")) {
			return "§1§lBETA";
		}
		if (p.hasPermission("grupo.supremo")) {
			return "§d§lKOMBO";
		}
		if (p.hasPermission("grupo.pro")) {
			return "§6§lPRO";
		}
		if (p.hasPermission("grupo.spro")) {
			return "§e§lSPRO";
		}
		if (p.hasPermission("grupo.mvp")) {
			return "§9§lMVP";
		}
		if (p.hasPermission("grupo.vip")) {
			return "§a§lVIP";
		}
		if (p.hasPermission("grupo.normal")) {
			return "§7§lNORMAL";
		}
		return "§7§lNORMAL";
	}
}
