package Outfit.PvP.Kits;

import Outfit.PvP.Eventos.Habilidade;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class AntiTower implements Listener {
   @EventHandler
   public void aogalinha(EntityDamageEvent e) {
      if (e.getEntity() instanceof Player) {
         if (e.getCause() == DamageCause.FALL) {
            Player p = (Player)e.getEntity();
            if (Habilidade.getAbility(p) == "AntiTower0") {
               e.setDamage(6.0D);
            }
         }

      }
   }
}
