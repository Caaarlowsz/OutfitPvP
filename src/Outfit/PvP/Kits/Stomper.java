package Outfit.PvP.Kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;

public class Stomper implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerStomp(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (KitAPI.Stomper.contains(p.getName())) {
				for (Entity ent : p.getNearbyEntities(5.0D, 3.0D, 5.0D)) {
					if (!(ent instanceof Player))
						continue;
					Player plr = (Player) ent;
					if (e.getDamage() <= 4.0D) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking() || Habilidade.getAbility(plr) == "AntiTower") {

						plr.damage(6.0D, p);
						continue;
					}
					plr.damage(e.getDamage(), (Entity) p);
					plr.getKiller();
				}

				e.setDamage(4.0D);
				return;
			}
			return;
		}
	}

	@EventHandler
	public void stomperApple(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE && KitAPI.Stomper.contains(p.getName())
				&& (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_AIR)) {
			event.setCancelled(true);

			if (Cooldown.add(p)) {
				KitUtil.MensagemCooldown(p);
			} else {

				Vector vector = p.getEyeLocation().getDirection();
				vector.multiply(0.0F);
				vector.setY(6.0F);
				p.setVelocity(vector);
				Location loc = p.getLocation();
				p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
				Cooldown.add(p, 30);
			}
		}
	}
}
