package Outfit.PvP.Kits;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Utils.Proteção;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class Flash implements Listener {
   @SuppressWarnings("deprecation")
@EventHandler
   public void FlashKit(PlayerInteractEvent e) {
      final Player p = e.getPlayer();
      if (Habilidade.getAbility(p).equalsIgnoreCase("Flash") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
         if (Cooldown.add(p)) {
            KitUtil.MensagemCooldown(p);
            return;
         }

         Location loc = p.getTargetBlock(null, 150).getLocation().add(new Vector(0, 1, 0));
         if (p.getLocation().distance(loc.getBlock().getLocation()) > 100.0D) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não consegue se teletransportar para tao longe!");
            return;
         }

         if (p.getTargetBlock(null, 100).getType() == Material.GLASS) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode utilizar o kit Flash durante um duelo no Gladiator!");
            return;
         }

         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
            public void run() {
               Proteção.setImortal(p, false);
               Proteção.isImortal(p);
            }
         }, 20L);
         Cooldown.add(p, 15);
         Proteção.setImortal(p, true);
         Proteção.isImortal(p);
         p.teleport(loc);
         p.getWorld().strikeLightning(loc);
         e.setCancelled(true);
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
            public void run() {
               KitUtil.ccooldown(p);
            }
         }, 300L);
      }

   }
}
