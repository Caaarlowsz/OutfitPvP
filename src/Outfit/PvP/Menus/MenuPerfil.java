package Outfit.PvP.Menus;

import java.util.ArrayList;
import java.util.List;

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
import Outfit.PvP.Score.SPlayer;

public class MenuPerfil implements Listener, CommandExecutor {
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory(p, 27, "§8[§dPERFIL§8]");

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

		inv.setItem(1, vidro2);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro2);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro2);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro2);
		inv.setItem(9, vidro3);
		inv.setItem(10, vidro3);
		inv.setItem(16, vidro3);
		inv.setItem(17, vidro3);
		inv.setItem(18, vidro2);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro2);
		inv.setItem(21, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro2);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro2);

		final ItemStack event457 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		final ItemMeta eventv1 = event457.getItemMeta();
		eventv1.setDisplayName("§d§lOUTROS");
		event457.setItemMeta(eventv1);
		inv.setItem(8, event457);

		ItemStack pyro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§c§lVOLTAR");
		ArrayList descpyro1 = new ArrayList();
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(0, pyro);

		pyro = new ItemStack(Material.MAGMA_CREAM);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lDEATHS");
		descpyro1.add("§7" + OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(11, pyro);

		pyro = new ItemStack(Material.IRON_SWORD);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lKILLS");
		descpyro1.add("§7" + OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(12, pyro);

		pyro = new ItemStack(Material.GOLD_INGOT);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lMOEDAS");
		descpyro1.add("§7" + ZeyCoins.getPlayerMoney(p));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(13, pyro);

		pyro = new ItemStack(Material.SLIME_BALL);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lRANK");
		descpyro1.add(SPlayer.Liga(p));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(14, pyro);

		pyro = new ItemStack(Material.LEATHER_CHESTPLATE);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lMARCA");
		descpyro1.add(SPlayer.Marca(p));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(22, pyro);

		pyro = new ItemStack(Material.BOOK);
		metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§d§lSTATUS");
		descpyro1 = new ArrayList();
		descpyro1.add("§f  ");
		descpyro1.add("§f§ §d§lLIGA");
		descpyro1.add(SPlayer.Rank(p));
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(15, pyro);

		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack itemStack = arrayOfItemStack[metapyro2];
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dPERFIL§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuGeral1.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lOUTROS")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuOutros.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
