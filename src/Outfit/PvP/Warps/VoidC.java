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
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class VoidC implements Listener, CommandExecutor {
   public static Main plugin;

   public VoidC(Main main) {
      plugin = main;
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("void")) {
         Player p = (Player)sender;
         p.setFlying(false);
         p.setAllowFlight(false);
         p.setGameMode(GameMode.SURVIVAL);
         World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("void.world"));
         double x = Main.instance.getConfig().getDouble("void.x");
         double y = Main.instance.getConfig().getDouble("void.y");
         double z = Main.instance.getConfig().getDouble("void.z");
         Location lobby = new Location(w, x, y, z);
         lobby.setPitch((float)Main.instance.getConfig().getDouble("void.pitch"));
         lobby.setYaw((float)Main.instance.getConfig().getDouble("void.yaw"));
         p.getInventory().clear();
         p.sendMessage("");
         p.sendMessage("");
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aTeleportado com sucesso");
         TheTitle.sendTitle(p, "§d§lVOID");
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
         Proteção.setImortal(p, true);
         Proteção.isImortal(p);
         if (WarpAPI.getWarp(p) != "Void") {
            MenuWarps.RemoveWarp(p);
            WarpAPI.setWarp(p, "Void");
            MenuWarps.AddWarp(p);
         }

         p.getInventory().setBoots((ItemStack)null);
         p.getInventory().setChestplate((ItemStack)null);
         p.getInventory().setLeggings((ItemStack)null);
         p.getInventory().setHelmet((ItemStack)null);
         p.setFireTicks(0);
         ItemStack sopas = new ItemStack(Material.BOWL, 64);
         ItemMeta ksopas = sopas.getItemMeta();
         sopas.setItemMeta(ksopas);
         ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
         ItemMeta kcogur = cogur.getItemMeta();
         cogur.setItemMeta(kcogur);
         ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
         ItemMeta kcogum = cogum.getItemMeta();
         cogum.setItemMeta(kcogum);
         p.getInventory().setItem(13, sopas);
         p.getInventory().setItem(14, cogur);
         p.getInventory().setItem(15, cogum);
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
         p.teleport(lobby);
         for (final PotionEffect effect : p.getActivePotionEffects()) {
             p.removePotionEffect(effect.getType());
         }
       }
     return false;
   }
}
