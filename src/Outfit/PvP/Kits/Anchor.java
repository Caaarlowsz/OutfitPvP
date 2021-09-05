package Outfit.PvP.Kits;

import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class Anchor implements Listener {
   @EventHandler(
      priority = EventPriority.HIGH
   )
   public void onPlayerHitAnchor(EntityDamageByEntityEvent e) {
      if (e.getEntity() instanceof Player) {
         if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            Player a = (Player)e.getDamager();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Anchor")) {
               p.setVelocity(new Vector());
               p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
               Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
                  public void run() {
                     p.setVelocity(new Vector());
                  }
               }, 1L);
            }

            if (Habilidade.getAbility(a).equalsIgnoreCase("Anchor")) {
               a.playSound(a.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
               p.setVelocity(new Vector());
               Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
                  public void run() {
                     p.setVelocity(new Vector());
                  }
               }, 1L);
            }

         }
      }
   }
}
