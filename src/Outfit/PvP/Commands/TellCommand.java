package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellCommand implements CommandExecutor {
   public static HashMap<Player, Player> gettell = new HashMap<Player, Player>();
   static ArrayList<Player> telloff = new ArrayList<Player>();

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      Player target;
      StringBuilder sb;
      int i;
      String allArgs;
      if (label.equalsIgnoreCase("tell")) {
         if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /tell [Jogador(a)] (msg)");
            return true;
         }

         target = Bukkit.getPlayer(args[0]);
         if (args[0].toLowerCase().equalsIgnoreCase("on")) {
            telloff.remove(p);
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você §a§lHABILITOU §7seu tell");
         } else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
            telloff.add(p);
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você §c§lDESABILITOU §7seu tell");
         }

         if (args.length > 1) {
            if (target == null) {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
               return true;
            }

            if (telloff.contains(target)) {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO tell desse player esta desabilitado.");
               return true;
            }

            sb = new StringBuilder();

            for(i = 1; i < args.length; ++i) {
               sb.append(args[i]).append(" ");
            }

            allArgs = sb.toString().trim();
            p.sendMessage("§dEu §8➸ §r" + target.getDisplayName() + "§7:§d " + allArgs);
            target.sendMessage("§d" + p.getDisplayName() + " §8➸ §7Eu §7:§d " + allArgs);
            gettell.put(p, target);
            gettell.put(target, p);
         }
      } else if (label.equalsIgnoreCase("off")) {
         if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO tell desse player esta desabilitado.");
            return true;
         }

         if (!gettell.containsKey(p)) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você não tem ninguem para responder.");
            return true;
         }

         target = (Player)gettell.get(p);
         if (target == null) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
            return true;
         }

         if (telloff.contains(target)) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cO tell desse player esta desabilitado.");
            return true;
         }

         sb = new StringBuilder();

         for(i = 0; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
         }

         allArgs = sb.toString().trim();
         p.sendMessage("§dEu §8➸ §r" + target.getDisplayName() + "§7:§d " + allArgs);
         target.sendMessage("§d" + p.getDisplayName() + " §8➸ §7Eu §7:§d: " + allArgs);
      }

      return false;
   }
}
