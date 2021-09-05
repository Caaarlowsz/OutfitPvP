package Outfit.PvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;

public class Alladin implements Listener {
	public static ArrayList<String> cooldown = new ArrayList<String>();

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Alladin") && p.getItemInHand().getType() == Material.CARPET
				&& e.getAction() == Action.RIGHT_CLICK_AIR) {
			e.setCancelled(true);
			if (cooldown.contains(p.getName())) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cKit em cooldown!");
				return;
			}

			final FallingBlock tapete = p.getWorld().spawnFallingBlock(p.getLocation().clone().add(0.0D, 1.0D, 0.0D),
					Material.CARPET.getId(), (byte) 0);
			tapete.setDropItem(false);
			tapete.setVelocity(new Vector(0, 0, 0));
			tapete.setPassenger(p);
			Location loc = p.getLocation().clone();
			loc.setPitch(0.0F);
			cooldown.add(p.getName());
			Vector vec = p.getVelocity().clone();
			int forca = 7;
			Vector pular = vec.multiply(0.1D).setY(0.17D * (double) forca);
			Vector olhar = loc.getDirection().normalize().multiply(1.5D);
			tapete.setVelocity(pular.add(olhar));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					tapete.remove();
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §eTapete Removido!");
				}
			}, 50L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					if (Alladin.cooldown.contains(p.getName())) {
						Alladin.cooldown.remove(p.getName());
						p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aCooldown acabou!");
					}

				}
			}, 300L);
		}

	}
}
