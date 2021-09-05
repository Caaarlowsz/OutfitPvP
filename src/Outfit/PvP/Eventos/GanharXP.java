package Outfit.PvP.Eventos;

import Outfit.PvP.Config.ZeyCoins;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GanharXP implements Listener {
   @EventHandler
   public void a(PlayerDeathEvent e) {
      if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
         Player killer = e.getEntity().getKiller();
         Player killed = e.getEntity();
         killed.teleport(killed.getWorld().getSpawnLocation());
         e.setDeathMessage((String)null);
         ZeyCoins.addMoney((Player)killer, 100);
         ZeyCoins.removeMoney(killed, 50);
      }

   }
}
