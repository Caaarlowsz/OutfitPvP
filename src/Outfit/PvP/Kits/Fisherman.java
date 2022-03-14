package Outfit.PvP.Kits;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import Outfit.PvP.Essencial.KitAPI;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Fisherman implements Listener {
	public Fisherman(OutfitPvP main) {
	}

	@EventHandler
	public void onPlayerFish(PlayerFishEvent event) {
		Entity caught = event.getCaught();
		Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block && KitAPI.Fisherman.contains(event.getPlayer().getName())) {
			caught.teleport(event.getPlayer().getLocation());
		}

	}
}
