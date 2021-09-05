package Outfit.PvP.Clan;

import java.util.ArrayList;
import java.util.Set;

import Outfit.PvP.Config.ClanConfig;

public class ClanManager {

	public static ArrayList<Clan> getAllClans(){
		ArrayList<Clan> clans = new ArrayList<Clan>();
		Set<String> vals = ClanConfig.getConfig().getKeys(true);
		for(String val : vals){
			clans.add(new Clan(val));
		}
		return clans;
	}
	
	public static ArrayList<String> getAllClansString(){
		ArrayList<String> clans = new ArrayList<String>();
		Set<String> vals = ClanConfig.getConfig().getKeys(false);
		for(String val : vals){
			clans.add(val);
		}
		return clans;
	}
	
	public static Clan getClan(String clan){
		for(Clan clans : getAllClans()){
			if(clans.getName().equalsIgnoreCase(clan)){
				return clans;
			}
		}
		return null;
	}
	
}
