package Outfit.PvP.JumpBlocks;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Diamante implements Listener {
	
	public static ArrayList<String> jump = new ArrayList<>();
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void aoMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			jump.remove(p.getName());
			Location loc = e.getTo().getBlock().getLocation();
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(4);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.HORSE_JUMP, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			jump.add(p.getName());
		}
	}
	@EventHandler
	public void aoQueda(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		if(e.getEntity() instanceof Player) {
			if((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && (jump.contains(p.getName()))) {
				e.setCancelled(true);
				jump.remove(p.getName());
			}
		}
	}
}
