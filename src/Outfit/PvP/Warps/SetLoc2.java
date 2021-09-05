package Outfit.PvP.Warps;

import Outfit.PvP.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetLoc2 implements Listener, CommandExecutor {
   public static Main plugin;

   public SetLoc2(Main main) {
      plugin = main;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("loc2set") && sender instanceof Player) {
         Player p;
         if (!sender.hasPermission("zey.pvp.set")) {
            p = (Player)sender;
            p.sendMessage("§cVocê não tem permissão para isso.");
         }

         if (sender.hasPermission("zey.pvp.set")) {
            p = (Player)sender;
            plugin.getConfig().set("loc2.x", p.getLocation().getX());
            plugin.getConfig().set("loc2.y", p.getLocation().getY());
            plugin.getConfig().set("loc2.z", p.getLocation().getZ());
            plugin.getConfig().set("loc2.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("loc2.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("loc2.world", p.getLocation().getWorld().getName());
            plugin.saveConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §aLOC2 foi setada com sucesso");
         }

         return true;
      } else {
         return false;
      }
   }
}
