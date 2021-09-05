package Outfit.PvP.Kits;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Monk implements Listener {
   @EventHandler
   public void aoMonk(PlayerInteractEntityEvent e) {
      final Player p = e.getPlayer();
      if (e.getRightClicked() instanceof Player) {
         Player jogadorClicado = (Player)e.getRightClicked();
         if (Habilidade.getAbility(p).equalsIgnoreCase("Monk") && p.getItemInHand().getType() == Material.BLAZE_ROD) {
            if (Cooldown.add(p)) {
               KitUtil.MensagemCooldown(p);
               return;
            }

            int random = (new Random()).nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
            ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
            ItemStack ItemMudado = jogadorClicado.getItemInHand();
            jogadorClicado.setItemInHand(ItemSelecionado);
            jogadorClicado.getInventory().setItem(random, ItemMudado);
            jogadorClicado.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você foi §c§lMONKADO§7.");
            p.sendMessage(String.valueOf(String.valueOf(Main.prefix) + " §8➸ §7Você §c§lMONKOU§7 o jogador(a): §e" + jogadorClicado.getName()));
            Cooldown.add(p, 20);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
               public void run() {
                  KitUtil.ccooldown(p);
               }
            }, 400L);
         }
      }

   }
}
