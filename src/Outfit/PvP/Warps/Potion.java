package Outfit.PvP.Warps;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
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

public class Potion implements Listener, CommandExecutor {
   public static Main plugin;

   public Potion(Main main) {
      plugin = main;
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("potion")) {
         Player p = (Player)sender;
         World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("potion.world"));
         double x = plugin.getConfig().getDouble("potion.x");
         double y = plugin.getConfig().getDouble("potion.y");
         double z = plugin.getConfig().getDouble("potion.z");
         Location lobby = new Location(w, x, y, z);
         lobby.setPitch((float)plugin.getConfig().getDouble("potion.pitch"));
         lobby.setYaw((float)plugin.getConfig().getDouble("potion.yaw"));
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
         TheTitle.sendTitle(p, "§d§lPOTION");
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
         if (WarpAPI.getWarp(p) != "Potion") {
            MenuWarps.RemoveWarp(p);
            WarpAPI.setWarp(p, "Potion");
            MenuWarps.AddWarp(p);
         }

         Proteção.setImortal(p, false);
         Proteção.isImortal(p);
         KitUtil.darFullIron(p);
         p.setHealthScale(20.0D);
         ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
         espada.addEnchantment(Enchantment.DURABILITY, 3);
         p.getInventory().setItem(0, espada);
         p.setFireTicks(0);
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.POTION, 1, (short)16421)});
         
         for (final PotionEffect effect : p.getActivePotionEffects()) {
             p.removePotionEffect(effect.getType());
         }
         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
      }
      return false;
   }
}
