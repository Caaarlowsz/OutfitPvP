package Outfit.PvP.Warps;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class wFisherman implements Listener, CommandExecutor {
   public static Main plugin;

   public wFisherman(Main main) {
      plugin = main;
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("fisherman")) {
         Player p = (Player)sender;
         World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("fish.world"));
         double x = plugin.getConfig().getDouble("fish.x");
         double y = plugin.getConfig().getDouble("fish.y");
         double z = plugin.getConfig().getDouble("fish.z");
         Location lobby = new Location(w, x, y, z);
         lobby.setPitch((float)plugin.getConfig().getDouble("fish.pitch"));
         lobby.setYaw((float)plugin.getConfig().getDouble("fish.yaw"));
         p.teleport(lobby);
         p.getInventory().clear();
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aTeleportado com sucesso");
         TheTitle.sendTitle(p, "§d§lFISHERMAN");
         TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
         if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
            Main.admins.remove(p.getName());
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você saiu do modo §c§lADMIN");
            Player[] var17;
            int var16 = (var17 = Bukkit.getOnlinePlayers()).length;

            for(int var15 = 0; var15 < var16; ++var15) {
               Player players = var17[var15];
               players.showPlayer(p);
            }
         }

         p.setAllowFlight(false);
         p.setFlying(false);
         KitAPI.remove(p);
         Habilidade.setAbility(p, "Warp");
         KitAPI.removeAbility(p);
         BuildCommand.embuild.remove(p);
         p.setGameMode(GameMode.SURVIVAL);
         if (WarpAPI.getWarp(p) != "Fisherman") {
            MenuWarps.RemoveWarp(p);
            WarpAPI.setWarp(p, "Fisherman");
            MenuWarps.AddWarp(p);
         }

         Proteção.setImortal(p, false);
         Proteção.isImortal(p);
         p.setHealthScale(20.0D);
         p.setFireTicks(0);

         for (final PotionEffect effect : p.getActivePotionEffects()) {
         p.removePotionEffect(effect.getType());
         }
         
         p.getInventory().setBoots((ItemStack)null);
         p.getInventory().setChestplate((ItemStack)null);
         p.getInventory().setLeggings((ItemStack)null);
         p.getInventory().setHelmet((ItemStack)null);
         KitAPI.Kit.add(p.getName());
         KitAPI.Fisherman.add(p.getName());
         KitAPI.setitem(p, Material.FISHING_ROD, "§d§lFISHERMAN", 0, Enchantment.DAMAGE_ALL, 0, false);
         p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 0));
      }

      return false;
   }
}
