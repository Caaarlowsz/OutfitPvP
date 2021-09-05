package Outfit.PvP.Menus;

import Outfit.PvP.APIs.WarpAPI;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuWarps
  implements Listener, CommandExecutor
{
  static int inFps = 0;
  static int inMain = 0;
  static int inLava = 0;
  static int inPotion = 0;
  static int inKB = 0;
  static int in1v1 = 0;
  static int inVoid = 0;
  static int inParkour = 0;
  static int inTextura = 0;
  static int inFish = 0;
  static int inSumo = 0;
  
  public static void guiKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§8[§dWARPS§8]");
    ItemStack event457 = new ItemStack(Material.GLOWSTONE_DUST, 1, (short)0);
    ItemMeta eventv1 = event457.getItemMeta();
    eventv1.setDisplayName("§d§lEVENTOS");
    event457.setItemMeta(eventv1);
    inv.setItem(8, event457);
    
    ItemStack fps = new ItemStack(Material.STAINED_GLASS, 1, (short)0);
    ItemMeta metafps = fps.getItemMeta();
    metafps.setDisplayName("§d§lFPS");
    ArrayList<String> descfps = new ArrayList();
    descfps.add("§7");
    descfps.add("§7Jogue em uma arena com o melhor fps possivel.");
    descfps.add("§7");
    descfps.add("§fJogadores aqui: §d" + inFps);
    metafps.setLore(descfps);
    fps.setItemMeta(metafps);
    inv.setItem(9, fps);
    
    ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1, (short)0);
    ItemMeta metalava = lava.getItemMeta();
    metalava.setDisplayName("§d§lCHALLENGE");
    ArrayList<String> desclava = new ArrayList();
    desclava.add("§7");
    desclava.add("§7Sobreviva ao enorme rio de lava.");
    desclava.add("§7");
    desclava.add("§fJogadores aqui: §d" + inLava);
    metalava.setLore(desclava);
    lava.setItemMeta(metalava);
    inv.setItem(10, lava);
    
    ItemStack voidc = new ItemStack(Material.BEDROCK, 1, (short)0);
    ItemMeta metavoidc = voidc.getItemMeta();
    metavoidc.setDisplayName("§d§lVOID");
    ArrayList<String> descvoidc = new ArrayList();
    descvoidc.add("§7");
    descvoidc.add("§7Tanke o maximo que conseguir no VOID.");
    descvoidc.add("§7");
    descvoidc.add("§fJogadores aqui: §d" + inVoid);
    metavoidc.setLore(descvoidc);
    voidc.setItemMeta(metavoidc);
    inv.setItem(17, voidc);
    
    ItemStack UmvUm = new ItemStack(Material.BLAZE_ROD, 1, (short)0);
    ItemMeta metaUmvUm = UmvUm.getItemMeta();
    metaUmvUm.setDisplayName("§d§l1v1");
    ArrayList<String> descUmvUm = new ArrayList();
    descUmvUm.add("§7");
    descUmvUm.add("§7Mostre para todos quem e melhor do servidor.");
    descUmvUm.add("§7");
    descUmvUm.add("§fJogadores aqui: §d" + in1v1);
    metaUmvUm.setLore(descUmvUm);
    UmvUm.setItemMeta(metaUmvUm);
    inv.setItem(12, UmvUm);
    
    ItemStack sumo = new ItemStack(Material.GOLDEN_APPLE, 1, (short)0);
    ItemMeta metasumo = sumo.getItemMeta();
    metasumo.setDisplayName("§d§lSUMO");
    ArrayList<String> descsumo = new ArrayList();
    descsumo.add("§7");
    descsumo.add("§7Derrube o oponente para fora da arena.");
    descsumo.add("§7");
    descsumo.add("§fJogadores aqui: §d" + inSumo);
    metasumo.setLore(descsumo);
    sumo.setItemMeta(metasumo);
    inv.setItem(13, sumo);
    
    ItemStack main = new ItemStack(Material.DIAMOND_SWORD, 1, (short)0);
    ItemMeta metamain = main.getItemMeta();
    metamain.setDisplayName("§d§lMAIN");
    ArrayList<String> descmain = new ArrayList();
    descmain.add("§7");
    descmain.add("§7Jogue com furia e velocidade.");
    descmain.add("§7");
    descmain.add("§fJogadores aqui: §d" + inMain);
    metamain.setLore(descmain);
    main.setItemMeta(metamain);
    inv.setItem(11, main);
    
    ItemStack potion = new ItemStack(Material.POTION, 1, (short)0);
    ItemMeta metapotion = potion.getItemMeta();
    metapotion.setDisplayName("§d§lPOTION");
    ArrayList<String> descpotion = new ArrayList();
    descpotion.add("§7");
    descpotion.add("§7Recupere sua vida com pocoes.");
    descpotion.add("§7");
    descpotion.add("§fJogadores aqui: §d" + inPotion);
    metapotion.setLore(descpotion);
    potion.setItemMeta(metapotion);
    inv.setItem(14, potion);
    
    ItemStack parkour = new ItemStack(Material.GRASS, 1, (short)0);
    ItemMeta metaparkour = parkour.getItemMeta();
    metaparkour.setDisplayName("§d§lPARKOUR");
    ArrayList<String> descparkour = new ArrayList();
    descparkour.add("§7");
    descparkour.add("§7Venca o maior desafio do servidor.");
    descparkour.add("§7");
    descparkour.add("§fJogadores aqui: §d" + inParkour);
    metaparkour.setLore(descparkour);
    parkour.setItemMeta(metaparkour);
    inv.setItem(22, parkour);
    
    ItemStack textura = new ItemStack(Material.ITEM_FRAME, 1, (short)0);
    ItemMeta metatextura = textura.getItemMeta();
    metatextura.setDisplayName("§d§lTEXTURA");
    ArrayList<String> desctextura = new ArrayList();
    desctextura.add("§7");
    desctextura.add("§7Encontre sua textura perfeita.");
    desctextura.add("§7");
    desctextura.add("§fJogadores aqui: §d" + inTextura);
    metatextura.setLore(desctextura);
    textura.setItemMeta(metatextura);
    
    ItemStack kb = new ItemStack(Material.STICK, 1, (short)0);
    ItemMeta metakb = kb.getItemMeta();
    metakb.setDisplayName("§d§lKNOCKBACK");
    ArrayList<String> desckb = new ArrayList();
    desckb.add("§7");
    desckb.add("§7Faça os inimigos voarem para fora arena.");
    desckb.add("§7");
    desckb.add("§fJogadores aqui: §d" + inKB);
    metakb.setLore(desckb);
    kb.setItemMeta(metakb);
    inv.setItem(15, kb);
    
    ItemStack fish = new ItemStack(Material.FISHING_ROD, 1, (short)0);
    ItemMeta metafish = fish.getItemMeta();
    metafish.setDisplayName("§d§lFISHERMAN");
    ArrayList<String> descfish = new ArrayList();
    descfish.add("§7");
    descfish.add("§7Pesque jogadores e o jogue em buracos.");
    descfish.add("§7");
    descfish.add("§fJogadores aqui: §d" + inFish);
    metafish.setLore(descfish);
    fish.setItemMeta(metafish);
    inv.setItem(16, fish);
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
    ItemMeta vidrox = vidro.getItemMeta();
    vidrox.setDisplayName("§6§lKombo§f§lPvP");
    vidro.setItemMeta(vidrox);
    
    ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
    ItemMeta vidrom2 = vidro.getItemMeta();
    vidrom2.setDisplayName("§6§lKombo§f§lPvP");
    vidro2.setItemMeta(vidrom2);
    
    ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8);
    ItemMeta vidrom3 = vidro.getItemMeta();
    vidrom3.setDisplayName("§6§lKombo§f§lPvP");
    vidro3.setItemMeta(vidrom3);
    
    inv.setItem(0, vidro);
    inv.setItem(1, vidro2);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro2);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro2);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro2);
    inv.setItem(18, vidro2);
    inv.setItem(19, vidro);
    inv.setItem(20, vidro2);
    inv.setItem(21, vidro);
    inv.setItem(23, vidro);
    inv.setItem(24, vidro2);
    inv.setItem(25, vidro);
    inv.setItem(26, vidro2);
    ItemStack[] arrayOfItemStack;
    int descpyro2 = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro2 = 0; metapyro2 < descpyro2; metapyro2++) {
      ItemStack localItemStack1 = arrayOfItemStack[metapyro2];
    }
    p.openInventory(inv);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (commandLabel.equalsIgnoreCase("warps"))
    {
      Player p = (Player)sender;
      guiKits(p);
    }
    return false;
  }
  
  public static int AddWarp(Player p)
  {
    if (WarpAPI.getWarp(p) == "Fps") {
      return ++inFps;
    }
    if (WarpAPI.getWarp(p) == "Main") {
      return ++inMain;
    }
    if (WarpAPI.getWarp(p) == "Challenge") {
      return ++inLava;
    }
    if (WarpAPI.getWarp(p) == "Potion") {
      return ++inPotion;
    }
    if (WarpAPI.getWarp(p) == "Parkour") {
      return ++inParkour;
    }
    if (WarpAPI.getWarp(p) == "Textura") {
      return ++inTextura;
    }
    if (WarpAPI.getWarp(p) == "Void") {
      return ++inVoid;
    }
    if (WarpAPI.getWarp(p) == "Knockback") {
      return ++inKB;
    }
    if (WarpAPI.getWarp(p) == "Fisherman") {
      return ++inFish;
    }
    if (WarpAPI.getWarp(p) == "Sumo") {
      return ++inSumo;
    }
    if (WarpAPI.getWarp(p) == "1v1") {
      return ++in1v1;
    }
    return in1v1 = in1v1 + 0;
  }
  
  public static int RemoveWarp(Player p)
  {
    if (WarpAPI.getWarp(p) == "Fps") {
      return --inFps;
    }
    if (WarpAPI.getWarp(p) == "Main") {
      return --inMain;
    }
    if (WarpAPI.getWarp(p) == "Challenge") {
      return --inLava;
    }
    if (WarpAPI.getWarp(p) == "Potion") {
      return --inPotion;
    }
    if (WarpAPI.getWarp(p) == "Parkour") {
      return --inParkour;
    }
    if (WarpAPI.getWarp(p) == "Textura") {
      return --inTextura;
    }
    if (WarpAPI.getWarp(p) == "Void") {
      return --inVoid;
    }
    if (WarpAPI.getWarp(p) == "Knockback") {
      return --inKB;
    }
    if (WarpAPI.getWarp(p) == "Fisherman") {
      return --inFish;
    }
    if (WarpAPI.getWarp(p) == "Sumo") {
      return --inSumo;
    }
    if (WarpAPI.getWarp(p) == "1v1") {
      return --in1v1;
    }
    return in1v1 = in1v1 - 0;
  }
  
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§8[§dWARPS§8]")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lEVENTOS"))
      {
        e.setCancelled(true);
        p.closeInventory();
        MenuEventos.guiKits(p);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lFPS"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/fps");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§l1v1"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/1v1");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lSUMO"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/sumo");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lCHALLENGE"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/challenge");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lVOID"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/void");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMAIN"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/main");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lTEXTURA"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/textura");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lKNOCKBACK"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/knockback");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lFISHERMAN"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/fisherman");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lPOTION"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/potion");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lPARKOUR"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/parkour");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
      }
    }
  }
  
  public static void ir(Player p, String string) {}
}
