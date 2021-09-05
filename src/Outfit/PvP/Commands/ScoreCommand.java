package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import Outfit.PvP.Score.ScoreB;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreCommand implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      if (label.equalsIgnoreCase("score")) {
         if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cUtilize: /score <on> <off>");
            return true;
         }

         Bukkit.getPlayer(args[0]);
         if (args[0].toLowerCase().equalsIgnoreCase("on")) {
            ScoreB.addScore(p);
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você §a§lHABILITOU §7sua score!");
         } else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
            ScoreB.removeScore(p);
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você §c§lDESABILITOU §7sua score!");
         }
      }

      return false;
   }
}
