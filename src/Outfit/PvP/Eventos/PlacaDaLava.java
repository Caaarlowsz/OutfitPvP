package Outfit.PvP.Eventos;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlacaDaLava implements Listener {
   @EventHandler
   public void Escrever(SignChangeEvent e) {
      if (e.getLine(0).equalsIgnoreCase("[facil]")) {
         e.setLine(0, "");
         e.setLine(1, "§c§lCHALLENGE");
         e.setLine(2, "");
         e.setLine(3, "§7(Fácil)");
      }

      if (e.getLine(0).equalsIgnoreCase("[medio]")) {
         e.setLine(0, "");
         e.setLine(1, "§c§lCHALLENGE");
         e.setLine(2, "");
         e.setLine(3, "§7(Médio)");
      }

      if (e.getLine(0).equalsIgnoreCase("[dificil]")) {
         e.setLine(0, "");
         e.setLine(1, "§c§lCHALLENGE");
         e.setLine(2, "");
         e.setLine(3, "§7(Difícil)");
      }

      if (e.getLine(0).equalsIgnoreCase("[extremo]")) {
         e.setLine(0, "");
         e.setLine(1, "§c§lCHALLENGE");
         e.setLine(2, "");
         e.setLine(3, "§7(Extremo)");
      }

   }

   @EventHandler
   public void inv(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
         Sign s = (Sign)e.getClickedBlock().getState();
         String[] lines = s.getLines();
         World w;
         double x;
         double y;
         double z;
         Location lobby;
         ItemStack sopa;
         int i;
         ItemMeta ksopas;
         ItemStack cogur;
         ItemMeta kcogur;
         ItemStack cogum;
         ItemMeta kcogum;
         ItemStack sopas;
         if (lines.length > 0 && lines[0].equals("") && lines.length > 1 && lines[1].equals("§c§lCHALLENGE") && lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("§7(Fácil)") && WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você completou o challenge §dfácil§7.");
            ZeyCoins.addMoney((Player)p, 200);
            p.getInventory().clear();
            p.getInventory().setArmorContents((ItemStack[])null);
            KitAPI.remove(p);
            w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
            x = Main.instance.getConfig().getDouble("lava.x");
            y = Main.instance.getConfig().getDouble("lava.y");
            z = Main.instance.getConfig().getDouble("lava.z");
            lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
            p.teleport(lobby);
            Habilidade.setAbility(p, "Warp");
            sopa = new ItemStack(Material.MUSHROOM_SOUP);

            for(i = 0; i < 36; ++i) {
               p.getInventory().setItem(i, sopa);
            }

            sopas = new ItemStack(Material.BOWL, 64);
            ksopas = sopas.getItemMeta();
            sopas.setItemMeta(ksopas);
            cogur = new ItemStack(Material.RED_MUSHROOM, 64);
            kcogur = cogur.getItemMeta();
            cogur.setItemMeta(kcogur);
            cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
            kcogum = cogum.getItemMeta();
            cogum.setItemMeta(kcogum);
            p.getInventory().setItem(13, sopas);
            p.getInventory().setItem(14, cogur);
            p.getInventory().setItem(15, cogum);
            p.updateInventory();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você ganhou §d200 Dolls§7.");
         }

         if (lines.length > 0 && lines[0].equals("") && lines.length > 1 && lines[1].equals("§c§lCHALLENGE") && lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("§7(Médio)") && WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você completou o challenge §dmedio§7.");
            ZeyCoins.addMoney((Player)p, 300);
            p.getInventory().clear();
            p.getInventory().setArmorContents((ItemStack[])null);
            KitAPI.remove(p);
            w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
            x = Main.instance.getConfig().getDouble("lava.x");
            y = Main.instance.getConfig().getDouble("lava.y");
            z = Main.instance.getConfig().getDouble("lava.z");
            lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
            p.teleport(lobby);
            Habilidade.setAbility(p, "Warp");
            sopa = new ItemStack(Material.MUSHROOM_SOUP);

            for(i = 0; i < 36; ++i) {
               p.getInventory().setItem(i, sopa);
            }

            sopas = new ItemStack(Material.BOWL, 64);
            ksopas = sopas.getItemMeta();
            sopas.setItemMeta(ksopas);
            cogur = new ItemStack(Material.RED_MUSHROOM, 64);
            kcogur = cogur.getItemMeta();
            cogur.setItemMeta(kcogur);
            cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
            kcogum = cogum.getItemMeta();
            cogum.setItemMeta(kcogum);
            p.getInventory().setItem(13, sopas);
            p.getInventory().setItem(14, cogur);
            p.getInventory().setItem(15, cogum);
            p.updateInventory();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você ganhou §d300 Dolls§7.");
         }

         if (lines.length > 0 && lines[0].equals("") && lines.length > 1 && lines[1].equals("§c§lCHALLENGE") && lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("§7(Difícil)") && WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você completou o challenge §ddifício§7.");
            ZeyCoins.addMoney((Player)p, 500);
            p.getInventory().clear();
            p.getInventory().setArmorContents((ItemStack[])null);
            KitAPI.remove(p);
            w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
            x = Main.instance.getConfig().getDouble("lava.x");
            y = Main.instance.getConfig().getDouble("lava.y");
            z = Main.instance.getConfig().getDouble("lava.z");
            lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
            p.teleport(lobby);
            Habilidade.setAbility(p, "Warp");
            sopa = new ItemStack(Material.MUSHROOM_SOUP);

            for(i = 0; i < 36; ++i) {
               p.getInventory().setItem(i, sopa);
            }

            sopas = new ItemStack(Material.BOWL, 64);
            ksopas = sopas.getItemMeta();
            sopas.setItemMeta(ksopas);
            cogur = new ItemStack(Material.RED_MUSHROOM, 64);
            kcogur = cogur.getItemMeta();
            cogur.setItemMeta(kcogur);
            cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
            kcogum = cogum.getItemMeta();
            cogum.setItemMeta(kcogum);
            p.getInventory().setItem(13, sopas);
            p.getInventory().setItem(14, cogur);
            p.getInventory().setItem(15, cogum);
            p.updateInventory();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você ganhou §d500 Dolls§7.");
         }

         if (lines.length > 0 && lines[0].equals("") && lines.length > 1 && lines[1].equals("§c§lCHALLENGE") && lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("§7(Extremo)") && WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você completou o challenge §dextremo§7.");
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §7O jogador(a): §d" + p.getName() + " §7completou o challenger, §c§LEXTREMO§7.");
            Bukkit.broadcastMessage(" ");
            ZeyCoins.addMoney((Player)p, 1000);
            p.getInventory().clear();
            p.getInventory().setArmorContents((ItemStack[])null);
            KitAPI.remove(p);
            w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
            x = Main.instance.getConfig().getDouble("lava.x");
            y = Main.instance.getConfig().getDouble("lava.y");
            z = Main.instance.getConfig().getDouble("lava.z");
            lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
            p.teleport(lobby);
            Habilidade.setAbility(p, "Warp");
            sopa = new ItemStack(Material.MUSHROOM_SOUP);

            for(i = 0; i < 36; ++i) {
               p.getInventory().setItem(i, sopa);
            }

            sopas = new ItemStack(Material.BOWL, 64);
            ksopas = sopas.getItemMeta();
            sopas.setItemMeta(ksopas);
            cogur = new ItemStack(Material.RED_MUSHROOM, 64);
            kcogur = cogur.getItemMeta();
            cogur.setItemMeta(kcogur);
            cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
            kcogum = cogum.getItemMeta();
            cogum.setItemMeta(kcogum);
            p.getInventory().setItem(13, sopas);
            p.getInventory().setItem(14, cogur);
            p.getInventory().setItem(15, cogum);
            p.updateInventory();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você ganhou §d1500 Dolls§7.");
         }
      }

   }
}
