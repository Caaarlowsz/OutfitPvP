package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      Player player = (Player)Sender;
      if (Cmd.getName().equalsIgnoreCase("ajuda")) {
         player.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fAqui está algumas informações, sobre nossa rede.");
         player.sendMessage("§f ");
         player.sendMessage("§fSite: §bhttps://kombonetwork.buycraft.net");
         player.sendMessage("§fDiscord: §ehttps://discord.gg/FDFhphW");
         player.sendMessage("§f ");
      }

      return false;
   }
}
