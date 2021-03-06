package Outfit.PvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import Outfit.PvP.Essencial.KitAPI;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class TimeLord implements Listener {
	public static ArrayList<String> freeze;
	public static ArrayList<String> freezing;
	public ArrayList<String> frozenPlayers;
	public static ArrayList<String> cooldownt;

	static {
		TimeLord.freeze = new ArrayList<String>();
		TimeLord.freezing = new ArrayList<String>();
		TimeLord.cooldownt = new ArrayList<String>();
	}

	public TimeLord() {
		this.frozenPlayers = new ArrayList<String>();
	}

	@EventHandler
	public void timelordkit(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& player.getItemInHand().getType() == Material.WATCH
				&& KitAPI.TimeLord.contains(event.getPlayer().getName())) {
			if (TimeLord.cooldownt.contains(player.getName())) {
				player.sendMessage(OutfitPvP.prefix + " §8➸ §cAguarde o cooldown terminar.");
			} else {
				for (final Entity frozen : player.getNearbyEntities(2.0, 3.0, 2.0)) {
					if (frozen != null && frozen instanceof Player) {
						TimeLord.freeze.add(((Player) frozen).getName());
						if (TimeLord.freezing.contains(player.getName())) {
							continue;
						}
						player.getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 10);
						player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0f, 1.0f);
						TimeLord.freezing.add(player.getName());
						TimeLord.cooldownt.add(player.getName());
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstace(),
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        TimeLord.freezing.remove(player.getName());
                                        TimeLord.cooldownt.remove(player.getName());
                                        player.sendMessage(
OutfitPvP.prefix + " §8➸ §aSeu cooldown terminou.");
                                    }
                                }, 500L);
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (TimeLord.freeze.contains(player.getName()) && !TimeLord.freezing.contains(player.getName())) {
			event.setTo(player.getLocation());
			player.sendMessage(OutfitPvP.prefix + " §8➸ §cUm §e§lTIMELORD§c congelou o tempo.");
			OutfitPvP.getInstace().getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstace(),
                    new Runnable() {
                        @Override
                        public void run() {
                            TimeLord.freeze.remove(player.getName());
                        }
                    }, 100L);
		}
	}
}
