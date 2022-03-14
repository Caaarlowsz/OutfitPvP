package Outfit.PvP.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class MiniGun implements Listener {
	private static Integer shed_id = null;

	@EventHandler
	public void onTntLaunch(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("MiniGun") && p.getItemInHand().getType() == Material.ARROW
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			e.setCancelled(true);
			if (Cooldown.add(p)) {
				KitUtil.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 25);
			cancel();
			shed_id = Integer
					.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(OutfitPvP.plugin, new Runnable() {
						public void run() {
							Location loc = p.getLocation();
							loc.setY(loc.getY() + 0.5D);
							Arrow h = p.launchProjectile(Arrow.class);
							Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
							h.setVelocity(velo1);
						}
					}, 2L, 2L));
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(OutfitPvP.plugin, new Runnable() {
				public void run() {
					MiniGun.cancel();
				}
			}, 120L);
		}
	}

	@EventHandler
	public void Projectile(ProjectileHitEvent e) {
		if (e.getEntity().getType() == EntityType.ARROW)
			e.getEntity().remove();
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	}
}
