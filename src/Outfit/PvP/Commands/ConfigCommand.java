package Outfit.PvP.Commands;

import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigCommand implements CommandExecutor {
   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      Player p = (Player)Sender;
      if (Label.equalsIgnoreCase("reloadcfg") && Sender instanceof Player) {
         if (!p.hasPermission("zey.pvp.cfg")) {
            p.sendMessage(String.valueOf(Main.prefix) + "§8➸  §cVocê não tem permissão para isso.");
            return true;
         }

         ZeyCoins.loadMoneyManager();
         Main.plugin.reloadConfig();
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aTodas as §a§lCFG'S §aforam recarregadas!");
      }

      return false;
   }
}
