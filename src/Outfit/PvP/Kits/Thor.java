package Outfit.PvP.Kits;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Thor
  implements Listener
{
  @EventHandler
  public void ThorKit(PlayerInteractEvent e) {
    final Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR || 
      e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
      if (Cooldown.add(p)) {
        KitUtil.MensagemCooldown(p);
        return;
      } 
      Cooldown.add(p, 5);
      
      @SuppressWarnings("deprecation")
	Location loc = p.getTargetBlock(null, 30).getLocation();
      p.getWorld().strikeLightning(loc);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run() {
        	 p.getWorld().strikeLightning(loc);
        }
      },  10L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run() {
        	 p.getWorld().strikeLightning(loc);
        }
      },  20L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run() {
        	 p.getWorld().strikeLightning(loc);
        }
      },  40L);
      e.setCancelled(true);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run() {
              KitUtil.ccooldown(p);
            }
          },  100L);
    } 
  }
}
