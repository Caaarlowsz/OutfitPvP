package Outfit.PvP.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ClanConfig2 {
	
	public static FileConfiguration Clans;
	public static File FileClans;
	
	public ClanConfig2(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileClans = new File(plugin.getDataFolder(), "Clans2.yml");
		if(!FileClans.exists()){
			try{
				FileClans.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Clans = YamlConfiguration.loadConfiguration(FileClans);
	}
	public static FileConfiguration getConfig(){
		return Clans;
	}
	public static void saveConfigs(){
		try{
			Clans.save(FileClans);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
