package Outfit.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.Essencial.KitAPI;

public class Camel implements Listener {
	@EventHandler
	public void Andar(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND
				|| e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)
				&& KitAPI.Camel.contains(e.getPlayer().getName())) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
		}
	}
}
