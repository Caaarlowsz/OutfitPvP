package Outfit.PvP.Kits;

import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Kangaroo implements Listener {
	  public static Main plugin;
	  public static ArrayList<Player> kanga;
	  public static List<String> KitNerf = new ArrayList<>(); public static ArrayList<Player> fujao; public static List<Player> kangacd;
	  
	  static {
	    kanga = new ArrayList<>();
	    fujao = new ArrayList<>();
	    kangacd = new ArrayList<>();
	  }

   @EventHandler
   public void onInteract(PlayerInteractEvent event) {
      Player p = event.getPlayer();
      if (KitAPI.Kangaroo.contains(event.getPlayer().getName()) && p.getItemInHand().getType() == Material.FIREWORK && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
         event.setCancelled(true);
         if (KitNerf.contains(p.getName())) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVoce foi hitado aguarde!");
            return;
         }

         if (!kanga.contains(p)) {
            Vector vector;
            if (!p.isSneaking()) {
               p.setFallDistance(-3.0F);
               vector = p.getEyeLocation().getDirection();
               vector.multiply(0.8F);
               vector.setY(1.0F);
               p.setVelocity(vector);
            } else {
               p.setFallDistance(-3.0F);
               vector = p.getEyeLocation().getDirection();
               vector.multiply(1.7F);
               vector.setY(0.7D);
               p.setVelocity(vector);
            }

            kanga.add(p);
         }
      }

   }

   @EventHandler
   public void onMove(PlayerMoveEvent event) {
      Player p = event.getPlayer();
      if (kanga.contains(p)) {
         Block b = p.getLocation().getBlock();
         if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            kanga.remove(p);
         }
      }

   }

   @EventHandler
   public void entity(EntityDamageByEntityEvent e) {
      if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
         final Player p = (Player)e.getEntity();
         if (Habilidade.getAbility(p) == "Kangaroo" || Habilidade.getAbility(p) == "Grappler") {
            KitNerf.add(p.getName());
            (new BukkitRunnable() {
               public void run() {
                  Kangaroo.KitNerf.remove(p.getName());
               }
            }).runTaskLater(Main.getPlugin(), 100L);
         }
      }

   }

   @EventHandler
   public void onDamage(EntityDamageEvent event) {
      Entity e = event.getEntity();
      if (e instanceof Player) {
         Player player = (Player)e;
         if (event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL && player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 12.0D) {
            event.setDamage(12.0D);
         }
      }

   }
}
