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

public class WarpRdm implements Listener, CommandExecutor {
   public static Main plugin;

   public WarpRdm(Main main) {
      plugin = main;
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("rdm")) {
         Player p = (Player)sender;
         World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("rdm.world"));
         double x = plugin.getConfig().getDouble("rdm.x");
         double y = plugin.getConfig().getDouble("rdm.y");
         double z = plugin.getConfig().getDouble("rdm.z");
         Location lobby = new Location(w, x, y, z);
         lobby.setPitch((float)plugin.getConfig().getDouble("rdm.pitch"));
         lobby.setYaw((float)plugin.getConfig().getDouble("rdm.yaw"));
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
         TheTitle.sendTitle(p, "§d§lRDM");
         TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
         int i;
         if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
            Main.admins.remove(p.getName());
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você saiu do modo §c§lADMIN");
            Player[] var17;
            int var16 = (var17 = Bukkit.getOnlinePlayers()).length;

            for(i = 0; i < var16; ++i) {
               Player players = var17[i];
               players.showPlayer(p);
            }
         }

         p.setAllowFlight(false);
         p.setFlying(false);
         Habilidade.setAbility(p, "Warp");
         MenuWarps.RemoveWarp(p);
         KitAPI.remove(p);
         KitAPI.removeAbility(p);
         BuildCommand.embuild.remove(p);
         p.setGameMode(GameMode.SURVIVAL);
         WarpAPI.setWarp(p, "Evento");
         ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);

         for(i = 0; i < 9; ++i) {
            p.getInventory().setItem(i, sopa);
         }

         KitUtil.darFullIron(p);
         ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
         espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
         p.getInventory().setItem(0, espada);
         p.setHealthScale(20.0D);
         Proteção.setImortal(p, false);
         Proteção.isImortal(p);
         p.setFireTicks(0);
         for (final PotionEffect effect : p.getActivePotionEffects()) {
             p.removePotionEffect(effect.getType());
         }
       }
     return false;
   }
 }
