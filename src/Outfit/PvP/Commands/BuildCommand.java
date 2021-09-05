package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BuildCommand implements Listener, CommandExecutor {
   public static ArrayList<Player> embuild = new ArrayList<Player>();

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("build")) {
         if (p.hasPermission("zey.pvp.build")) {
            if (args.length == 0) {
               if (!embuild.contains(p)) {
                  embuild.add(p);
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu Modo Build §a§lHABILITADO§7.");
               } else {
                  embuild.remove(p);
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu Modo Build §c§lDESABILITADO§7.");
               }
            } else {
               Player t = Bukkit.getPlayer(args[0]);
               if (t == null) {
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
                  return true;
               }

               if (!embuild.contains(t)) {
                  embuild.add(t);
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Modo Build §a§lHABILITADO §7para o jogador(a): §e" + t.getName() + "§7.");
                  t.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu Modo Build foi §a§lHABILITADO §7pelo jogador(a): §e" + p.getName() + "§7.");
               } else {
                  embuild.remove(t);
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Modo Build §c§lDESABILITADO §7para o jogador(a): §e" + t.getName() + "§7.");
                  t.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu Modo Build foi §c§lDESABILITADO §7pelo jogador(a): §e" + p.getName() + "§7.");
               }
            }
         } else {
            p.sendMessage("§cVocê não tem permissão para isso.");
         }
      }

      return false;
   }

   @EventHandler
   public void aoconstruir(BlockPlaceEvent e) {
      Player p = e.getPlayer();
      if (!embuild.contains(p)) {
         e.setCancelled(true);
      }

   }

   @EventHandler
   public void aoconstruir(BlockBreakEvent e) {
      Player p = e.getPlayer();
      if (!embuild.contains(p)) {
         e.setCancelled(true);
      }

   }
}
