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

public class MenuOutros implements Listener, CommandExecutor {
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory(p, 27, "§8[§dOUTROS§8]");

		final ItemStack pyro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§c§lVOLTAR");
		final ArrayList descpyro1 = new ArrayList();
		metapyro.setLore(descpyro1);
		pyro.setItemMeta(metapyro);
		inv.setItem(0, pyro);

		if (!p.hasPermission("zey.pvp.menuvip")) {
			final ItemStack magma = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
			final ItemMeta magmam = magma.getItemMeta();
			magmam.setDisplayName("§c§lCABEÇAS APENAS PARA VIP'S");
			final ArrayList<String> desc = new ArrayList<String>();
			magmam.setLore(desc);
			magma.setItemMeta(magmam);
			inv.setItem(13, magma);
		} else if (p.hasPermission("zey.pvp.menuvip")) {
			final ItemStack magma = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
			final ItemMeta magmam = magma.getItemMeta();
			magmam.setDisplayName("§d§lCABEÇAS");
			final ArrayList<String> desc = new ArrayList<String>();
			magmam.setLore(desc);
			magma.setItemMeta(magmam);
			inv.setItem(13, magma);
		}

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
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dOUTROS§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lCABEÇAS")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuCabeças.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuPerfil.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
