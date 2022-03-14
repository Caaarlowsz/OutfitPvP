package Outfit.PvP.APIs;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Score.SPlayer;
import ca.wacos.nametagedit.NametagAPI;

public class TagsAPI {
	public static void setarTag(Player p, String tag) {
		new BukkitRunnable() {
			@Override
			public void run() {
				p.setDisplayName(tag + p.getName());
				NametagAPI.setPrefix(p.getName(), tag);
			}
		}.runTaskAsynchronously(OutfitPvP.getInstace());
	}

	public static void SetarTag(Player p) {

		if (p.hasPermission("grupo.dono")) {
			setarTag(p, "§4§lDONO§4 ");
			NametagAPI.setPrefix(p.getName(), "§4§lDONO§4 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.dona")) {
			setarTag(p, "§4§lDONA§4 ");
			NametagAPI.setPrefix(p.getName(), "§4§lDONA§4 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.subdono")) {
			setarTag(p, "§4§lS-DONO§4 ");
			NametagAPI.setPrefix(p.getName(), "§4§lS-DONO§4 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.diretor")) {
			setarTag(p, "§6§lDIRETOR§6 ");
			NametagAPI.setPrefix(p.getName(), "§6§lDIRETOR§6 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.subdona")) {
			setarTag(p, "§4§lS-DONA§4 ");
			NametagAPI.setPrefix(p.getName(), "§4§lS-DONA§4 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.developer")) {
			setarTag(p, "§3§lDEV§3 ");
			NametagAPI.setPrefix(p.getName(), "§3§lDEV§3 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.gerente")) {
			setarTag(p, "§c§lGERENTE§c ");
			NametagAPI.setPrefix(p.getName(), "§c§lGERENTE§c ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.admingc")) {
			setarTag(p, "§c§lADMINGC§c ");
			NametagAPI.setPrefix(p.getName(), "§c§lADMINGC§c ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.admin")) {
			setarTag(p, "§c§lADMIN§c ");
			NametagAPI.setPrefix(p.getName(), "§c§lADMIN§c ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.mod+")) {
			setarTag(p, "§5§lMOD+§5 ");
			NametagAPI.setPrefix(p.getName(), "§5§lMOD+§5 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.modgc")) {
			setarTag(p, "§3§lMODGC§3 ");
			NametagAPI.setPrefix(p.getName(), "§3§lMODGC§3 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.mod")) {
			setarTag(p, "§5§lMOD§5 ");
			NametagAPI.setPrefix(p.getName(), "§5§lMOD§5 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.manager")) {
			setarTag(p, "§6§lMANAGER§6 ");
			NametagAPI.setPrefix(p.getName(), "§6§lMANAGER§6 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.gc")) {
			setarTag(p, "§1§lGC§1 ");
			NametagAPI.setPrefix(p.getName(), "§1§lGC§1 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.trial")) {
			setarTag(p, "§d§lTRIAL§d ");
			NametagAPI.setPrefix(p.getName(), "§d§lTRIAL§d ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.helper")) {
			setarTag(p, "§e§lHELPER§e ");
			NametagAPI.setPrefix(p.getName(), "§e§lHELPER§e ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.builder")) {
			setarTag(p, "§2§lBUILDER§2 ");
			NametagAPI.setPrefix(p.getName(), "§2§lBUILDER§2 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.youtuber+")) {
			setarTag(p, "§3§lYT+§3 ");
			NametagAPI.setPrefix(p.getName(), "§3§lYT+§3 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.youtuber")) {
			setarTag(p, "§b§lYT§b ");
			NametagAPI.setPrefix(p.getName(), "§b§lYT§b ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.spro")) {
			setarTag(p, "§e§lSPRO§e ");
			NametagAPI.setPrefix(p.getName(), "§e§lSPRO§e ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.beta")) {
			setarTag(p, "§1§lBETA§1 ");
			NametagAPI.setPrefix(p.getName(), "§1§lBETA§1 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.outfit")) {
			setarTag(p, "§d§lKOMBO§d ");
			NametagAPI.setPrefix(p.getName(), "§d§lKOMBO§d ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.pro")) {
			setarTag(p, "§6§lPRO§6 ");
			NametagAPI.setPrefix(p.getName(), "§6§lPRO§6 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.mvp")) {
			setarTag(p, "§9§lMVP§9 ");
			NametagAPI.setPrefix(p.getName(), "§9§lMVP§9 ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.vip")) {
			setarTag(p, "§a§lVIP§a ");
			NametagAPI.setPrefix(p.getName(), "§a§lVIP§a ");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		if (p.hasPermission("grupo.normal")) {
			setarTag(p, "§7");
			if (ClanAPI.getClanPlayer(p) == null) {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			} else {
				NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			}
			return;
		}

		setarTag(p, "§7");
		NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
		return;
	}
}
