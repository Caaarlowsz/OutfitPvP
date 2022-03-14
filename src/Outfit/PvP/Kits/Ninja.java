package Outfit.PvP.Kits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Outfit.PvP.Essencial.KitAPI;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Ninja implements Listener {
	public static HashMap<Player, Player> a = new HashMap<>();
	public static HashMap<Player, Long> b = new HashMap<>();
	public static List<Player> cooldownbk = new ArrayList<>();

	public Ninja(OutfitPvP main) {
	}

	@EventHandler
	public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (paramEntityDamageByEntityEvent.getDamager() instanceof Player
				&& paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (KitAPI.Ninja.contains(localPlayer1.getName())) {
				a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						Ninja.cooldownbk.remove(localPlayer1);
					}
				}, 60L);
			}
		}

	}

	@EventHandler
	public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		Player localPlayer2;
		if (paramPlayerToggleSneakEvent.isSneaking() && KitAPI.Ninja.contains(localPlayer1.getName())
				&& a.containsKey(localPlayer1) && (localPlayer2 = a.get(localPlayer1)) != null
				&& !localPlayer2.isDead()) {
			String str = null;
			if (b.get(localPlayer1) != null) {
				long l = b.get(localPlayer1) - System.currentTimeMillis();
				DecimalFormat localDecimalFormat = new DecimalFormat("##");
				int i = (int) l / 1000;
				str = localDecimalFormat.format(i);
			}

			if (b.get(localPlayer1) != null && b.get(localPlayer1) >= System.currentTimeMillis()) {
				localPlayer1.sendMessage(OutfitPvP.prefix + " §8➸ §cAguarde " + str + " segundos");
			} else if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D) {
				if (Gladiator.lutando.containsKey(localPlayer2)) {
					localPlayer1.sendMessage(
                            OutfitPvP.prefix + " §8➸ §cEste jogador está em um duelo nas alturas!");
					return;
				}

				if (Gladiator.lutando.containsKey(localPlayer1)) {
					localPlayer1.sendMessage(OutfitPvP.prefix
							+ " §8➸ §cVocê não pode utilizar o kit Ninja durante um duelo no Gladiator!");
					return;
				}

				localPlayer1.teleport(localPlayer2.getLocation());
				localPlayer1.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê usou seu ninja.");
				b.put(localPlayer1, System.currentTimeMillis() + 6000L);
			} else {
				localPlayer1.sendMessage(
                        OutfitPvP.prefix + " §8➸ §cO ultimo jogador(a) hitado se afastou muito de você.");
			}
		}

	}
}
