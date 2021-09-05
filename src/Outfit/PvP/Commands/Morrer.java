package Outfit.PvP.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.Main.Main;

public class Morrer
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("morrer"))
    {
      p.setHealth(0.0D);
      p.sendMessage(String.valueOf(Main.prefix + " §4§lVoce se matou!"));
    }
    return false;
  }
}

