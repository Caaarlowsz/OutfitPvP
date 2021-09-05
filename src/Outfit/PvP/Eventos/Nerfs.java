package Outfit.PvP.Eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class Nerfs implements Listener {
   @SuppressWarnings("deprecation")
@EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void NerfsDanos(EntityDamageByEntityEvent event) {
      if (event.getDamager() instanceof Player) {
         Player player = (Player)event.getDamager();
         if (event.getDamage() > 1.0D) {
            event.setDamage(event.getDamage() - 1.0D);
         }

         if (event.getDamager() instanceof Player) {
            if (player.getFallDistance() > 0.0F && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
               int NewDamage = (int)(event.getDamage() * 1.25D) - (int)event.getDamage();
               if (event.getDamage() > 1.0D) {
                  event.setDamage(event.getDamage() - (double)NewDamage);
               }
            }

            if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
               event.setDamage(1.5D);
            }

            if (player.getItemInHand().getType() == Material.STONE_SWORD) {
               event.setDamage(2.5D);
            }

            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
               event.setDamage(3.5D);
            }

            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
               event.setDamage(4.75D);
            }

            if (player.getItemInHand().getType() == Material.WOOD_AXE) {
               event.setDamage(2.5D);
            }

            if (player.getItemInHand().getType() == Material.STONE_AXE) {
               event.setDamage(3.5D);
            }

            if (player.getItemInHand().getType() == Material.IRON_AXE) {
               event.setDamage(4.5D);
            }

            if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
               event.setDamage(5.5D);
            }

            if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
               event.setDamage(event.getDamage() + 1.25D);
            }

            if (player.getFallDistance() > 0.0F && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
               if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                  event.setDamage(event.getDamage() + 1.0D);
               }

               if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                  event.setDamage(event.getDamage() + 1.0D);
               }

               if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                  event.setDamage(event.getDamage() + 1.0D);
               }

               if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                  event.setDamage(event.getDamage() + 1.0D);
               }
            }

            if (player.getFallDistance() > 0.0F && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
               if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.STONE_AXE) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.IRON_AXE) {
                  event.setDamage(event.getDamage() + 1.25D);
               }

               if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                  event.setDamage(event.getDamage() + 1.25D);
               }
            }

            if (player.getFallDistance() > 0.0F && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) && !player.isOnGround()) {
               if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.STONE_AXE) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.IRON_AXE) {
                  event.setDamage(event.getDamage() + 0.35D);
               }

               if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                  event.setDamage(event.getDamage() + 0.35D);
               }
            }
         }
      }

   }
}
