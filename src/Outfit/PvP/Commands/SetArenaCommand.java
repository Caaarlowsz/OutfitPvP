package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetArenaCommand implements Listener, CommandExecutor {
   public static Main plugin;

   public SetArenaCommand(Main main) {
      plugin = main;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      if (p.hasPermission("zey.pvp.setarena") && label.equalsIgnoreCase("setarena")) {
         if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /setarena (1 - 5)");
            return true;
         }

         if (args[0].equalsIgnoreCase("1")) {
            Main.getPlugin().getConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aA Arena 1 Foi Setada");
            plugin.getConfig().set("arena1.x", p.getLocation().getX());
            plugin.getConfig().set("arena1.y", p.getLocation().getY());
            plugin.getConfig().set("arena1.z", p.getLocation().getZ());
            p.getWorld();
            plugin.getConfig().set("arena1.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("arena1.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("arena1.world", p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();
         }

         if (args[0].equalsIgnoreCase("2")) {
            Main.getPlugin().getConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aA Arena 2 Foi Setada");
            plugin.getConfig().set("arena2.x", p.getLocation().getX());
            plugin.getConfig().set("arena2.y", p.getLocation().getY());
            plugin.getConfig().set("arena2.z", p.getLocation().getZ());
            p.getWorld();
            plugin.getConfig().set("arena2.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("arena2.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("arena2.world", p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();
         }

         if (args[0].equalsIgnoreCase("3")) {
            Main.getPlugin().getConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aA Arena 3 Foi Setada");
            plugin.getConfig().set("arena3.x", p.getLocation().getX());
            plugin.getConfig().set("arena3.y", p.getLocation().getY());
            plugin.getConfig().set("arena3.z", p.getLocation().getZ());
            p.getWorld();
            plugin.getConfig().set("arena3.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("arena3.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("arena3.world", p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();
         }

         if (args[0].equalsIgnoreCase("4")) {
            Main.getPlugin().getConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aA Arena 4 Foi Setada");
            plugin.getConfig().set("arena4.x", p.getLocation().getX());
            plugin.getConfig().set("arena4.y", p.getLocation().getY());
            plugin.getConfig().set("arena4.z", p.getLocation().getZ());
            p.getWorld();
            plugin.getConfig().set("arena4.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("arena4.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("arena4.world", p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();
         }

         if (args[0].equalsIgnoreCase("5")) {
            Main.getPlugin().getConfig();
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aA Arena 5 Foi Setada");
            plugin.getConfig().set("arena5.x", p.getLocation().getX());
            plugin.getConfig().set("arena5.y", p.getLocation().getY());
            plugin.getConfig().set("arena5.z", p.getLocation().getZ());
            p.getWorld();
            plugin.getConfig().set("arena5.pitch", p.getLocation().getPitch());
            plugin.getConfig().set("arena5.yaw", p.getLocation().getYaw());
            plugin.getConfig().set("arena5.world", p.getLocation().getWorld().getName());
            Main.plugin.saveConfig();
         }
      }

      return false;
   }

   public static void TeleportArenaRandom(Player p) {
      Random dice = new Random();
      int number = dice.nextInt(4);
      World w5;
      double x5;
      double y5;
      double z5;
      Location lobby5;
      switch(number) {
      case 0:
         w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena1.world"));
         x5 = plugin.getConfig().getDouble("arena1.x");
         y5 = plugin.getConfig().getDouble("arena1.y");
         z5 = plugin.getConfig().getDouble("arena1.z");
         lobby5 = new Location(w5, x5, y5, z5);
         lobby5.setPitch((float)plugin.getConfig().getDouble("arena1.pitch"));
         lobby5.setYaw((float)plugin.getConfig().getDouble("arena1.yaw"));
         p.teleport(lobby5);
         break;
      case 1:
         w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena2.world"));
         x5 = plugin.getConfig().getDouble("arena2.x");
         y5 = plugin.getConfig().getDouble("arena2.y");
         z5 = plugin.getConfig().getDouble("arena2.z");
         lobby5 = new Location(w5, x5, y5, z5);
         lobby5.setPitch((float)plugin.getConfig().getDouble("arena2.pitch"));
         lobby5.setYaw((float)plugin.getConfig().getDouble("arena2.yaw"));
         p.teleport(lobby5);
         break;
      case 2:
         w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena3.world"));
         x5 = plugin.getConfig().getDouble("arena3.x");
         y5 = plugin.getConfig().getDouble("arena3.y");
         z5 = plugin.getConfig().getDouble("arena3.z");
         lobby5 = new Location(w5, x5, y5, z5);
         lobby5.setPitch((float)plugin.getConfig().getDouble("arena3.pitch"));
         lobby5.setYaw((float)plugin.getConfig().getDouble("arena3.yaw"));
         p.teleport(lobby5);
         break;
      case 3:
         w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena4.world"));
         x5 = plugin.getConfig().getDouble("arena4.x");
         y5 = plugin.getConfig().getDouble("arena4.y");
         z5 = plugin.getConfig().getDouble("arena4.z");
         lobby5 = new Location(w5, x5, y5, z5);
         lobby5.setPitch((float)plugin.getConfig().getDouble("arena4.pitch"));
         lobby5.setYaw((float)plugin.getConfig().getDouble("arena4.yaw"));
         p.teleport(lobby5);
         break;
      case 4:
         w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena5.world"));
         x5 = plugin.getConfig().getDouble("arena5.x");
         y5 = plugin.getConfig().getDouble("arena5.y");
         z5 = plugin.getConfig().getDouble("arena5.z");
         lobby5 = new Location(w5, x5, y5, z5);
         lobby5.setPitch((float)plugin.getConfig().getDouble("arena5.pitch"));
         lobby5.setYaw((float)plugin.getConfig().getDouble("arena5.yaw"));
         p.teleport(lobby5);
      }

   }
}
