package Outfit.PvP.OneVsOne;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Join1v1 implements Listener {

	private static final Itens Item = new Itens();

	public static ItemStack Item_ = Item.createItem(Material.BLAZE_ROD, "BLAZE_ROD",
			"§dDesafie um jogador! §7(botão direito)", new String[0], 1, (short) 0);
	public static ItemStack Cinza = Item.createItem(Material.INK_SACK, "INK_SACK", "§dDuelo rápido! §7(botão direito)",
			new String[0], 1, (short) 8);
	public static ItemStack Verde1 = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando partidas",
			new String[0], 1, (short) 10);
	public static ItemStack Verde2 = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando partidas",
			new String[0], 1, (short) 10);
	public static ItemStack Verde3 = Item.createItem(Material.INK_SACK, "INK_SACK", "§dProcurando partidas",
			new String[0], 1, (short) 10);

}
