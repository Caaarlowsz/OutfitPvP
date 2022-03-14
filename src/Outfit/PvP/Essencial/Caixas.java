package Outfit.PvP.Essencial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Config.ZeyCoins;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Caixas implements Listener {
	public static void caixas(Player p) {
		Inventory warps = Bukkit.createInventory(p, 27, "§8[§dCAIXAS§8]");

		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidrox = vidro.getItemMeta();
		vidrox.setDisplayName("§d§lOutfit§f§lPvP");
		vidro.setItemMeta(vidrox);

		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
		final ItemMeta vidrom2 = vidro.getItemMeta();
		vidrom2.setDisplayName("§d§lOutfit§f§lPvP");
		vidro2.setItemMeta(vidrom2);

		final ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
		final ItemMeta vidrom3 = vidro.getItemMeta();
		vidrom3.setDisplayName("§d§lOutfit§f§lPvP");
		vidro3.setItemMeta(vidrom3);

		ItemStack info = new ItemStack(Material.PAPER);
		ItemMeta metainfo = info.getItemMeta();
		metainfo.setDisplayName("§8§m§l----------------------------------");
		metainfo.setLore(Arrays.asList(
				"   ", "§7Oque sao as §d§lCAIXAS§7?", "   ", "§8§m§l----------------------------------",
				"  ", "§7 As caixas dao vantagens aos jogadores.", "§7 Porem, o jogador so consegue",
				"§7 comprar sua caixa com muito esforço.", "§7 As caixas podem ser compradas pelo site ",
				"§7 ou por dinheiro do jogo.", "   ", "§8§m§l----------------------------------"));
		info.setItemMeta(metainfo);

		ItemStack normal = new ItemStack(Material.getMaterial(328));
		ItemMeta metanormal = normal.getItemMeta();
		metanormal.setDisplayName("§f        » §7Caixa §fNormal §f«");
		ArrayList<String> descnormal1 = new ArrayList<String>();

		descnormal1.add(" ");
		descnormal1.add("§7           Custo: §d$25,000");
		descnormal1.add(" ");
		descnormal1.add("   §f» §7Possiveis Premios §f«");
		descnormal1.add("§7  Tag §9MVP §f(25% de chance)");
		descnormal1.add("§7     §d$30,000 §f(25% de chance)");
		descnormal1.add("§7Kit §dGLADIATOR §f(25% de chance)");
		descnormal1.add("§7Kit §dAVATAR §f(25% de chance)");
		descnormal1.add(" ");
		descnormal1.add("         §fRaridade: §d §d✭§7✭✭");
		metanormal.setLore(descnormal1);
		normal.setItemMeta(metanormal);

		ItemStack ultra = new ItemStack(Material.getMaterial(342));
		ItemMeta metaultra = ultra.getItemMeta();
		metaultra.setDisplayName("§f        » §7Caixa §fUltra §f«");
		ArrayList<String> descultra1 = new ArrayList<String>();

		descultra1.add(" ");
		descultra1.add("§7           Custo: §d$50,000");
		descultra1.add(" ");
		descultra1.add("   §f» §7Possiveis Premios §f«");
		descultra1.add("§7  Tag §aVIP §f(25% de chance)");
		descultra1.add("§7     §d$55,000 §f(25% de chance)");
		descultra1.add("§7Kit §dGRAPPLER §f(25% de chance)");
		descultra1.add("   §7Kit §dSTOMPER §f(25% de chance)");
		descultra1.add(" ");
		descultra1.add("         §fRaridade: §d §d✭✭§7✭");
		metaultra.setLore(descultra1);
		ultra.setItemMeta(metaultra);

		warps.setItem(0, vidro);
		warps.setItem(1, vidro2);
		warps.setItem(2, vidro);
		warps.setItem(3, vidro2);
		warps.setItem(4, vidro);
		warps.setItem(5, vidro2);
		warps.setItem(6, vidro);
		warps.setItem(7, vidro2);
		warps.setItem(8, vidro);
		warps.setItem(9, vidro3);
		warps.setItem(10, normal);
		warps.setItem(11, vidro3);
		warps.setItem(12, vidro3);
		warps.setItem(13, info);
		warps.setItem(14, vidro3);
		warps.setItem(15, vidro3);
		warps.setItem(16, ultra);
		warps.setItem(17, vidro3);
		warps.setItem(18, vidro2);
		warps.setItem(19, vidro);
		warps.setItem(20, vidro2);
		warps.setItem(21, vidro);
		warps.setItem(22, vidro2);
		warps.setItem(23, vidro);
		warps.setItem(24, vidro2);
		warps.setItem(25, vidro);
		warps.setItem(26, vidro2);

		p.openInventory(warps);
	}

	@EventHandler
	public void onPlayerClickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getInventory().getTitle().equalsIgnoreCase("§8[§dCAIXAS§8]")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§f        » §7Caixa §fNormal §f«")) {
				if (ZeyCoins.getPlayerMoney(p) >= 25000) {
					p.closeInventory();
					ZeyCoins.removeMoney(p, 25000);
					Random r = new Random();
					int gg = r.nextInt(4) + 1;
					if (gg == 1) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).removeGroup("normal");
						PermissionsEx.getUser(p).addGroup("mvp");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fTag §9§lMVP");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fTAG §9§lMVP");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 2) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						ZeyCoins.addMoney(p, 30000);
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §f$30,000");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §f$30,000");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 3) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).addPermission("kit.gladiator");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fKit GLADIATOR");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fKit §d§lGLADIATOR");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 4) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).addPermission("kit.avatar");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fKit AVATAR");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fKit §d§lAVATAR");
						API.spawnFirework(p.getLocation());
					}
				} else {
					p.sendMessage("§8❰§c§l!§8❱ §7Para abrir a caixa e necessario ter §c25,000$§7.");
					p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
					e.setCancelled(true);
					p.closeInventory();
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f        » §7Caixa §fUltra §f«")) {
				if (ZeyCoins.getPlayerMoney(p) >= 50000) {
					p.closeInventory();
					ZeyCoins.removeMoney(p, 50000);
					Random r = new Random();
					int gg = r.nextInt(4) + 1;
					if (gg == 1) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).removeGroup("normal");
						PermissionsEx.getUser(p).addGroup("vip");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fTag §aVIP");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fTAG §a§lVIP");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 2) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						ZeyCoins.addMoney(p, 55000);
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §f$55,000");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §f$55,000");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 3) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).addPermission("kit.grappler");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fKit GRAPPLER");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fKit §d§lGRAPPLER");
						API.spawnFirework(p.getLocation());
						return;
					}
					if (gg == 4) {
						p.getWorld().playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 10.0F);
						PermissionsEx.getUser(p).addPermission("kit.stomper");
						PermissionsEx.getPlugin().reloadConfig();
						TheTitle.sendTitle(p, "§dParabéns!");
						TheTitle.sendSubTitle(p, "§7Premio: §fKit STOMPER");
						Bukkit.broadcastMessage(
								"§8❰§d§l!§8❱ §7O jogador §f" + p.getName() + "§7 foi premiado com §fKit §d§lSTOMPER");
						API.spawnFirework(p.getLocation());
					}
				} else {
					p.sendMessage("§8❰§c§l!§8❱ §7Para abrir a caixa e necessario ter §c50,000$§7.");
					p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
					e.setCancelled(true);
					p.closeInventory();
					return;
				}
			}
		}
	}

	@EventHandler
	public void ClicarNoBloco(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.ENDER_CHEST) && (!OutfitPvP.admins.contains(p.getName()))) {
			e.setCancelled(true);
			caixas(p);
			p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
		}
	}
}
