package Outfit.PvP.Commands;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Warps.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RecraftCommand implements CommandExecutor {
   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      final Player p = (Player)Sender;
      if (Cmd.getName().equalsIgnoreCase("recraft")) {
         if (WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Main") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Fps") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Evento") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Textura") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Potion") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Parkour") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, volte ao spawn e pegue um kit, usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Spawn") {
            p.sendMessage(String.valueOf(Main.prefix) + " §cVocê não pode usar esse comando nestá Warp. Para utilizar esse comando, pegue um Kit, usando o comando: /kit (kit)");
            return true;
         }

         p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
         p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu §a§lRECRAFT §7está a caminho.");
         Bukkit.getScheduler().scheduleSyncDelayedTask(Spawn.plugin, new Runnable() {
            public void run() {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSeu recraft chegou.");
               ItemStack sopas = new ItemStack(Material.BOWL, 64);
               ItemMeta ksopas = sopas.getItemMeta();
               sopas.setItemMeta(ksopas);
               ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
               ItemMeta kcogur = cogur.getItemMeta();
               cogur.setItemMeta(kcogur);
               ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
               ItemMeta kcogum = cogum.getItemMeta();
               cogum.setItemMeta(kcogum);
               p.getInventory().setItem(13, sopas);
               p.getInventory().setItem(14, cogur);
               p.getInventory().setItem(15, cogum);

               for (PotionEffect effect : p.getActivePotionEffects()) {
                   p.removePotionEffect(effect.getType());
                 }
               }
             },40L);
       } 
       return false;
     }
   }
