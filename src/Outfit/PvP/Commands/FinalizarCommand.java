package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FinalizarCommand implements CommandExecutor {
   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      Player p = (Player)Sender;
      if (Cmd.getName().equalsIgnoreCase("finalizar")) {
         if (!p.hasPermission("zey.pvp.finalizar")) {
            p.sendMessage("§cVocê não tem permissão para isso.");
            return true;
         }

         if (Args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /finalizar [Evento] [FullKit]");
            return true;
         }

         if (Args[0].equalsIgnoreCase("evento")) {
            if (IniciarCommand.evento) {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê finalizou o Evento [Evento].");
               Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §cO Evento [Evento] foi finalizado e não está mais disponivel para acesso.");
               IniciarCommand.evento = false;
               return true;
            }

            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO Evento [Evento] ainda não foi iniciado.");
         }

         if (Args[0].equalsIgnoreCase("fullkit")) {
            if (IniciarCommand.fullkit) {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê finalizou o Benefício [FullKit].");
               Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §cO Benefício [FullKit] foi finalizado e não está mais disponivel.");
               IniciarCommand.fullkit = false;
               return true;
            }

            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO Benefício [FullKit] não está liberado.");
         }
      }

      return false;
   }
}
