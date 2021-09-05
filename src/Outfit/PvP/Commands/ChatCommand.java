package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatCommand implements CommandExecutor, Listener {
   public static boolean c = false;

   public ChatCommand(Main main) {
   }

   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      Player p = (Player)Sender;
      if (Cmd.getName().equalsIgnoreCase("chat")) {
         if (!p.hasPermission("zey.pvp.chatonoff")) {
            p.sendMessage("§cVocê não tem permissão para isso.");
            return true;
         }

         if (Args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /chat [Ligar/Desligar]");
            return true;
         }

         if (Args[0].equalsIgnoreCase("desligar")) {
            c = true;
            Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §7O chat do servidor foi §c§lDESLIGADO§7.");
         }

         if (Args[0].equalsIgnoreCase("ligar")) {
            c = false;
            Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §7O chat do servidor foi §a§lLIGADO§7.");
         }
      }

      return false;
   }

   @EventHandler
   public void naoFalarNoChatQuandoTiverOFF(AsyncPlayerChatEvent e) {
      Player p = e.getPlayer();
      if (!p.hasPermission("zey.pvp.falarchat") && c) {
         e.setCancelled(true);
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê não tem permissão para falar com o chat desativado.");
      }

   }
}
