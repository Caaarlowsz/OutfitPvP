package Outfit.PvP.Cassino;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import Outfit.PvP.Config.ConfigManager;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;

public class ApostasListener extends ConfigManager implements Listener {
	public static HashMap<String, Integer> valor = new HashMap<String, Integer>();
	public static HashMap<String, String> apostado = new HashMap<String, String>();
	public static HashMap<String, Integer> numero = new HashMap<String, Integer>();

	public static ItemStack getItem(Material material, String nome, int quantidade, int bite) {
		ItemStack item = new ItemStack(material, quantidade, (short) bite);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(nome);
		item.setItemMeta(meta);
		return item;
	}

	@EventHandler
	public void entitbiausdsan(EntityDamageEvent e) {
		if (e.getEntity() instanceof Villager) {
			Villager v = (Villager) e.getEntity();
			if (v.getCustomName().equalsIgnoreCase("§c§l✽ CASSINO ✽")) {
				e.setCancelled(true);
			}
		}

	}

	@EventHandler
	public void nsaioudnsa(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Villager) {
			Villager v = (Villager) e.getRightClicked();
			if (v.getCustomName().equalsIgnoreCase("§c§lCASSINO")) {
				e.setCancelled(true);
				Seletor(e.getPlayer());
			}
		}

	}

	public static void Seletor(Player p) {
		if (ApostasListener.apostado.containsKey(p.getName())) {
			ApostasListener.apostado.remove(p.getName());
		}

		if (valor.containsKey(p.getName())) {
			valor.remove(p.getName());
		}

		Inventory inv = Bukkit.createInventory((InventoryHolder) null, 36, "§c§lCASSINO");
		ItemStack coins = getItem(Material.GOLD_INGOT, "§6$" + ZeyCoins.getPlayerMoney(p), 1, 0);
		ItemStack milm = getItem(Material.STAINED_CLAY, "§a$1,000", 1, 5);
		ItemStack cincom = getItem(Material.STAINED_CLAY, "§a$5,000", 5, 5);
		ItemStack dezm = getItem(Material.STAINED_CLAY, "§a$10,000", 10, 5);
		ItemStack cinqm = getItem(Material.STAINED_CLAY, "§a$50,000", 50, 5);
		ItemStack ct = getItem(Material.STAINED_CLAY, "§9Azul §7(x2)", 1, 3);
		ItemStack tr = getItem(Material.STAINED_CLAY, "§cVermelho §7(x2)", 1, 14);
		ItemStack gold = getItem(Material.STAINED_CLAY, "§6Ouro §7(x4)", 1, 4);
		ItemStack miln = getItem(Material.STAINED_CLAY, "§c$1,000", 1, 14);
		ItemStack cincon = getItem(Material.STAINED_CLAY, "§c$5,000", 5, 14);
		ItemStack dezn = getItem(Material.STAINED_CLAY, "§c$10,000", 10, 14);
		ItemStack cinqn = getItem(Material.STAINED_CLAY, "§c$50,000", 50, 14);
		ItemStack apostado = getItem(Material.DOUBLE_PLANT,
				"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
		ItemStack glass = getItem(Material.THIN_GLASS, "-", 1, 0);
		inv.setItem(4, coins);
		inv.setItem(12, ct);
		inv.setItem(13, tr);
		inv.setItem(14, gold);
		inv.setItem(27, miln);
		inv.setItem(28, cincon);
		inv.setItem(29, dezn);
		inv.setItem(30, cinqn);
		inv.setItem(31, apostado);
		inv.setItem(35, milm);
		inv.setItem(34, cincom);
		inv.setItem(33, dezm);
		inv.setItem(32, cinqm);
		ItemStack[] arrayOfItemStack;
		int descpyro = (arrayOfItemStack = inv.getContents()).length;

		for (int metapyro = 0; metapyro < descpyro; ++metapyro) {
			ItemStack item = arrayOfItemStack[metapyro];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), glass);
			}
		}

		p.openInventory(inv);
	}

	public static void SeletorApostar(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 18, "§6§lAPOSTANDO...");
		ItemStack ll = getItem(Material.HOPPER, "-", 1, 0);
		inv.setItem(4, ll);
		ItemStack glass = getItem(Material.THIN_GLASS, "-", 1, 0);
		ItemStack[] arrayOfItemStack;
		int descpyro = (arrayOfItemStack = inv.getContents()).length;

		for (int metapyro = 0; metapyro < descpyro; ++metapyro) {
			ItemStack item = arrayOfItemStack[metapyro];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), glass);
			}
		}

		inv.setItem(10, randomItem());
		inv.setItem(11, randomItem());
		inv.setItem(12, randomItem());
		inv.setItem(13, randomItem());
		inv.setItem(14, randomItem());
		inv.setItem(15, randomItem());
		inv.setItem(16, randomItem());
		p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
		numero.put(p.getName(), 0);
		(new BukkitRunnable() {
			public void run() {
				if (p.getInventory() != inv) {
					if ((Integer) ApostasListener.numero.get(p.getName()) < 21) {
						inv.setItem(10, inv.getItem(11));
						inv.setItem(11, inv.getItem(12));
						inv.setItem(12, inv.getItem(13));
						inv.setItem(13, inv.getItem(14));
						inv.setItem(14, inv.getItem(15));
						inv.setItem(15, inv.getItem(16));
						inv.setItem(16, ApostasListener.randomItem());
						p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						ApostasListener.numero.put(p.getName(), (Integer) ApostasListener.numero.get(p.getName()) + 1);
					} else {
						this.cancel();
						if (inv.getItem(13).getData().getData() == 3
								&& ((String) ApostasListener.apostado.get(p.getName())).equalsIgnoreCase("Azul")) {
							p.sendMessage("§aVocê ganhou $" + ApostasListener.getAposta(p) * 2);
							ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 2);
							if (ApostasListener.apostado.containsKey(p.getName())) {
								ApostasListener.apostado.remove(p.getName());
							}

							if (ApostasListener.valor.containsKey(p.getName())) {
								ApostasListener.valor.remove(p.getName());
							}

							return;
						}

						if (inv.getItem(13).getData().getData() == 14
								&& ((String) ApostasListener.apostado.get(p.getName())).equalsIgnoreCase("Vermelho")) {
							p.sendMessage("§aVocê ganhou $" + ApostasListener.getAposta(p) * 2);
							ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 2);
							if (ApostasListener.apostado.containsKey(p.getName())) {
								ApostasListener.apostado.remove(p.getName());
							}

							if (ApostasListener.valor.containsKey(p.getName())) {
								ApostasListener.valor.remove(p.getName());
							}

							return;
						}

						if (inv.getItem(13).getData().getData() == 4
								&& ((String) ApostasListener.apostado.get(p.getName())).equalsIgnoreCase("Ouro")) {
							p.sendMessage("§aVocê ganhou $" + ApostasListener.getAposta(p) * 4);
							ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 4);
							if (ApostasListener.apostado.containsKey(p.getName())) {
								ApostasListener.apostado.remove(p.getName());
							}

							if (ApostasListener.valor.containsKey(p.getName())) {
								ApostasListener.valor.remove(p.getName());
							}

							return;
						}

						if (inv.getItem(0) != null) {
							p.sendMessage("§cInfelizmente, você perdeu.");
							if (ApostasListener.apostado.containsKey(p.getName())) {
								ApostasListener.apostado.remove(p.getName());
							}

							if (ApostasListener.valor.containsKey(p.getName())) {
								ApostasListener.valor.remove(p.getName());
							}
						}
					}
				} else {
					this.cancel();
				}

			}
		}).runTaskTimer(Main.getPlugin(), 0L, 5L);
		p.openInventory(inv);
	}

	public static ItemStack randomItem() {
		ItemStack ct = getItem(Material.STAINED_CLAY, "§9Azul §7(x2)", 1, 3);
		ItemStack tr = getItem(Material.STAINED_CLAY, "§cVermelho §7(x2)", 1, 14);
		ItemStack gold = getItem(Material.STAINED_CLAY, "§6Ouro §7(x4)", 1, 4);
		Random rand = new Random();
		int r = rand.nextInt(100);
		if (r < 45) {
			return ct;
		} else if (r < 90 && r > 45) {
			return tr;
		} else {
			return r > 90 ? gold : ct;
		}
	}

	@EventHandler
	public void inventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getClickedInventory();
		if (inv != null) {
			if (inv.getTitle() != null) {
				if (inv.getTitle().equalsIgnoreCase("§c§lCASSINO")) {
					if (e.getCurrentItem() != null) {
						if (!e.getCurrentItem().hasItemMeta()) {
							e.setCancelled(true);
						} else if (!e.getCurrentItem().getItemMeta().hasDisplayName()) {
							e.setCancelled(true);
						} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("-")) {
							e.setCancelled(true);
						} else if (e.getCurrentItem().getItemMeta().getDisplayName()
								.equalsIgnoreCase("§6$" + ZeyCoins.getPlayerMoney(p))) {
							e.setCancelled(true);
						} else if (e.getCurrentItem().getItemMeta().getDisplayName()
								.equalsIgnoreCase("§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","))) {
							e.setCancelled(true);
							if (getAposta(p) > 0) {
								if (ApostasListener.apostado.containsKey(p.getName())) {
									ZeyCoins.removeMoney(p, getAposta(p));
									SeletorApostar(p);
								} else {
									p.sendMessage("§cVocê tem que apostar em alguma cor!");
								}
							} else {
								p.sendMessage("§cVocê não pode apostar $0");
							}

						} else {
							ItemStack apostado;
							if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$1,000")) {
								e.setCancelled(true);
								if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 1000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) + 1000);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								} else {
									p.sendMessage("§cVocê não possui saldo o suficiente!");
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$5,000")) {
								e.setCancelled(true);
								if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 5000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) + 5000);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								} else {
									p.sendMessage("§cVocê não possui saldo o suficiente!");
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§a$10,000")) {
								e.setCancelled(true);
								if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 10000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) + 10000);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								} else {
									p.sendMessage("§cVocê não possui saldo o suficiente!");
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§a$50,000")) {
								e.setCancelled(true);
								if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + '썐') {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) + '썐');
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								} else {
									p.sendMessage("§cVocê não possui saldo o suficiente!");
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$1,000")) {
								e.setCancelled(true);
								if (getAposta(p) >= 1000) {
									valor.put(p.getName(), getAposta(p) - 1000);
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$5,000")) {
								e.setCancelled(true);
								if (getAposta(p) >= 5000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) - 5000);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§c$10,000")) {
								e.setCancelled(true);
								if (getAposta(p) >= 10000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) - 10000);
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§c$50,000")) {
								e.setCancelled(true);
								if (getAposta(p) >= 50000) {
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
									valor.put(p.getName(), getAposta(p) - '썐');
									apostado = getItem(Material.DOUBLE_PLANT,
											"§aApostar $" + String.valueOf(getAposta(p)).replace(".", ","), 1, 0);
									inv.setItem(31, apostado);
								}

							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§9Azul §7(x2)")) {
								e.setCancelled(true);
								if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
								}

								if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
								}

								if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
								}

								e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
								ApostasListener.apostado.put(p.getName(), "Azul");
							} else if (e.getCurrentItem().getItemMeta().getDisplayName()
									.equalsIgnoreCase("§cVermelho §7(x2)")) {
								e.setCancelled(true);
								if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
								}

								if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
								}

								if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
									inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
								}

								e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
								ApostasListener.apostado.put(p.getName(), "Vermelho");
							} else {
								if (e.getCurrentItem().getItemMeta().getDisplayName()
										.equalsIgnoreCase("§6Ouro §7(x4)")) {
									e.setCancelled(true);
									if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
										inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
									}

									if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
										inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
									}

									if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
										inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
									}

									e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
									ApostasListener.apostado.put(p.getName(), "Ouro");
								}

							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void inventory2(InventoryClickEvent e) {
		Inventory inv = e.getClickedInventory();
		if (inv != null) {
			if (inv.getTitle() != null) {
				if (inv.getTitle().equalsIgnoreCase("§6§lAPOSTANDO...")) {
					if (e.getCurrentItem() != null) {
						if (!e.getCurrentItem().hasItemMeta()) {
							e.setCancelled(true);
						} else {
							if (e.getCurrentItem().getItemMeta().hasDisplayName()) {
								e.setCancelled(true);
							}

						}
					}
				}
			}
		}
	}

	@EventHandler
	public void aa(InventoryCloseEvent e) {
		Inventory inv = e.getInventory();
		if (inv.getTitle() != null && inv.getTitle().equalsIgnoreCase("§6§lAPOSTANDO...")) {
			if (apostado.containsKey(e.getPlayer().getName())) {
				apostado.remove(e.getPlayer().getName());
			}

			if (valor.containsKey(e.getPlayer().getName()) && (Integer) numero.get(e.getPlayer().getName()) < 21) {
				ZeyCoins.addMoney(e.getPlayer().getName(), getAposta((Player) e.getPlayer()));
				valor.remove(e.getPlayer().getName());
			}
		}

	}

	public static int getAposta(Player p) {
		return valor.containsKey(p.getName()) ? (Integer) valor.get(p.getName()) : 0;
	}
}
