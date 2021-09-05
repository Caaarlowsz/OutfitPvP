package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AutoSoupCommand implements CommandExecutor, Listener {
   public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
   public static HashMap<String, ItemStack[]> armadura = new HashMap<String, ItemStack[]>();
   ItemStack sopa;
   ItemMeta msopa;
   ItemStack sopa1;
   ItemMeta msopa1;
   ItemStack sopa2;
   ItemMeta msopa2;

   public AutoSoupCommand(Main main) {
      this.sopa = new ItemStack(Material.MUSHROOM_SOUP);
      this.msopa = this.sopa.getItemMeta();
      this.sopa1 = new ItemStack(Material.MUSHROOM_SOUP);
      this.msopa1 = this.sopa.getItemMeta();
      this.sopa2 = new ItemStack(Material.MUSHROOM_SOUP);
      this.msopa2 = this.sopa.getItemMeta();
   }

   public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
      Player p = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("autosoup")) {
         if (!p.hasPermission("zey.pvp.autosoup")) {
            p.sendMessage("§cVocê não tem permissão para isso.");
            return true;
         }

         final Player testando = p.getServer().getPlayer(args[0]);
         p.openInventory(testando.getInventory());
         saveinv.put(testando.getName(), testando.getInventory().getContents());
         armadura.put(testando.getName(), testando.getInventory().getArmorContents());
         testando.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 70, 999));
         testando.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 70, 999));
         this.sopa.setItemMeta(this.msopa);
         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            public void run() {
               testando.getInventory().clear();
               testando.setHealth(5.0D);
               testando.getInventory().setItem(10, AutoSoupCommand.this.sopa);
               testando.getInventory().setItem(11, AutoSoupCommand.this.sopa1);
               testando.getInventory().setItem(12, AutoSoupCommand.this.sopa2);
            }
         }, 20L);
         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            public void run() {
               testando.getInventory().clear();
               testando.getInventory().setContents((ItemStack[])AutoSoupCommand.saveinv.get(testando.getName()));
               testando.getInventory().setArmorContents((ItemStack[])AutoSoupCommand.armadura.get(testando.getName()));
               testando.setHealth(20.0D);
            }
         }, 50L);
      }

      return false;
   }
}
