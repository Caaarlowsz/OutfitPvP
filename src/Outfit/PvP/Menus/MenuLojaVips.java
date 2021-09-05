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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuLojaVips implements Listener, CommandExecutor {
	public static void guiKits(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 9, "§8[§dLOJA§8]");
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§6§lKombo§f§lPvP");
		vidro.setItemMeta(vidrom);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(3, vidro);
		inv.setItem(5, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		ItemStack event457 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta eventv1 = event457.getItemMeta();
		eventv1.setDisplayName("§d§lKITS");
		event457.setItemMeta(eventv1);
		inv.setItem(2, event457);
		ItemStack event458 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta eventv2 = event458.getItemMeta();
		eventv2.setDisplayName("§d§lEXTRAS");
		event458.setItemMeta(eventv2);
		inv.setItem(6, event458);
		ItemStack event459 = new ItemStack(Material.EMERALD, 1, (short) 0);
		ItemMeta eventv3 = event459.getItemMeta();
		eventv3.setDisplayName("§d§lVIP & MAIS");
		event459.setItemMeta(eventv3);
		inv.setItem(4, event459);
		int descpyro2 = inv.getContents().length;

		for (int metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
		}

		p.openInventory(inv);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("warps")) {
			Player p = (Player) sender;
			guiKits(p);
		}

		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dLOJA§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lKITS")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lojakits");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lEXTRAS")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lojaextras");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lVIP & MAIS")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuVip.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
			}
		}
	}
}