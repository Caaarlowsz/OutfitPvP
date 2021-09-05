package Outfit.PvP.Menus;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Outfit.PvP.Commands.IniciarCommand;
import Outfit.PvP.Main.*;

import org.bukkit.command.*;

public class MenuKits2 implements Listener, CommandExecutor
{
    public MenuKits2(final Main main) {
    }
    
	public static void guiKits1(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 54, "§8[§dKITS§8] §7(Pag. 2).");

        final ItemStack vidro22 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta meta31v = vidro22.getItemMeta();
        meta31v.setDisplayName("§8[§dKITS§8] §7(Pag. 1).");
        vidro22.setItemMeta(meta31v);
        inv.setItem(0, vidro22);
        
        final ItemStack warps = new ItemStack(Material.REDSTONE);
        final ItemMeta warpsx = warps.getItemMeta();
        warpsx.setDisplayName("§d§lWARPS");
        warps.setItemMeta(warpsx);
        
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName("§6§lKombo§f§lPvP");
        vidro.setItemMeta(vidrom);
        
        final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
        final ItemMeta vidrom2 = vidro.getItemMeta();
        vidrom2.setDisplayName("§6§lKombo§f§lPvP");
        vidro2.setItemMeta(vidrom);

        inv.setItem(1, vidro2);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro2);
        inv.setItem(3, vidro2);
        inv.setItem(5, vidro2);
        inv.setItem(4, warps);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro2);
        inv.setItem(8, vidro);
        inv.setItem(44, vidro);
        inv.setItem(45, vidro2);
        inv.setItem(46, vidro);
        inv.setItem(47, vidro2);
        inv.setItem(48, vidro);
        inv.setItem(49, vidro2);
        inv.setItem(50, vidro);
        inv.setItem(51, vidro2);
        inv.setItem(52, vidro);
        inv.setItem(53, vidro2);
        
        final ItemStack breve = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta mente = breve.getItemMeta();
        mente.setDisplayName("§cVidrin");
        breve.setItemMeta(mente);
        inv.setItem(17, breve);
        inv.setItem(18, breve);
        inv.setItem(19, breve);
        inv.setItem(20, breve);
        inv.setItem(21, breve);
        inv.setItem(22, breve);
        inv.setItem(23, breve);
        inv.setItem(24, breve);
        inv.setItem(25, breve);
        inv.setItem(26, breve);
        inv.setItem(27, breve);
        inv.setItem(28, breve);
        inv.setItem(29, breve);
        inv.setItem(30, breve);
        inv.setItem(31, breve);
        inv.setItem(32, breve);
        inv.setItem(33, breve);
        inv.setItem(34, breve);
        inv.setItem(35, breve);
        inv.setItem(36, breve);
        inv.setItem(37, breve);
        inv.setItem(38, breve);
        inv.setItem(39, breve);
        inv.setItem(40, breve);
        inv.setItem(41, breve);
        inv.setItem(42, breve);
        inv.setItem(43, breve);
        inv.setItem(44, breve);
        
        if (p.hasPermission("kit.madman") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.POTION, 1, (short)8296);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lMadman");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Cause fraqueza em inimigos");
            descpyro.add("§7pertos de você.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.specialist") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.ENCHANTED_BOOK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lSpecialist");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Mate inimigos e encante sua espada.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.ryu") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.DIAMOND_BLOCK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lRyu");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7De um Hadooouken.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.minigun") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.ARROW);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lMiniGun");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Vire uma MiniGun.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.phantom") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.FEATHER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lPhantom");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Vire um passaro.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.alladin") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.CARPET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lAlladin");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Voe com um tapete magico.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.hotpotato") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.POTATO);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lHotPotato");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Brinque de HotPotato, com seus inimigos.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.flash") || IniciarCommand.fullkit) {
            final ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName("§d§lFlash");
            final ArrayList<String> descpyro = new ArrayList<String>();
            descpyro.add("§7  ");
            descpyro.add("§8➸ §d§lINFO");
            descpyro.add("§7Chegue nos lugares muito rapido.");
            metapyro.setLore((List<String>)descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        
        for (int descpyro2 = (inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("kits")) {
            final Player p = (Player)sender;
            guiKits1(p);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dKITS§8] §7(Pag. 2).") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8[§dKITS§8] §7(Pag. 1).")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuKits.GuiKit(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getType() == Material.REDSTONE) {
                e.setCancelled(true);
                p.closeInventory();
                MenuWarps.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMadman")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit madman");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lHotPotato")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit hotpotato");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lFlash")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit flash");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMiniGun")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit minigun");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lAlladin")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit alladin");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lRyu")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit ryu");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lPhantom")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit phantom");
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lSpecialist")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kit specialist");
                return;
            }
        }
    }
}
