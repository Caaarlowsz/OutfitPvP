package Outfit.PvP.Eventos;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Habilidade implements Listener {
	public static Map<String, String> powerMap = new HashMap<String, String>();

	public Habilidade(OutfitPvP main) {
	}

	public static String NomeDoKit(String original) {
		return original.length() == 0 ? original
				: original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	public static String getAbility(Player player) {
		if (!powerMap.containsKey(player.getName())) {
			powerMap.put(player.getName(), "Nenhum");
		}

		return powerMap.get(player.getName());
	}

	public static void setAbility(Player player, String ability) {
		powerMap.put(player.getName(), ability);
	}

	public static void removeAbility(Player p) {
		powerMap.remove(p.getName());
	}

	public static void strikeLightning(Entity p) {
		Location coords = p.getLocation();
		coords.getWorld().strikeLightningEffect(coords);
		Block block = coords.getBlock();
		block.setType(Material.AIR);
	}
}
