package Outfit.PvP.DollsDay;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import Outfit.PvP.Config.ZeyCoins;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class XpDiario implements Listener {
	public static ArrayList<String> XPDIARIOaladdin = new ArrayList<>();
	public static ArrayList<String> XPDIARIOwaterbender = new ArrayList<>();
	public static ArrayList<String> XPDIARIOfirebender = new ArrayList<>();
	public static ArrayList<String> kitdiraioironman = new ArrayList<>();
	public static ArrayList<String> XPDIARIOlumberjack = new ArrayList<>();
	public static ArrayList<String> XPDIARIOmerlin = new ArrayList<>();
	public static ArrayList<String> XPDIARIOkangaroo = new ArrayList<>();
	public static ArrayList<String> XPDIARIOgladiator = new ArrayList<>();
	public static ArrayList<String> XPDIARIOgrappler = new ArrayList<>();
	public static ArrayList<String> setandokit = new ArrayList<>();

	public static void playFirework(Location location, Color color, Player p) {
		Firework firework = location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(FireworkEffect.builder().withColor(color).build());
		firework.setFireworkMeta(fMeta);
		firework.setVelocity(new Vector(0.0D, -1.0D, 0.0D));
	}

	public void playFirework(Location location, FireworkEffect effecta, Player p) {
		Firework firework = location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(effecta);
		firework.setFireworkMeta(fMeta);
	}

	@SuppressWarnings("unused")
	@EventHandler
	public void aoClicarNoInv(InventoryClickEvent e) {
		Player jogador = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dDOLLS DIARIO§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
		}
	}

	public static void Inventario(final Player jogador) {
		final Inventory random = Bukkit.createInventory(jogador, 9, "§8[§dDOLLS DIARIO§8]");

		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("§dSorteando seus Dolls...");
		vidro.setItemMeta(vidrometa);

		final ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
		ItemMeta vidrometa1 = vidro.getItemMeta();
		vidrometa.setDisplayName("§dSorteando seus Dolls...");
		vidro1.setItemMeta(vidrometa1);

		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		ItemMeta vidrometa2 = vidro2.getItemMeta();
		vidrometa2.setDisplayName("§dSorteando seus Dolls...");
		vidro2.setItemMeta(vidrometa2);

		final ItemStack espadademadeira = new ItemStack(Material.GOLD_INGOT);
		ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
		espadademadeiraa.setDisplayName("§d100§7 Dolls");
		espadademadeira.setItemMeta(espadademadeiraa);

		final ItemStack sopa = new ItemStack(Material.GOLD_INGOT);
		ItemMeta sopaa = sopa.getItemMeta();
		sopaa.setDisplayName("§d200§7 Dolls");
		sopa.setItemMeta(sopaa);

		final ItemStack maçadourada = new ItemStack(Material.GOLD_INGOT);
		ItemMeta maçadouradaa = maçadourada.getItemMeta();
		maçadouradaa.setDisplayName("§d300§7 Dolls");
		maçadourada.setItemMeta(maçadouradaa);

		final ItemStack espadadepedra = new ItemStack(Material.GOLD_INGOT);
		ItemMeta espadadepedraa = espadadepedra.getItemMeta();
		espadadepedraa.setDisplayName("§d400§7 Dolls");
		espadadepedra.setItemMeta(espadadepedraa);

		final ItemStack xp = new ItemStack(Material.GOLD_INGOT);
		ItemMeta xpa = xp.getItemMeta();
		xpa.setDisplayName("§d500§7 Dolls");
		xp.setItemMeta(xpa);

		final ItemStack lumberjack = new ItemStack(Material.GOLD_INGOT);
		ItemMeta lumberjacka = lumberjack.getItemMeta();
		lumberjacka.setDisplayName("§d600§7 Dolls");
		lumberjack.setItemMeta(lumberjacka);

		final ItemStack enderperal = new ItemStack(Material.GOLD_INGOT);
		ItemMeta enderperala = enderperal.getItemMeta();
		enderperala.setDisplayName("§d700§7 Dolls");
		enderperal.setItemMeta(enderperala);

		final ItemStack grappler = new ItemStack(Material.GOLD_INGOT);
		ItemMeta grapplera = grappler.getItemMeta();
		grapplera.setDisplayName("§d800§7 Dolls");
		grappler.setItemMeta(grapplera);

		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 5L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(1, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(2, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 15L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(3, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 25L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(5, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(6, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 35L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(7, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(8, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 45L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro);
				random.setItem(1, vidro);
				random.setItem(2, vidro);
				random.setItem(3, vidro);
				random.setItem(4, vidro);
				random.setItem(5, vidro);
				random.setItem(6, vidro);
				random.setItem(7, vidro);
				random.setItem(8, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 55L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(1, vidro2);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 60L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(2, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 65L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(3, vidro2);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 70L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 75L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(5, vidro2);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 80L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(6, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 85L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(7, vidro2);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 90L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				random.setItem(8, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10.0F, 10.0F);
			}
		}, 95L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(7) + 1;

				if (gg == 1) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, espadademadeira);
					XpDiario.XPDIARIOfirebender.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d100 §7Dolls!");
					ZeyCoins.addMoney(jogador, 100);
				}

				if (gg == 2) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, sopa);
					XpDiario.XPDIARIOaladdin.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d200 §7Dolls!");
					ZeyCoins.addMoney(jogador, 200);
				}
				if (gg == 3) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, maçadourada);
					XpDiario.XPDIARIOwaterbender.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d300 §7Dolls!");
					ZeyCoins.addMoney(jogador, 300);
				}
				if (gg == 4) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, espadadepedra);
					XpDiario.kitdiraioironman.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d400 §7Dolls!");
					ZeyCoins.addMoney(jogador, 400);
				}
				if (gg == 5) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, xp);
					XpDiario.XPDIARIOgladiator.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d500 §7Dolls!");
					ZeyCoins.addMoney(jogador, 500);
				}
				if (gg == 6) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, lumberjack);
					XpDiario.XPDIARIOlumberjack.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d600 §7Dolls!");
					ZeyCoins.addMoney(jogador, 600);
				}
				if (gg == 7) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, enderperal);
					XpDiario.XPDIARIOkangaroo.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d700 §7Dolls!");
					ZeyCoins.addMoney(jogador, 700);
				}
				if (gg == 8) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					random.setItem(4, grappler);
					XpDiario.XPDIARIOgrappler.add(jogador.getName());
					jogador.sendMessage(
							String.valueOf(OutfitPvP.prefix) + " §8➸ §7Você Ganhou §d800 §7Dolls!");
					ZeyCoins.addMoney(jogador, 800);
				}
			}
		}, 100L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
			public void run() {
				jogador.closeInventory();
			}
		}, 125L);

		jogador.openInventory(random);
	}

	@EventHandler
	public void aoInteragir(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType() == Material.GOLD_NUGGET
				&& (evento.getAction() == Action.RIGHT_CLICK_AIR || evento.getAction() == Action.RIGHT_CLICK_BLOCK)) {

			if (!setandokit.contains(jogador.getName())) {
				jogador.sendMessage(String.valueOf(OutfitPvP.prefix) + " §8➸ §cSistema em manutencão!");
				evento.setCancelled(true);
				return;
			}

			if (setandokit.contains(jogador.getName())) {
				jogador.sendMessage(String.valueOf(OutfitPvP.prefix) + " §8➸ §cVoce ja pegou seus Dolls!");
				evento.setCancelled(true);
				return;
			}
			evento.setCancelled(true);

			Inventario(jogador);

			playFirework(jogador.getLocation(), Color.RED, evento.getPlayer());
			playFirework(jogador.getLocation(), Color.LIME, evento.getPlayer());
			playFirework(jogador.getLocation(), Color.AQUA, evento.getPlayer());

			setandokit.add(jogador.getName());

			Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.instance, new Runnable() {
				public void run() {
					XpDiario.playFirework(jogador.getLocation(), Color.ORANGE, evento.getPlayer());
					XpDiario.playFirework(jogador.getLocation(), Color.GREEN, evento.getPlayer());
					XpDiario.playFirework(jogador.getLocation(), Color.PURPLE, evento.getPlayer());
				}
			}, 20L);
		}
	}
}
