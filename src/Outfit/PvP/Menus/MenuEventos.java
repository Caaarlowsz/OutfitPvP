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

public class MenuEventos implements Listener, CommandExecutor {
   public static void guiKits(Player p) {
      Inventory inv = Bukkit.getServer().createInventory(p, 27, "§8[§dWARPS§8]");
      ItemStack event457 = new ItemStack(Material.DIAMOND_SWORD, 1, (short)0);
      ItemMeta eventv1 = event457.getItemMeta();
      eventv1.setDisplayName("§d§lRDM");
      event457.setItemMeta(eventv1);
      inv.setItem(13, event457);
      ItemStack event458 = new ItemStack(Material.WATER_BUCKET, 1, (short)0);
      ItemMeta eventv2 = event458.getItemMeta();
      eventv2.setDisplayName("§d§lMLG");
      event458.setItemMeta(eventv2);
      inv.setItem(14, event458);
      ItemStack event459 = new ItemStack(Material.CAKE, 1, (short)0);
      ItemMeta eventv3 = event459.getItemMeta();
      eventv3.setDisplayName("§d§lMDR");
      event459.setItemMeta(eventv3);
      inv.setItem(12, event459);
      ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta vidrox = vidro.getItemMeta();
      vidrox.setDisplayName("§6§lKombo§f§lPvP");
      vidro.setItemMeta(vidrox);
      ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
      ItemMeta vidrom2 = vidro.getItemMeta();
      vidrom2.setDisplayName("§6§lKombo§f§lPvP");
      vidro2.setItemMeta(vidrom2);
      ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8);
      ItemMeta vidrom3 = vidro.getItemMeta();
      vidrom3.setDisplayName("§6§lKombo§f§lPvP");
      vidro3.setItemMeta(vidrom3);
      ItemStack vidro4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
      ItemMeta vidrom4 = vidro.getItemMeta();
      vidrom4.setDisplayName("§c§lVOLTAR");
      vidro4.setItemMeta(vidrom4);
      inv.setItem(0, vidro4);
      inv.setItem(1, vidro2);
      inv.setItem(2, vidro);
      inv.setItem(3, vidro2);
      inv.setItem(4, vidro);
      inv.setItem(5, vidro2);
      inv.setItem(6, vidro);
      inv.setItem(7, vidro2);
      inv.setItem(8, vidro);
      inv.setItem(9, vidro3);
      inv.setItem(10, vidro3);
      inv.setItem(11, vidro3);
      inv.setItem(15, vidro3);
      inv.setItem(16, vidro3);
      inv.setItem(17, vidro3);
      inv.setItem(18, vidro2);
      inv.setItem(19, vidro);
      inv.setItem(20, vidro2);
      inv.setItem(21, vidro);
      inv.setItem(22, vidro2);
      inv.setItem(23, vidro);
      inv.setItem(24, vidro2);
      inv.setItem(25, vidro);
      inv.setItem(26, vidro2);

      ItemStack[] arrayOfItemStack;
      for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
          @SuppressWarnings("unused")
		final ItemStack itemStack = arrayOfItemStack[metapyro2];
      }
      p.openInventory(inv);
  }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (commandLabel.equalsIgnoreCase("warps")) {
         Player p = (Player)sender;
         guiKits(p);
      }

      return false;
   }

   @SuppressWarnings("deprecation")
@EventHandler
   public void onPlayerCLickInventry(InventoryClickEvent e) {
      Player p = (Player)e.getWhoClicked();
      if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dWARPS§8]") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMLG")) {
            e.setCancelled(true);
            p.chat("/mlg");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
         }

         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
            e.setCancelled(true);
            p.closeInventory();
            MenuWarps.guiKits(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
         }

         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lRDM")) {
            e.setCancelled(true);
            p.closeInventory();
            p.chat("/rdm");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
         }

         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMDR")) {
            e.setCancelled(true);
            p.closeInventory();
            p.chat("/mdr");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
         }
      }

   }

   public static void ir(Player p, String string) {
   }
}
