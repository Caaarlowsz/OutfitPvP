package Outfit.PvP.OneVsOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Essencial.API;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Utils.Proteção;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Events1v1 implements Listener {
	public static List<Player> ChamouDuelo = new ArrayList();
	public static List<Player> AceitarDuelo = new ArrayList();
	public static List<Player> Jogando1v1Player = new ArrayList();
	public static List<Player> congelar = new ArrayList();
	public static List<Player> inPvP = new ArrayList();
	public static HashMap<String, String> JogandoSair = new HashMap();

	@EventHandler
	public void PlayerInteractEntityEvent4(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (event.getRightClicked() instanceof Player) {
			if (p.getItemInHand().equals(Join1v1.Item_)) {
				if (ChamouDuelo.contains(p)) {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cAguarde para desafiar outro jogador...");
					return;
				}

				final Player Player2 = (Player) event.getRightClicked();
				AceitarDuelo.add(Player2);
				ChamouDuelo.add(p);
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você desafiou o jogador: §d" + Player2.getName()
						+ " §7para um duelo!");
				Player2.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você foi desafiado por: §d" + p.getName()
						+ " §7para um duelo!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						if (Events1v1.ChamouDuelo.contains(p)) {
							Events1v1.ChamouDuelo.remove(p);
							Events1v1.AceitarDuelo.remove(Player2);
						}

					}
				}, 100L);
			}

		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (congelar.contains(player)) {
			event.setTo(player.getLocation());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					Events1v1.congelar.remove(player);
				}
			}, 0L);
		}

	}

	@EventHandler
	public void PlayerInteractEntityEvent3(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (event.getRightClicked() instanceof Player) {
			if (AceitarDuelo.contains(p) && p.getItemInHand().equals(Join1v1.Item_)) {
				final Player Player2 = (Player) event.getRightClicked();
				if (ChamouDuelo.contains(Player2)) {
					Jogando1v1Player.add(p);
					Jogando1v1Player.add(Player2);
					JogandoSair.put(p.getName(), Player2.getName());
					JogandoSair.put(Player2.getName(), p.getName());
					congelar.add(p);
					congelar.add(Player2);
					Proteção.setImortal(Player2, false);
					Proteção.setImortal(p, false);
					World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("loc2.world"));
					double x = Main.instance.getConfig().getDouble("loc2.x");
					double y = Main.instance.getConfig().getDouble("loc2.y");
					double z = Main.instance.getConfig().getDouble("loc2.z");
					Location loc2 = new Location(w, x, y, z);
					loc2.setPitch((float) Main.instance.getConfig().getDouble("loc2.pitch"));
					loc2.setYaw((float) Main.instance.getConfig().getDouble("loc2.yaw"));
					Player2.teleport(loc2);
					World a = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("loc1.world"));
					double b = Main.instance.getConfig().getDouble("loc1.x");
					double c = Main.instance.getConfig().getDouble("loc1.y");
					double d = Main.instance.getConfig().getDouble("loc1.z");
					Location loc1 = new Location(a, b, c, d);
					loc1.setPitch((float) Main.instance.getConfig().getDouble("loc1.pitch"));
					loc1.setYaw((float) Main.instance.getConfig().getDouble("loc1.yaw"));
					p.teleport(loc1);

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
					ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
					Espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
					ItemMeta Espada2 = Espada.getItemMeta();
					Espada2.setDisplayName("§5§oEspada");
					Espada.setItemMeta(Espada2);
					p.getInventory().addItem(new ItemStack[] { Espada });
					Player2.getInventory().addItem(new ItemStack[] { Espada });
					Player2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					Player2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					Player2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					Player2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));

					for (int i = 1; i < 9; ++i) {
						ItemStack Fisherman = new ItemStack(Material.MUSHROOM_SOUP);
						p.getInventory().addItem(new ItemStack[] { Fisherman });
						Player2.getInventory().addItem(new ItemStack[] { Fisherman });
						Player2.updateInventory();
						p.updateInventory();
						if (Speed1v1.Iniciou.contains(p)) {
							Speed1v1.Iniciou.remove(p);
							Speed1v1.NeginhoSegundos.remove(p);
							Speed1v1.Partida1 = false;
						}

						if (Speed1v1.Iniciou.contains(Player2)) {
							Speed1v1.Iniciou.remove(Player2);
							Speed1v1.NeginhoSegundos.remove(Player2);
							Speed1v1.Partida1 = false;
						}

						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
							public void run() {
								for (Player plr : Bukkit.getOnlinePlayers()) {
									Player2.hidePlayer(plr);
									p.hidePlayer(plr);
									p.showPlayer(Player2);
									Player2.showPlayer(p);
								}
							}
						}, 2L);

						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
								}

							}
						}, 20L);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
								}

							}
						}, 40L);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
									Events1v1.congelar.remove(p);
								}

							}
						}, 60L);
					}
				}
			}

		}
	}

	@EventHandler
	public void Morrer2(PlayerDeathEvent e) {
		final Player v = e.getEntity();
		e.setDeathMessage("");
		if (e.getEntity().getKiller() instanceof Player) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if (!Jogando1v1Player.contains(m) && !Jogando1v1Player.contains(v)) {
					Jogando1v1Player.remove(v);
					Jogando1v1Player.remove(m);
					return;
				}

				int amountv = this.itemsInInventory(v.getInventory(), new Material[] { Material.MUSHROOM_SOUP });
				int amountm = this.itemsInInventory(m.getInventory(), new Material[] { Material.MUSHROOM_SOUP });
				inPvP.remove(m);
				inPvP.remove(v);
				m.sendMessage(" ");
				m.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVocê ganhou o duelo contra " + v.getName()
						+ "§a com §a§l" + amountv + " §asopas.");
				m.sendMessage(" ");
				TheTitle.sendTitle(m, "§d§l1v1");
				TheTitle.sendSubTitle(m, "§7Voce ganhou a batalha contra: §d" + v.getName());
				Proteção.setImortal(v, true);
				Proteção.setImortal(m, true);
				v.sendMessage(" ");
				v.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê perdeu o duelo contra " + m.getName()
						+ ". §cO jogador estava com §c§l" + amountm + " §csopas.");
				v.sendMessage(" ");
				TheTitle.sendTitle(v, "§d§l1v1");
				TheTitle.sendSubTitle(v, "§7Voce perdeu a batalha contra: §d" + m.getName());
				World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("1v1.world"));
				double x = Main.instance.getConfig().getDouble("1v1.x");
				double y = Main.instance.getConfig().getDouble("1v1.y");
				double z = Main.instance.getConfig().getDouble("1v1.z");
				final Location spawn = new Location(w, x, y, z);
				spawn.setPitch((float) Main.instance.getConfig().getDouble("1v1.pitch"));
				spawn.setYaw((float) Main.instance.getConfig().getDouble("1v1.yaw"));
				m.teleport(spawn);
				API.spawnFirework(m.getLocation());
				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents((ItemStack[]) null);
				m.getInventory().clear();

				for (PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						v.teleport(spawn);
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents((ItemStack[]) null);
						v.getInventory().clear();

						for (PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);

				Habilidade.setAbility(m, "1v1");
				Habilidade.setAbility(v, "1v1");
				Jogando1v1Player.remove(v);
				Jogando1v1Player.remove(m);
				JogandoSair.remove(m.getName());
				JogandoSair.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						v.getInventory().clear();
						m.getInventory().clear();
						v.getInventory().setItem(3, Join1v1.Item_);
						v.getInventory().setItem(5, Join1v1.Cinza);
						m.getInventory().setItem(3, Join1v1.Item_);
						m.getInventory().setItem(5, Join1v1.Cinza);
						m.updateInventory();
						v.updateInventory();
						WarpAPI.setWarp(m, "1v1");
						Habilidade.setAbility(m, "1v1");
						Habilidade.setAbility(v, "1v1");
						WarpAPI.setWarp(v, "1v1");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);

				m.setHealth(20);
				v.setHealth(20);
				for (Player plr : Bukkit.getOnlinePlayers()) {
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
			Player t = Bukkit.getServer().getPlayer((String) JogandoSair.get(p.getName()));
			World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("1v1.world"));
			double x = Main.instance.getConfig().getDouble("1v1.x");
			double y = Main.instance.getConfig().getDouble("1v1.y");
			double z = Main.instance.getConfig().getDouble("1v1.z");
			Location spawn = new Location(w, x, y, z);
			spawn.setPitch((float) Main.instance.getConfig().getDouble("1v1.pitch"));
			spawn.setYaw((float) Main.instance.getConfig().getDouble("1v1.yaw"));
			t.teleport(spawn);
			JogandoSair.remove(t.getName());
			JogandoSair.remove(p.getName());
			Jogando1v1Player.remove(p);
			Jogando1v1Player.remove(t);
			inPvP.remove(p);
			inPvP.remove(t);
			t.setMaxHealth(20.0D);
			t.setHealth(20.0D);
			Proteção.setImortal(t, true);
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents((ItemStack[]) null);
			t.getInventory().clear();

			for (PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}

			t.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7O jogador §d§l" + p.getName()
					+ " §7deslogou durante o duelo!");
			t.getInventory().setItem(3, Join1v1.Item_);
			t.getInventory().setItem(5, Join1v1.Cinza);
			Habilidade.setAbility(t, "1v1");
			t.updateInventory();
			for (Player plr : Bukkit.getOnlinePlayers()) {
				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (WarpAPI.getWarp(p) == "1v1" && !Jogando1v1Player.contains(p) && !event.getMessage().startsWith("/spawn")
				&& !event.getMessage().startsWith("/score")) {
			event.getPlayer().sendMessage(String.valueOf(Main.prefix)
					+ " §8➸ §cVocê não pode utilizar comandos na §l1v1§7. §cUtilize /spawn§7!");
			event.setCancelled(true);
		}

	}

	@EventHandler
	public void cmda(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (Jogando1v1Player.contains(p) && WarpAPI.getWarp(p) == "1v1" && !event.getMessage().startsWith("/score")) {
			event.getPlayer().sendMessage(String.valueOf(Main.prefix)
					+ " §8➸ §cVocê está impossibilitado de utilizar comandos durante o duelo!");
			event.setCancelled(true);
		}

	}

	public int itemsInInventory(Inventory inventory, Material[] search) {
		List wanted = Arrays.asList(search);
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
		for (Player pl : Bukkit.getOnlinePlayers())
			if (Jogando1v1Player.contains(pl)) {
				pl.hidePlayer(p);
			}
	}
}
