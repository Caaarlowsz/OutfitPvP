package Outfit.PvP.Commands;

import Outfit.PvP.APIs.TheTitle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LimparTelaCommand implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("limpartela")) {
         TheTitle.reset(p);
      }

      return false;
   }
}
