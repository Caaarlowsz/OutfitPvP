package Outfit.PvP.Eventos;

import Outfit.PvP.APIs.TagsAPI;
import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Config.ConfigManager;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Entrar
  implements Listener {
  @EventHandler
  public void Join(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    
    e.setJoinMessage(null);
    TheTitle.sendTitle(p, Main.prefix);
    TheTitle.sendSubTitle(p, "§7Use: §d/Login §7ou §d/Register§7!");
    
    KitAPI.remove(p);
    ConfigManager.RemoverKS(p);
    Habilidade.removeAbility(p);
    KitAPI.removeAbility(p);
    BuildCommand.embuild.remove(p);
    p.setGameMode(GameMode.SURVIVAL);
    WarpAPI.setWarp(p, "Spawn");
    p.setFireTicks(0);
    
    Proteção.setImortal(p, true);
    Proteção.isImortal(p);
    
    for (PotionEffect effect : p.getActivePotionEffects()) {
      p.removePotionEffect(effect.getType());
    }
    
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§a  ");
    p.sendMessage("§c" + Main.prefix + " §8➸ §7Os melhores estao aqui!");
    p.sendMessage("§a  ");
    if (p.hasPermission("zey.pvp.slotvip")) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            Bukkit.broadcastMessage(p.getDisplayName() + " §7entrou no servidor!");
          }
        }, 5L);
      }
    p.teleport(p.getWorld().getSpawnLocation());
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 0.0F);
    p.getInventory().setHelmet(null);
    p.getInventory().setChestplate(null);
    p.getInventory().setLeggings(null);
    p.getInventory().setBoots(null);
    p.getInventory().clear();
    
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

    
    if (p.getName().equalsIgnoreCase("Win1"))
    {
      if (ZeyCoins.getPlayerMoney(p) == 0) {
        ZeyCoins.addMoney(p, 100000);
      }
    }
    
    if (p.getName().equalsIgnoreCase("Win2"))
    {
      if (ZeyCoins.getPlayerMoney(p) == 0) {
        ZeyCoins.addMoney(p, 50000);
      }
    }
    
    if (p.getName().equalsIgnoreCase("Win3"))
    {
      if (ZeyCoins.getPlayerMoney(p) == 0) {
        ZeyCoins.addMoney(p, 25000);
      }
    }
    
    if (ZeyCoins.getPlayerMoney(p) == 0) {
      ZeyCoins.addMoney(p, 2501);
    }
    
    TagsAPI.SetarTag(p);
  }
  
  @EventHandler
  public void Morte(PlayerRespawnEvent e) {
    final Player p = e.getPlayer();
    
    if (WarpAPI.getWarp(p) == "Challenge") {
      
      TheTitle.sendTitle(p, "§d§lCHALLENGE");
      TheTitle.sendSubTitle(p, "§7Tente Novamente!");
      
      p.getInventory().clear();
      
      ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
      for (int i = 0; i < 36; i++) {
        p.getInventory().setItem(i, sopa);
      }
      
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
      p.updateInventory();
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Void") {
      
      TheTitle.sendTitle(p, "§d§lVOID");
      TheTitle.sendSubTitle(p, "§7Tente Novamente!");
      
      p.getInventory().clear();
      
      ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
      for (int i = 0; i < 36; i++) {
        p.getInventory().setItem(i, sopa);
      }
      
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
      p.updateInventory();
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Knockback") {
      
      TheTitle.sendTitle(p, "§d§lKNOCKBACK");
      TheTitle.sendSubTitle(p, "§7Tente Novamente!");
      
      if (CombatLog.Sair.contains(p.getName())) {
        CombatLog.Sair.remove(p.getName());
      }
      
      p.getInventory().clear();
      
      ItemStack k = new ItemStack(Material.STICK);
      ItemMeta km = k.getItemMeta();
      km.setDisplayName("§cKnock-Back");
      km.addEnchant(Enchantment.KNOCKBACK, 10, true);
      k.setItemMeta(km);
      
      p.getInventory().setItem(0, k);
      p.updateInventory();
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Fisherman") {
      
      TheTitle.sendTitle(p, "§d§lFISHERMAN");
      TheTitle.sendSubTitle(p, "§7Tente Novamente!");
      
      if (CombatLog.Sair.contains(p.getName())) {
        CombatLog.Sair.remove(p.getName());
      }
      
      p.getInventory().clear();
      KitAPI.Kit.add(p.getName());
      KitAPI.Fisherman.add(p.getName());
      KitAPI.setitem(p, Material.FISHING_ROD, "§d§lFISHERMAN", 0, Enchantment.DAMAGE_ALL, 0, false);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 0));
            }
          },1L);
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Main") {
      
      TheTitle.sendTitle(p, "§d§lMAIN");
      TheTitle.sendSubTitle(p, "§7Você morreu.");
      
      if (CombatLog.Sair.contains(p.getName())) {
        CombatLog.Sair.remove(p.getName());
      }
      
      p.getInventory().clear();
      
      ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
      for (int i = 0; i < 36; i++) {
        p.getInventory().setItem(i, sopa);
        p.updateInventory();
      } 
      
      KitUtil.darFullIron(p);
      
      p.setHealthScale(20.0D);
      ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
      espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
      espada.addEnchantment(Enchantment.DURABILITY, 3);
      p.getInventory().setItem(0, espada);
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
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
              p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 100));
            }
          },1L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
              p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
            }
          },1L);
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Potion") {
      
      TheTitle.sendTitle(p, "§d§lPOTION");
      TheTitle.sendSubTitle(p, "§7Você morreu.");
      
      if (CombatLog.Sair.contains(p.getName())) {
        CombatLog.Sair.remove(p.getName());
      }
      
      p.getInventory().clear();
      
      ItemStack potion = new ItemStack(Material.POTION, 1, (short)16421);
      for (int i = 0; i < 36; i++) {
        p.getInventory().setItem(i, potion);
        p.updateInventory();
      } 
      
      KitUtil.darFullIron(p);
      p.setHealthScale(20.0D);
      ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
      espada.addEnchantment(Enchantment.DURABILITY, 3);
      p.getInventory().setItem(0, espada);
      p.setFireTicks(0);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
              p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 100));
            }
          },1L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
            }
          },1L);
      
      return;
    } 
    
    if (WarpAPI.getWarp(p) == "Fps") {
      
      TheTitle.sendTitle(p, "§d§lFPS");
      TheTitle.sendSubTitle(p, "§7Você morreu.");
      
      if (CombatLog.Sair.contains(p.getName())) {
        CombatLog.Sair.remove(p.getName());
      }
      
      p.getInventory().clear();
      
      ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
      for (int i = 0; i < 36; i++) {
        p.getInventory().setItem(i, sopa);
        p.updateInventory();
      } 
      
      KitUtil.darFullIron(p);
      
      p.setHealthScale(20.0D);
      ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
      espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
      espada.addEnchantment(Enchantment.DURABILITY, 3);
      p.getInventory().setItem(0, espada);
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
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
          {
            public void run() {
              p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
              p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 100));
            }
          },1L);
      
      return;
    } 
    
    p.getInventory().setHelmet(null);
    p.getInventory().setChestplate(null);
    p.getInventory().setLeggings(null);
    p.getInventory().setBoots(null);
    p.getInventory().clear();
    
    KitAPI.remove(p);
    KitUtil.ccooldown(p);
    Habilidade.removeAbility(p);
    KitAPI.removeAbility(p);
    BuildCommand.embuild.remove(p);
    p.setGameMode(GameMode.SURVIVAL);
    WarpAPI.setWarp(p, "Spawn");
    if (CombatLog.Sair.contains(p.getName())) {
      CombatLog.Sair.remove(p.getName());
    }
    
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
    
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), new Runnable()
        {
          public void run()
          {
            TheTitle.sendTitle(p, Main.prefix);
            TheTitle.sendSubTitle(p, "§7Você morreu.");
            p.playSound(p.getLocation(), Sound.ARROW_HIT, 5.0F, 0.0F);
          }
        },1L);
  }

  
  public static void setitem(Player p, Material mat, String nome, int lugar, Enchantment enchant, int level, boolean trueorfalse) {
    ItemStack item = new ItemStack(mat);
    ItemMeta itemmeta = item.getItemMeta();
    itemmeta.setDisplayName(nome);
    itemmeta.addEnchant(enchant, level, trueorfalse);
    item.setItemMeta(itemmeta);
    p.getInventory().setItem(lugar, item);
  }
  
  @EventHandler
  public void onSair(PlayerQuitEvent e) {
    Player p = e.getPlayer();
    
    if (WarpAPI.getWarp(p) == "SCREENSHARE") {
      MenuWarps.RemoveWarp(p);
      Bukkit.broadcastMessage(String.valueOf(String.valueOf(Main.prefix)) + " §8➸ §7O jogador(a): §d" + p.getName() + " §7§c§lDESLOGOU§7 na §d§lSCREENSHARE!");
      Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ban " + p.getName() + " [AutoBan] Deslogou enquanto estava em §lSCREENSHARE!");
      e.setQuitMessage(null);
    } 
    
    if (WarpAPI.getWarp(p) != "SCREENSHARE") {
      MenuWarps.RemoveWarp(p);
      e.setQuitMessage(null);
      if (p.hasPermission("zey.pvp.slotvip")) {
          Bukkit.broadcastMessage(p.getDisplayName() + " §7saiu do servidor!");
        }
    } 
  }
}