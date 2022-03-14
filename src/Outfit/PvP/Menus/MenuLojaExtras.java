package Outfit.PvP.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Outfit.PvP.Config.ZeyCoins;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class MenuLojaExtras implements Listener, CommandExecutor {
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack vidro2;
	public static ItemMeta vidro2meta;
	public static ItemStack ninja;
	public static ItemMeta ninjameta;
	public static ItemStack viking;
	public static ItemMeta vikingmeta;
	public static ItemStack stomper;
	public static ItemMeta stompermeta;
	public static ItemStack viper;
	public static ItemMeta vipermeta;
	public static ItemStack snail;
	public static ItemMeta snailmeta;
	public static ItemStack fisherman;
	public static ItemMeta fishermanmeta;
	public static ItemStack thor;
	public static ItemMeta thormeta;
	public static ItemStack xp;
	public static ItemMeta xpmeta;
	public static ItemStack coisa;
	public static ItemMeta coisameta;

	public MenuLojaExtras(final OutfitPvP main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			inv.getTitle().equals("§8[§dLOJAS EXTRAS§8]");

			if (e.getCurrentItem().isSimilar(MenuLojaExtras.viking)) {
				if (ZeyCoins.getPlayerMoney(p) >= 10000) {
					ZeyCoins.removeMoney(p, 10000);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add zey.pvp.falarcolorido");
					p.sendMessage(OutfitPvP.prefix + " §8➸ §7Voc\u00ea Agora Pode §a§lFALAR COLORIDO");
					e.setCancelled(true);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
				} else if (ZeyCoins.getPlayerMoney(p) < 10000) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cMoedas Insuficientes");
					e.setCancelled(true);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
				}
			}
			if (e.getCurrentItem().isSimilar(MenuLojaExtras.ninja)) {
				if (ZeyCoins.getPlayerMoney(p) >= 50000) {
					ZeyCoins.removeMoney(p, 50000);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.*");
					p.sendMessage(OutfitPvP.prefix + " §8➸ §7Voc\u00ea Agora tem todos os §a§lKITS");
					e.setCancelled(true);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
				} else if (ZeyCoins.getPlayerMoney(p) < 50000) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cMoedas Insuficientes");
					e.setCancelled(true);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("lojaextras")) {
			final Inventory warps = Bukkit.createInventory(p, 27, "§8[§dLOJAS EXTRAS§8]");

			final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
			final ItemMeta vidrox = vidro.getItemMeta();
			vidrox.setDisplayName("§6§lKombo§f§lPvP");
			vidro.setItemMeta(vidrox);

			final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
			final ItemMeta vidrom2 = vidro.getItemMeta();
			vidrom2.setDisplayName("§6§lKombo§f§lPvP");
			vidro2.setItemMeta(vidrom2);

			final ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
			final ItemMeta vidrom3 = vidro.getItemMeta();
			vidrom3.setDisplayName("§6§lKombo§f§lPvP");
			vidro3.setItemMeta(vidrom3);

			warps.setItem(1, vidro2);
			warps.setItem(2, vidro);
			warps.setItem(3, vidro2);
			warps.setItem(4, vidro);
			warps.setItem(5, vidro2);
			warps.setItem(6, vidro);
			warps.setItem(7, vidro2);
			warps.setItem(8, vidro);
			warps.setItem(9, vidro3);
			warps.setItem(10, vidro3);
			warps.setItem(11, vidro3);
			warps.setItem(13, vidro3);
			warps.setItem(15, vidro3);
			warps.setItem(16, vidro3);
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

			final ItemStack event45 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta event45v = event45.getItemMeta();
			event45v.setDisplayName("§c§lVOLTAR");
			event45.setItemMeta(event45v);
			warps.setItem(0, event45);

			final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
			final ItemMeta loja23v = loja23.getItemMeta();
			loja23v.setDisplayName("§7=");
			loja23.setItemMeta(loja23v);

			MenuLojaExtras.ninja = new ItemStack(Material.CHEST);
			(MenuLojaExtras.ninjameta = MenuLojaExtras.ninja.getItemMeta())
					.setDisplayName("§dFullKit §f- §d50,000 Dolls.");
			MenuLojaExtras.ninja.setItemMeta(MenuLojaExtras.ninjameta);
			for (int i = 0; i != 54; ++i) {
				warps.setItem(14, MenuLojaExtras.ninja);
			}

			MenuLojaExtras.viking = new ItemStack(Material.BOOK);
			(MenuLojaExtras.vikingmeta = MenuLojaExtras.viking.getItemMeta())
					.setDisplayName("§dFalar Colorido §f- §d10,000 Dolls.");
			MenuLojaExtras.viking.setItemMeta(MenuLojaExtras.vikingmeta);
			for (int i = 0; i != 54; ++i) {
				warps.setItem(12, MenuLojaExtras.viking);
			}
			p.openInventory(warps);
			return true;
		}
		return true;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dLOJAS EXTRAS§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuLojaVips.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
		}
	}
}
