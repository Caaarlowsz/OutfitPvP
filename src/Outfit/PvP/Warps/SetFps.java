package Outfit.PvP.Warps;

import Outfit.PvP.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetFps implements Listener, CommandExecutor {
   public static Main plugin;

   public SetFps(Main main) {
      plugin = main;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("fpsset") && sender instanceof Player) {
         Player p;
         if (!sender.hasPermission("zey.pvp.set")) {
            p = (Player)sender;
            p.sendMessage("§cVocê não tem permissão para isso.");
         }

         if (sender.hasPermission("zey.pvp.set")) {
            p = (Player)sender;
            plugin.getConfig().set("fps.x", p.getLocation().getX());
            plugin.getConfig().set("fps.y", p.getLocation().getY());
            plugin.getConfig().set("fps.z", p.getLocation().getZ());
            plugin.getConfig().set("fps.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("fps.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("fps.world", p.getLocation().getWorld().getName());
            plugin.saveConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Fps foi setada com sucesso");
         }

         return true;
      } else {
         return false;
      }
   }
}
