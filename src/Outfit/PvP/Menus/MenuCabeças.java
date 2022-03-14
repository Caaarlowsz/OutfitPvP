package Outfit.PvP.Menus;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuCabeças implements Listener {
	private static ArrayList<String> comchapeu;

	static {
		MenuCabeças.comchapeu = new ArrayList<String>();
	}

	public MenuCabeças(final OutfitPvP main) {
	}

	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.createInventory(p, 54, "§8[§dCABECAS§8]");
		final ItemStack event1234 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta eventv1234 = event1234.getItemMeta();
		eventv1234.setDisplayName("§c§lVOLTAR");
		event1234.setItemMeta(eventv1234);
		inv.setItem(0, event1234);

		final ItemStack ct = new ItemStack(Material.WORKBENCH);
		final ItemMeta ct2 = ct.getItemMeta();
		ct2.setDisplayName("§d§lCRAFTING TABLE");
		ct.setItemMeta(ct2);

		final ItemStack ft = new ItemStack(Material.FURNACE);
		final ItemMeta ft2 = ft.getItemMeta();
		ft2.setDisplayName("§d§lFORNALHA");
		ft.setItemMeta(ft2);

		final ItemStack vt = new ItemStack(Material.GLASS);
		final ItemMeta vt2 = vt.getItemMeta();
		vt2.setDisplayName("§d§lVIDRO");
		vt.setItemMeta(vt2);

		final ItemStack tt = new ItemStack(Material.TNT);
		final ItemMeta tt2 = tt.getItemMeta();
		tt2.setDisplayName("§d§lTNT");
		tt.setItemMeta(tt2);

		final ItemStack dt = new ItemStack(Material.DIAMOND_BLOCK);
		final ItemMeta dt2 = dt.getItemMeta();
		dt2.setDisplayName("§d§lDIAMANTE");
		dt.setItemMeta(dt2);

		final ItemStack st = new ItemStack(Material.MOB_SPAWNER);
		final ItemMeta st2 = st.getItemMeta();
		st2.setDisplayName("§d§lSPAWNER");
		st.setItemMeta(st2);

		final ItemStack bt = new ItemStack(Material.BOOKSHELF);
		final ItemMeta bt2 = bt.getItemMeta();
		bt2.setDisplayName("§d§lESTATANTE");
		bt.setItemMeta(bt2);

		final ItemStack cdt = new ItemStack(Material.ANVIL);
		final ItemMeta cdt2 = cdt.getItemMeta();
		cdt2.setDisplayName("§d§lBIGORNA");
		cdt.setItemMeta(cdt2);

		final ItemStack cbt1 = new ItemStack(Material.REDSTONE_LAMP_OFF);
		final ItemMeta cbt2 = cbt1.getItemMeta();
		cbt2.setDisplayName("§d§lLANTERNA");
		cbt1.setItemMeta(cbt2);

		final ItemStack rt = new ItemStack(Material.REDSTONE);
		final ItemMeta rt2 = rt.getItemMeta();
		rt2.setDisplayName("§d§lRETIRAR");

		rt.setItemMeta(rt2);
		inv.setItem(28, ct);
		inv.setItem(29, ft);
		inv.setItem(30, vt);
		inv.setItem(31, bt);
		inv.setItem(32, tt);
		inv.setItem(33, st);
		inv.setItem(34, dt);
		inv.setItem(37, cdt);
		inv.setItem(38, cbt1);
		inv.setItem(13, rt);
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

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void clicou(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (p.getOpenInventory().getTitle().equalsIgnoreCase("§8[§dCABECAS§8]")) {

			if (e.getCurrentItem().getType() == Material.WORKBENCH) {
				p.getInventory().setHelmet(new ItemStack(Material.WORKBENCH));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lCRAFTING TABLE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_LAMP_OFF) {
				p.getInventory().setHelmet(new ItemStack(Material.REDSTONE_LAMP_OFF));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lLAMPADA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.FURNACE) {
				p.getInventory().setHelmet(new ItemStack(Material.FURNACE));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lFORNALHA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				p.closeInventory();
				MenuOutros.guiKits(p);
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				if (!MenuCabeças.comchapeu.contains(p.getName())) {
					p.sendMessage(OutfitPvP.prefix
							+ " §8➸ §cVoc\u00ea N\u00e3o Est\u00e1 Com Uma Cabeça Personalizada");
				} else {
					p.getInventory().setHelmet(new ItemStack(Material.AIR));
					p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lNENHUMA");
					MenuCabeças.comchapeu.remove(p.getName());
				}
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				p.getInventory().setHelmet(new ItemStack(Material.GLASS));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lVIDRO");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				p.getInventory().setHelmet(new ItemStack(Material.ANVIL));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lBIGORNA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				p.getInventory().setHelmet(new ItemStack(Material.TNT));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lTNT");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lDIAMANTE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.THIN_GLASS) {
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.BOOKSHELF) {
				p.getInventory().setHelmet(new ItemStack(Material.BOOKSHELF));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lESTANTE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.MOB_SPAWNER) {
				p.getInventory().setHelmet(new ItemStack(Material.MOB_SPAWNER));
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aCabeça Alterada Para: §d§lSPAWNER");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
		}
	}
}
