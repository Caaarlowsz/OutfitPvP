package Outfit.PvP.APIs;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import Outfit.PvP.Clan.Clan;
import Outfit.PvP.Clan.ClanManager;
import Outfit.PvP.Config.ClanConfig;
import Outfit.PvP.Config.ClanConfig2;

public class ClanAPI {

	public static HashMap<String, ArrayList<String>> pedidos = new HashMap<String, ArrayList<String>>();

	public static Clan getClanPlayer(Player p) {
		Clan clan = ClanManager.getClan(getClanPlayerString(p));
		return clan;
	}

	public static String getClanPlayerFormat(Player p) {
		Clan clan = ClanAPI.getClanPlayer(p);
		if (clan == null) {
			return "";
		}
		return ClanConfig.getConfig().getString(clan.getName() + ".Tag").replace("&", "§");
	}

	public static String getClanPlayerString(OfflinePlayer vicoff) {
		if (ClanConfig2.getConfig().get(vicoff.getName().toLowerCase() + ".Clan") == null) {
			return "Nenhum";
		}
		return ClanConfig2.getConfig().getString(vicoff.getName().toLowerCase() + ".Clan");
	}

	public static void addPlayerToClan(Player p, Clan clan) {
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan.getName() + ".Membros");
		if (!list.contains(p.getName().toLowerCase())) {
			list.add(p.getName().toLowerCase());
		}
		ClanConfig.getConfig().set(clan.getName() + ".Membros", list);
		ClanConfig.saveConfigs();
		ClanConfig2.getConfig().set(p.getName().toLowerCase() + ".Clan", clan.getName());
		ClanConfig2.saveConfigs();
	}

	public static String getOwner(String clan) {
		return ClanConfig.getConfig().getString(clan + ".Dono");
	}

	public static boolean clanExist(String clan) {
		return ClanConfig.getConfig().get(clan + ".Name") != null;
	}

	public static void createClan(Player p, String tag, String name) {
		ClanConfig.getConfig().set(name + ".Name", name);
		ClanConfig.getConfig().set(name + ".Tag", tag);
		ClanConfig.getConfig().set(name + ".Dono", p.getName().toLowerCase());
		ArrayList<String> list = new ArrayList<String>();
		list.add(p.getName().toLowerCase());
		ClanConfig.getConfig().set(name + ".Membros", list);
		ClanConfig.saveConfigs();
		ClanConfig2.getConfig().set(p.getName().toLowerCase() + ".Clan", name);
		ClanConfig2.saveConfigs();
	}

	public static ArrayList<String> getMembers(String clan) {
		ArrayList<String> members = new ArrayList<String>();
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan + ".Membros");
		for (String stg : list) {
			members.add(stg);
		}
		return members;
	}

	public static ArrayList<Player> getMembersOnline(String clan) {
		ArrayList<Player> members = new ArrayList<Player>();
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan + ".Membros");
		for (String stg : list) {
			Player p = Bukkit.getPlayer(stg);
			if (p != null) {
				members.add(p);
			}
		}
		return members;
	}

	public static void senMessage(String clan, String message) {
		for (Player players : getMembersOnline(clan)) {
			players.sendMessage(message);
		}
	}

	public static void kickPlayer(String player, String clan) {
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan + ".Membros");
		if (list.contains(player.toLowerCase())) {
			list.remove(player.toLowerCase());
		}
		ClanConfig.getConfig().set(clan + ".Membros", list);
		ClanConfig.saveConfigs();
		ClanConfig2.getConfig().set(player.toLowerCase().toString(), null);
		ClanConfig2.saveConfigs();
	}

	public static void kickPlayer(Player p, String clan) {
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan + ".Membros");
		if (list.contains(p.getName().toLowerCase())) {
			list.remove(p.getName().toLowerCase());
		}
		ClanConfig.getConfig().set(clan + ".Membros", list);
		ClanConfig.saveConfigs();
		ClanConfig2.getConfig().set(p.getName().toLowerCase().toString(), null);
		ClanConfig2.saveConfigs();
	}

	public static int getOnlineSize(String clan) {
		int size = 0;
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (getClanPlayerString(pl).equals(clan)) {
				size++;
			}
		}
		return size;
	}

	public static void kickPlayer(OfflinePlayer p, String clan) {
		ArrayList<String> list = (ArrayList<String>) ClanConfig.getConfig().getStringList(clan + ".Membros");
		if (list.contains(p.getName().toLowerCase())) {
			list.remove(p.getName().toLowerCase());
		}
		ClanConfig.getConfig().set(clan + ".Membros", list);
		ClanConfig.saveConfigs();
		ClanConfig2.getConfig().set(p.getName().toLowerCase() + ".Clan", null);
		ClanConfig2.getConfig().set(p.getName().toLowerCase().toString(), null);
		ClanConfig2.saveConfigs();
	}

}
