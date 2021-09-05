package Outfit.PvP.Eventos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;

public class CombatLog implements Listener {
	public static List<String> Sair = new ArrayList<String>();

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (!e.isCancelled()) {
			if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
				final Player p = (Player) e.getEntity();
				final Player hitter = (Player) e.getDamager();
				if (Habilidade.getAbility(p) == "Nenhum" || Habilidade.getAbility(hitter) == "Nenhum"
						|| WarpAPI.getWarp(p) == "Challenge" || WarpAPI.getWarp(hitter) == "Challenge") {
					return;
				}

				if (hitter.getGameMode() == GameMode.CREATIVE) {
					return;
				}

				if (!Sair.contains(p.getName()) && !Sair.contains(hitter.getName())) {
					Sair.add(p.getName());
					Sair.add(hitter.getName());
					p.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §7Voce entrou em combate com §d" + hitter.getName());
					hitter.sendMessage(
							String.valueOf(Main.prefix) + " §8➸ §7Voce entrou em combate com §d" + p.getName());
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						public void run() {
							CombatLog.Sair.remove(p.getName());
							CombatLog.Sair.remove(hitter.getName());
							p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Voce nao esta mais em combate!");
							hitter.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Voce nao esta mais em combate!");
						}
					}, 200L);
				}
			}

		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerExit(PlayerQuitEvent e) throws SQLException {
		Player p = e.getPlayer();
		if (Sair.contains(p.getName())) {
			p.setHealth(0.0D);
			p.teleport(p.getWorld().getSpawnLocation());
			Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §d" + p.getName()
					+ " §7foi cagar em combate e perdeu §d100 §7Dolls§7!");
			ZeyCoins.removeMoney(p, 100);
		}

	}

	@EventHandler
	public void onMe2(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (Sair.contains(p.getName()) && event.getMessage().toLowerCase().startsWith("/")) {
			event.setCancelled(true);
			p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVoce está em combate!");
		}

	}
}
