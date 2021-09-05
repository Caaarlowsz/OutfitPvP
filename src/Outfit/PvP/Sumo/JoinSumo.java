package Outfit.PvP.Sumo;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class JoinSumo
  implements Listener
{
  private static Itens Item = new Itens();
  public static ItemStack ItemS_ = Item.createItem(Material.BLAZE_ROD, "BLAZE_ROD", "§dDesafiar", new String[0], 1, (short)0);
  public static ItemStack CinzaS = Item.createItem(Material.INK_SACK, "INK_SACK", "§dDuelo rápido", new String[0], 1, (short)8);
  public static ItemStack Verde1S = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando oponente", new String[0], 1, (short)10);
  public static ItemStack Verde2S = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando oponente", new String[0], 1, (short)10);
  public static ItemStack Verde3S = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando oponente", new String[0], 1, (short)10);
}
