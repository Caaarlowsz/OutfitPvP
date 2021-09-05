package Outfit.PvP.Kits;

import Outfit.PvP.Eventos.Habilidade;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Specialist implements Listener {
   @EventHandler
   public void onIasnteract(PlayerInteractEvent event) {
      Player p = event.getPlayer();
      if (p.getItemInHand().getType().equals(Material.ENCHANTED_BOOK) && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lSPECIALIST") && Habilidade.getAbility(p) == "Specialist" && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
         event.setCancelled(true);
         p.openEnchanting((Location)null, true);
      }

   }

   @EventHandler
   public void onVampire(EntityDeathEvent event) {
      if (event.getEntity() instanceof Player) {
         Player killed = (Player)event.getEntity();
         if (killed.getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            if (Habilidade.getAbility(player) == "Specialist") {
               player.setLevel(1);
            }
         }
      }

   }
}
