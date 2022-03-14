package Outfit.PvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.Essencial.KitAPI;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Gladiator implements Listener {
	public Plugin plugin;
	private final List<Block> gladiatorbloco;
	private final HashMap<Block, Player> gladblock;
	static HashMap<Player, Player> lutando;
	private final HashMap<Player, Location> lugar;
	private int glad1;
	private int glad2;

	public Gladiator(final OutfitPvP plugin) {
		this.gladiatorbloco = new ArrayList<Block>();
		this.gladblock = new HashMap<Block, Player>();
		Gladiator.lutando = new HashMap<Player, Player>();
		this.lugar = new HashMap<Player, Location>();
		this.plugin = plugin;
	}

	@EventHandler
	void KitGladiator(final PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			final Player r = (Player) e.getRightClicked();
			if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.Gladiator.contains(p.getName())) {
				final Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 80.0,
						p.getLocation().getZ());
				final Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() + 8,
                        p.getLocation().getBlockY() + 82, p.getLocation().getBlockZ() + 8);
				final Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() - 8,
                        p.getLocation().getBlockY() + 82, p.getLocation().getBlockZ() - 8);
				if (Gladiator.lutando.containsKey(p) || Gladiator.lutando.containsKey(r)) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê já está em uma arena Gladiator.");
					return;
				}
				final List<Location> cuboid = new ArrayList<Location>();
				for (int bX = -10; bX <= 10; ++bX) {
					for (int bZ = -10; bZ <= 10; ++bZ) {
						for (int bY = -1; bY <= 10; ++bY) {
							final Block b = loc.clone().add(bX, bY, bZ).getBlock();
							if (!b.isEmpty()) {
								p.sendMessage(
                                        OutfitPvP.prefix + " §8➸ §cVocê não pode ultilizar esse kit aqui.");
								return;
							}
							if (bY == 10) {
								cuboid.add(loc.clone().add(bX, bY, bZ));
							} else if (bY == -1) {
								cuboid.add(loc.clone().add(bX, bY, bZ));
							} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
								cuboid.add(loc.clone().add(bX, bY, bZ));
							}
						}
					}
				}
				for (final Location loc4 : cuboid) {
					loc4.getBlock().setType(Material.GLASS);
					this.gladiatorbloco.add(loc4.getBlock());
					this.gladblock.put(loc4.getBlock(), p);
					this.gladblock.put(loc4.getBlock(), r);
				}
				this.lugar.put(p, p.getLocation());
				this.lugar.put(r, r.getLocation());
				p.teleport(loc2);
				r.teleport(loc3);
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
				r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
				Gladiator.lutando.put(p, r);
				Gladiator.lutando.put(r, p);
				this.glad1 = Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstance1(),
                        new Runnable() {
                            @Override
                            public void run() {
                            }
                        }, 4800L);
				this.glad2 = Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getInstance1(),
                        new Runnable() {
                            @SuppressWarnings("unlikely-arg-type")
                            @Override
                            public void run() {
                                if (Gladiator.lutando.containsKey(p) && Gladiator.lutando.containsKey(r)) {
                                    Gladiator.lutando.remove(p);
                                    Gladiator.lutando.remove(r);
                                    p.teleport(Gladiator.this.lugar.get(p));
                                    r.teleport(Gladiator.this.lugar.get(r));
                                    for (final Block glad : Gladiator.this.gladiatorbloco) {
                                        if ((Gladiator.this.gladblock.get(glad) == r
                                                || Gladiator.this.gladblock.get(glad) == p)
                                                && glad.getType() == Material.GLASS) {
                                            glad.setType(Material.AIR);
                                        }
                                    }
                                    Gladiator.this.lugar.remove(p);
                                    Gladiator.this.lugar.remove(r);
                                    Gladiator.this.gladblock.remove(p);
                                    Gladiator.this.gladblock.remove(r);
                                }
                            }
                        }, 6000L);
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void KitGladiatorInteragir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (this.gladiatorbloco.contains(p) && p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void KitGladiatorSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.lutando.containsKey(p)) {
			final String nome = Gladiator.lutando.get(p).getName();
			final Player q = Bukkit.getPlayer(nome);
			Gladiator.lutando.remove(p);
			Gladiator.lutando.remove(q);
			q.sendMessage(OutfitPvP.prefix + " §8➸ §cO jogador(a): §e§l" + p.getDisplayName()
					+ " §cdeslogou no gladiator.");
			q.teleport(this.lugar.get(q));
			Bukkit.getScheduler().cancelTask(this.glad1);
			Bukkit.getScheduler().cancelTask(this.glad2);
			for (final Block glad : this.gladiatorbloco) {
				if ((this.gladblock.get(glad) == q || this.gladblock.get(glad) == p)
						&& glad.getType() == Material.GLASS) {
					glad.setType(Material.AIR);
				}
			}
			this.gladblock.remove(p);
			this.gladblock.remove(q);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void KitGladiatorMorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (Gladiator.lutando.containsKey(p)) {
			final String nome = Gladiator.lutando.get(p).getName();
			final Player m = Bukkit.getPlayer(nome);
			m.sendMessage(OutfitPvP.prefix + " §8➸ §7Você §a§lGANHOU§7 a batalha no Gladiator.");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você §c§lPERDEU§7 a batalha no Gladiator.");
			Gladiator.lutando.remove(p);
			Gladiator.lutando.remove(m);
			m.teleport(this.lugar.get(m));
			m.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
			Bukkit.getScheduler().cancelTask(this.glad1);
			Bukkit.getScheduler().cancelTask(this.glad2);
			for (final Block glad : this.gladiatorbloco) {
				if ((this.gladblock.get(glad) == m || this.gladblock.get(glad) == p)
						&& glad.getType() == Material.GLASS) {
					glad.setType(Material.AIR);
				}
			}
			this.gladblock.remove(p);
			this.gladblock.remove(m);
		}
	}

	@EventHandler
	void KitGladiatorComando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.lutando.containsKey(p)) {
			e.setCancelled(true);
			p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não pode executar comandos na Arena Gladiator.");
		}
	}
}
