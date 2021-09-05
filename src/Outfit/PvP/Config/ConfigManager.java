package Outfit.PvP.Config;

import java.util.List;

import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class ConfigManager
{
    public static String getString(final String text) {
        return Main.getPlugin().getConfig().getString(text).replace("&", "§");
    }
    
    public static Integer getInt(final String text) {
        return Main.getPlugin().getConfig().getInt(text);
    }
    
    public static List<String> getList(final String text) {
        return (List<String>)Main.getPlugin().getConfig().getStringList(text);
    }
    
	public static void RemoverKS(Player p) {
		Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".ks", Integer.valueOf(0));
		Main.plugin.saveConfig();
	}
    
    public static void setConfig(final String text, final String c) {
        Main.getPlugin().getConfig().set(text, (Object)c);
        Main.getPlugin().saveConfig();
    }
}
