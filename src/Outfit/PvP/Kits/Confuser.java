package Outfit.PvP.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;

public class Confuser implements Listener {
	@EventHandler
	public void onConfusao(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Confuser")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COAL) {
			e.setCancelled(true);
			if (Cooldown.add(p)) {
				KitUtil.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 40);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitUtil.ccooldown(p);
				}
			}, 800L);
		}
	}
}
