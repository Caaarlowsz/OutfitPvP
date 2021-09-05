package Outfit.PvP.Kits;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Armor implements Listener {
   public static HashMap<String, ItemStack[]> salvararmor = new HashMap<String, ItemStack[]>();

   public static ItemStack darArmaduraI(Material material) {
      ItemStack item = new ItemStack(material);
      ItemMeta itemm = item.getItemMeta();
      item.setItemMeta(itemm);
      return item;
   }

   @EventHandler
   public void aoArmor(PlayerInteractEvent e) {
      final Player p = e.getPlayer();
      if (Habilidade.getAbility(p).equalsIgnoreCase("Armor") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_INGOT) {
         if (Cooldown.add(p)) {
            KitUtil.MensagemCooldown(p);
            return;
         }

         salvararmor.put(p.getName(), p.getInventory().getArmorContents());
         KitUtil.tirarArmadura(p);
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você recebeu sua armadura temporaria.");
         p.getInventory().setArmorContents(new ItemStack[]{darArmaduraI(Material.GOLD_HELMET), darArmaduraI(Material.GOLD_CHESTPLATE), darArmaduraI(Material.GOLD_LEGGINGS), darArmaduraI(Material.GOLD_BOOTS)});
         p.updateInventory();
         Cooldown.add(p, 25);
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            public void run() {
               KitUtil.tirarArmadura(p);
               p.getInventory().setArmorContents((ItemStack[])Armor.salvararmor.get(p.getName()));
               Armor.salvararmor.remove(p.getName());
               p.updateInventory();
            }
         }, 200L);
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            public void run() {
               KitUtil.ccooldown(p);
            }
         }, 500L);
      }

   }

   @EventHandler
   public void aomecher(InventoryClickEvent e) {
      try {
         Player p = (Player)e.getWhoClicked();
         if (salvararmor.containsKey(p.getName()) && e.getSlotType().equals(SlotType.ARMOR)) {
            e.setCancelled(true);
         }
      } catch (Exception var3) {
      }

   }
}
