package Outfit.PvP.Sumo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Utils.Proteção;

public class EventsSumo implements Listener {
	public static List<Player> ChamouDuelo = new ArrayList<>();
	public static List<Player> AceitarDuelo = new ArrayList<>();
	public static List<Player> JogandoSumoPlayer = new ArrayList<>();
	public static List<Player> congelar = new ArrayList<>();
	public static List<Player> inPvP = new ArrayList<>();
	public static HashMap<String, String> JogandoSair = new HashMap<>();

	@EventHandler
	public void PlayerInteractEntityEvent4(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (((event.getRightClicked() instanceof Player)) && (p.getItemInHand().equals(JoinSumo.ItemS_))) {
			if (ChamouDuelo.contains(p)) {
				p.sendMessage(OutfitPvP.prefix + " §8-> §cAguarde para desafiar outro jogador...");
				return;
			}
			final Player Player2 = (Player) event.getRightClicked();
			AceitarDuelo.add(Player2);
			ChamouDuelo.add(p);
			p.sendMessage(OutfitPvP.prefix + " §8-> §7Voce desafiou o jogador: §d" + Player2.getName()
					+ " §7para um duelo!");
			Player2.sendMessage(OutfitPvP.prefix + " §8-> §7Voce foi desafiado por: §d" + p.getName()
					+ " §7para um duelo!");
			Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
				public void run() {
					if (EventsSumo.ChamouDuelo.contains(p)) {
						EventsSumo.ChamouDuelo.remove(p);
						EventsSumo.AceitarDuelo.remove(Player2);
					}
				}
			}, 100L);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (congelar.contains(player)) {
			event.setTo(player.getLocation());
			Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
				public void run() {
					EventsSumo.congelar.remove(player);
				}
			}, 50L);
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent3(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (((event.getRightClicked() instanceof Player)) && (AceitarDuelo.contains(p))
				&& (p.getItemInHand().equals(JoinSumo.ItemS_))) {
			final Player Player2 = (Player) event.getRightClicked();
			if (ChamouDuelo.contains(Player2)) {
				JogandoSumoPlayer.add(p);
				JogandoSumoPlayer.add(Player2);
				JogandoSair.put(p.getName(), Player2.getName());
				JogandoSair.put(Player2.getName(), p.getName());
				congelar.add(p);
				congelar.add(Player2);
				Proteção.setImortal(Player2, false);
				Proteção.setImortal(p, false);
				World w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("s2.world"));
				double x = OutfitPvP.instance.getConfig().getDouble("s2.x");
				double y = OutfitPvP.instance.getConfig().getDouble("s2.y");
				double z = OutfitPvP.instance.getConfig().getDouble("s2.z");
				Location s2 = new Location(w, x, y, z);
				s2.setPitch((float) OutfitPvP.instance.getConfig().getDouble("s2.pitch"));
				s2.setYaw((float) OutfitPvP.instance.getConfig().getDouble("s2.yaw"));
				Player2.teleport(s2);
				World a = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("s1.world"));
				double b = OutfitPvP.instance.getConfig().getDouble("s1.x");
				double c = OutfitPvP.instance.getConfig().getDouble("s1.y");
				double d = OutfitPvP.instance.getConfig().getDouble("s1.z");
				Location s1 = new Location(a, b, c, d);
				s1.setPitch((float) OutfitPvP.instance.getConfig().getDouble("s1.pitch"));
				s1.setYaw((float) OutfitPvP.instance.getConfig().getDouble("s1.yaw"));
				p.teleport(s1);

				TheTitle.sendTitle(Player2, " ");
				TheTitle.sendSubTitle(Player2, "§d" + Player2.getName() + " §7vs§d " + p.getName());
				TheTitle.sendTitle(p, " ");
				TheTitle.sendSubTitle(p, "§d" + p.getName() + " §7vs§d " + Player2.getName());

				ChamouDuelo.remove(Player2);
				AceitarDuelo.remove(Player2);
				ChamouDuelo.remove(p);
				AceitarDuelo.remove(p);
				inPvP.add(p);
				inPvP.add(Player2);
				p.getInventory().clear();
				Player2.getInventory().clear();
				Player2.updateInventory();
				p.updateInventory();
				if (SpeedSumo.Iniciou.contains(p)) {
					SpeedSumo.Iniciou.remove(p);
					SpeedSumo.NeginhoSegundos.remove(p);
					SpeedSumo.Partida1 = false;
				}
				if (SpeedSumo.Iniciou.contains(Player2)) {
					SpeedSumo.Iniciou.remove(Player2);
					SpeedSumo.NeginhoSegundos.remove(Player2);
					SpeedSumo.Partida1 = false;
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
					public void run() {
						Player[] arrayOfPlayer;
						int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
						for (int i = 0; i < j; i++) {
							Player plr = arrayOfPlayer[i];
							Player2.hidePlayer(plr);
							p.hidePlayer(plr);
							p.showPlayer(Player2);
							Player2.showPlayer(p);
						}
					}
				}, 2L);

				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						if (EventsSumo.congelar.contains(p)) {
							p.setMaxHealth(20);
							p.setHealth(20);
							Player2.setMaxHealth(20);
							Player2.setHealth(20);
						}
					}
				}, 20L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						if (EventsSumo.congelar.contains(p)) {
							p.setMaxHealth(20);
							p.setHealth(20);
							Player2.setMaxHealth(20);
							Player2.setHealth(20);
						}
					}
				}, 40L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						if (EventsSumo.congelar.contains(p)) {
							p.setMaxHealth(20);
							p.setHealth(20);
							Player2.setMaxHealth(20);
							Player2.setHealth(20);
							EventsSumo.congelar.remove(p);
						}
					}
				}, 60L);
			}
		}
	}

	@EventHandler
	public void Morrer2(PlayerDeathEvent e) {
		final Player v = e.getEntity();
		e.setDeathMessage("");
		if ((e.getEntity().getKiller() instanceof Player)) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if ((!JogandoSumoPlayer.contains(m)) && (!JogandoSumoPlayer.contains(v))) {
					JogandoSumoPlayer.remove(v);
					JogandoSumoPlayer.remove(m);
					return;
				}
				inPvP.remove(m);
				inPvP.remove(v);
				m.sendMessage(" ");
				m.sendMessage(OutfitPvP.prefix + " §8-> §7Voce ganhou o duelo contra: §d" + v.getName());
				m.sendMessage(" ");
				TheTitle.sendTitle(m, "§d§lSUMO");
				TheTitle.sendSubTitle(m, "§7Voce ganhou o duelo contra: §d" + v.getName());
				Proteção.setImortal(v, true);
				Proteção.setImortal(m, true);
				v.sendMessage(" ");
				v.sendMessage(OutfitPvP.prefix + " §8-> §7Voce perdeu o duelo contra: §d" + m.getName());
				v.sendMessage(" ");
				TheTitle.sendTitle(v, "§d§lSUMO");
				TheTitle.sendSubTitle(v, "§7Voce perdeu o duelo contra: §d" + m.getName());
				World w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("sumo.world"));
				double x = OutfitPvP.instance.getConfig().getDouble("sumo.x");
				double y = OutfitPvP.instance.getConfig().getDouble("sumo.y");
				double z = OutfitPvP.instance.getConfig().getDouble("sumo.z");
				final Location spawn = new Location(w, x, y, z);
				spawn.setPitch((float) OutfitPvP.instance.getConfig().getDouble("sumo.pitch"));
				spawn.setYaw((float) OutfitPvP.instance.getConfig().getDouble("sumo.yaw"));
				m.teleport(spawn);

				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents(null);
				m.getInventory().clear();
				for (PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
					public void run() {
						v.teleport(spawn);
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents(null);
						v.getInventory().clear();
						for (PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);

				Habilidade.setAbility(m, "Sumo");
				Habilidade.setAbility(v, "Sumo");
				JogandoSumoPlayer.remove(v);
				JogandoSumoPlayer.remove(m);
				JogandoSair.remove(m.getName());
				JogandoSair.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
					public void run() {
						v.getInventory().clear();
						m.getInventory().clear();
						v.getInventory().setItem(3, JoinSumo.ItemS_);
						v.getInventory().setItem(5, JoinSumo.CinzaS);
						m.getInventory().setItem(3, JoinSumo.ItemS_);
						m.getInventory().setItem(5, JoinSumo.CinzaS);
						m.updateInventory();
						v.updateInventory();
						WarpAPI.setWarp(m, "Sumo");
						Habilidade.setAbility(m, "Sumo");
						Habilidade.setAbility(v, "Sumo");
						WarpAPI.setWarp(v, "Sumo");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);

				m.setHealth(20);
				v.setHealth(20);
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player plr = arrayOfPlayer[i];

					v.showPlayer(plr);
					m.showPlayer(plr);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (JogandoSair.containsKey(p.getName())) {
			Player t = Bukkit.getServer().getPlayer(JogandoSair.get(p.getName()));
			World w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("sumo.world"));
			double x = OutfitPvP.instance.getConfig().getDouble("sumo.x");
			double y = OutfitPvP.instance.getConfig().getDouble("sumo.y");
			double z = OutfitPvP.instance.getConfig().getDouble("sumo.z");
			Location spawn = new Location(w, x, y, z);
			spawn.setPitch((float) OutfitPvP.instance.getConfig().getDouble("sumo.pitch"));
			spawn.setYaw((float) OutfitPvP.instance.getConfig().getDouble("sumo.yaw"));
			t.teleport(spawn);
			JogandoSair.remove(t.getName());
			JogandoSair.remove(p.getName());
			JogandoSumoPlayer.remove(p);
			JogandoSumoPlayer.remove(t);
			inPvP.remove(p);
			inPvP.remove(t);
			t.setMaxHealth(20.0D);
			t.setHealth(20.0D);
			Proteção.setImortal(t, true);
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents(null);
			t.getInventory().clear();
			for (PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}
			t.sendMessage(OutfitPvP.prefix + " §8-> §7O jogador §d§l" + p.getName()
					+ " §7deslogou durante o duelo!");
			t.getInventory().setItem(3, JoinSumo.ItemS_);
			t.getInventory().setItem(5, JoinSumo.CinzaS);
			Habilidade.setAbility(t, "Sumo");
			t.updateInventory();
			Player[] arrayOfPlayer;
			int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
			for (int i = 0; i < j; i++) {
				Player plr = arrayOfPlayer[i];

				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler
	public void onSairWarp(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (SpeedSumo.NeginhoSegundos.contains(p)) {
			SpeedSumo.Partida1 = false;
			SpeedSumo.Nome = "";
			SpeedSumo.Iniciou.remove(p);
			SpeedSumo.NeginhoSegundos.remove(p);
		}
	}

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((WarpAPI.getWarp(p) == "Sumo") && (!JogandoSumoPlayer.contains(p))
				&& (!event.getMessage().startsWith("/spawn")) && (!event.getMessage().startsWith("/score"))) {
			event.getPlayer().sendMessage(OutfitPvP.prefix
					+ " §8-> §cVocê não pode utilizar comandos na §c§lSumo§7. §cUtilize /spawn§7!");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void cmda(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((JogandoSumoPlayer.contains(p)) && (WarpAPI.getWarp(p) == "Sumo")
				&& (!event.getMessage().startsWith("/score"))) {
			event.getPlayer().sendMessage(OutfitPvP.prefix
					+ " §8-> §cVoce está impossibilitado de utilizar comandos durante o duelo!");
			event.setCancelled(true);
		}
	}

	public int itemsInInventory(Inventory inventory, Material[] search) {
		List<Material> wanted = Arrays.asList(search);
		int found = 0;
		ItemStack[] arrayOfItemStack;
		int j = (arrayOfItemStack = inventory.getContents()).length;
		for (int i = 0; i < j; i++) {
			ItemStack item = arrayOfItemStack[i];
			if ((item != null) && (wanted.contains(item.getType()))) {
				found += item.getAmount();
			}
		}
		return found;
	}

	@EventHandler
	public void PlayerInteractEntityEvent2(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player pl = arrayOfPlayer[i];
			if (JogandoSumoPlayer.contains(pl)) {
				pl.hidePlayer(p);
			}
		}
	}
}
