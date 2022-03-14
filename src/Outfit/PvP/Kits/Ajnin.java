package Outfit.PvP.Kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Ajnin implements Listener {
	public HashMap<Player, Player> ajinhash = new HashMap<Player, Player>();
	public HashMap<Player, Long> ajincooldown = new HashMap<Player, Long>();

	@EventHandler
	public void a(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player p = (Player) e.getDamager();
			Player t = (Player) e.getEntity();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin")) {
				this.ajinhash.put(p, t);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstace(), new Runnable() {
					public void run() {
					}
				}, 200L);
			}
		}

	}

	@EventHandler
	public void aPlayerToggle(PlayerToggleSneakEvent e) {
		final Player p = e.getPlayer();
		if (Cooldown.add(p)) {
			KitUtil.MensagemCooldown(p);
		} else {
			if (e.isSneaking() && Habilidade.getAbility(p).equalsIgnoreCase("Ajnin") && this.ajinhash.containsKey(p)) {
				Player t = this.ajinhash.get(p);
				if (t != null && !t.isDead()) {
					if (this.ajincooldown.get(p) != null) {
						new DecimalFormat("##");
					}

					if (p.getLocation().distance(t.getLocation()) < 100.0D) {
						if (Gladiator.lutando.containsKey(t)) {
							p.sendMessage(
                                    OutfitPvP.prefix + " §8➸ §cEste jogador está em um duelo nas alturas!");
							return;
						}

						if (Gladiator.lutando.containsKey(p)) {
							p.sendMessage(OutfitPvP.prefix
									+ " §8➸ §cVocê não pode utilizar o kit Ajnin durante um duelo no Gladiator!");
							return;
						}

						t.teleport(p.getLocation());
						p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê teleportou o jogador(a) para você.");
						Cooldown.add(p, 6);
						Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstace(), new Runnable() {
							public void run() {
								KitUtil.ccooldown(p);
							}
						}, 140L);
					} else {
						p.sendMessage(OutfitPvP.prefix
								+ " §8➸ §cO ultimo jogador(a) hitado se afastou muito de você.");
					}
				}
			}

		}
	}

	@EventHandler
	public void aomorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player t = this.ajinhash.get(p);
		this.ajinhash.remove(t);
		this.ajinhash.remove(p);
	}

	@EventHandler
	public void aosair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Player t = this.ajinhash.get(p);
		this.ajinhash.remove(t);
		this.ajinhash.remove(p);
	}
}
