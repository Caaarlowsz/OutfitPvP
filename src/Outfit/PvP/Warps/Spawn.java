package Outfit.PvP.Warps;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.CombatLog;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.OneVsOne.Speed1v1;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class Spawn implements Listener, CommandExecutor {
   public static Main plugin;

   public Spawn(Main main) {
      plugin = main;
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("spawn")) {
         Player p = (Player)sender;
         World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
         double x = plugin.getConfig().getDouble("spawn.x");
         double y = plugin.getConfig().getDouble("spawn.y");
         double z = plugin.getConfig().getDouble("spawn.z");
         Location lobby = new Location(w, x, y, z);
         lobby.setPitch((float)plugin.getConfig().getDouble("spawn.pitch"));
         lobby.setYaw((float)plugin.getConfig().getDouble("spawn.yaw"));
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
         Habilidade.removeAbility(p);
         KitAPI.removeAbility(p);
         BuildCommand.embuild.remove(p);
         p.setGameMode(GameMode.SURVIVAL);
         MenuWarps.RemoveWarp(p);
         WarpAPI.setWarp(p, "Spawn");
         if (CombatLog.Sair.contains(p.getName())) {
            CombatLog.Sair.remove(p.getName());
         }

         if (Speed1v1.NeginhoSegundos.contains(p)) {
            Speed1v1.Partida1 = false;
            Speed1v1.Nome = "";
            Speed1v1.Iniciou.remove(p);
            Speed1v1.NeginhoSegundos.remove(p);
         }

         p.getInventory().setBoots((ItemStack)null);
         p.getInventory().setChestplate((ItemStack)null);
         p.getInventory().setLeggings((ItemStack)null);
         p.getInventory().setHelmet((ItemStack)null);
         p.getInventory().clear();
         p.teleport(lobby);
         p.setExp(0.0F);
         p.setHealthScale(20.0D);
         p.setExhaustion(20.0F);
         p.setFireTicks(0);
         p.setFoodLevel(20000);
         p.setHealth(20.0D);
         TheTitle.sendTitle(p, "§d§lSPAWN");
         TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
         Proteção.setImortal(p, true);
         Proteção.isImortal(p);
         ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
         ItemMeta vidrohotx = vidrohot.getItemMeta();
         vidrohotx.setDisplayName("§f-");
         vidrohot.setItemMeta(vidrohotx);
         ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
         ItemMeta vidrom2 = vidrohot.getItemMeta();
         vidrom2.setDisplayName("§d-");
         vidro2.setItemMeta(vidrom2);
         KitAPI.setitem(p, Material.ENDER_CHEST, "§dCaixas §7(Clique)", 1, Enchantment.DAMAGE_ALL, 0, false);
         KitAPI.setitem(p, Material.EXPLOSIVE_MINECART, "§dWarps §7(Clique)", 3, Enchantment.DAMAGE_ALL, 0, false);
         KitAPI.setitem(p, Material.STORAGE_MINECART, "§dKits §7(Clique)", 4, Enchantment.DAMAGE_ALL, 0, false);
         KitAPI.setitem(p, Material.HOPPER_MINECART, "§dMenu §7(Clique)", 5, Enchantment.DAMAGE_ALL, 0, false);
         KitAPI.setitem(p, Material.GOLD_NUGGET, "§dDolls Diario §7(Clique)", 7, Enchantment.DAMAGE_ALL, 0, false);
         for (final PotionEffect effect : p.getActivePotionEffects()) {
             p.removePotionEffect(effect.getType());
         }
       }
     return false;
   }
}

