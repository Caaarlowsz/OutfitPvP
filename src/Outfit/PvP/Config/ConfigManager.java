package Outfit.PvP.Config;

import java.util.List;

import org.bukkit.entity.Player;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class ConfigManager {
	public static String getString(final String text) {
		return OutfitPvP.getPlugin().getConfig().getString(text).replace("&", "§");
	}

	public static Integer getInt(final String text) {
		return OutfitPvP.getPlugin().getConfig().getInt(text);
	}

	public static List<String> getList(final String text) {
		return OutfitPvP.getPlugin().getConfig().getStringList(text);
	}

	public static void RemoverKS(Player p) {
		OutfitPvP.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".ks", Integer.valueOf(0));
		OutfitPvP.plugin.saveConfig();
	}

	public static void setConfig(final String text, final String c) {
		OutfitPvP.getPlugin().getConfig().set(text, c);
		OutfitPvP.getPlugin().saveConfig();
	}
}
