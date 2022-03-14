package Outfit.PvP.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class MenuVip implements Listener, CommandExecutor {
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

	public static void guiKits(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 27, "§8[§dLOJA§8]");
		ItemStack fps = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta metafps = fps.getItemMeta();
		metafps.setDisplayName("§a§lVIP NORMAL §7| R$16 (Permanente)");
		ArrayList<String> descfps = new ArrayList<>();
		descfps.add("§7");
		descfps.add("§d»§7 Tag VIP no servidor");
		descfps.add("§d»§7 20 kits liberados");
		descfps.add("§d»§7 Voar no spawn");
		descfps.add("§d»§7 Ganhe 50K de Dolls");
		descfps.add("§d»§7 Entrar com o servidor lotado");
		descfps.add("§d»§7 Pode falar com o chat desativado");
		descfps.add("§d»§7 Troca de skin dentro do servidor");
		descfps.add("§d»§7 Tag VIP no discord");
		descfps.add("§7");
		descfps.add("§dClique aqui para comprar§7!");
		metafps.setLore(descfps);
		fps.setItemMeta(metafps);
		inv.setItem(11, fps);
		ItemStack lava = new ItemStack(Material.INK_SACK, 1, (short) 12);
		ItemMeta metalava = lava.getItemMeta();
		metalava.setDisplayName("§9§lVIP MVP §7| R$28,00 (Permanente)");
		ArrayList<String> desclava = new ArrayList<>();
		desclava.add("§7");
		desclava.add("§d»§7 Tag MVP no servidor");
		desclava.add("§d»§7 30 kits liberados");
		desclava.add("§d»§7 Voar no spawn");
		desclava.add("§d»§7 Personalizacao de personagem no spawn");
		desclava.add("§d»§7 Falar colorido no chat");
		desclava.add("§d»§7 Ganhe 100K de Dolls");
		desclava.add("§d»§7 Entrar com o servidor lotado");
		desclava.add("§d»§7 Pode falar com o chat desativado");
		desclava.add("§d»§7 Troca de skin dentro do servidor");
		desclava.add("§d»§7 Tag MVP no discord");
		desclava.add("§7");
		desclava.add("§dClique aqui para comprar§7!");
		metalava.setLore(desclava);
		lava.setItemMeta(metalava);
		inv.setItem(13, lava);
		ItemStack voidc = new ItemStack(Material.INK_SACK, 1, (short) 13);
		ItemMeta metavoidc = voidc.getItemMeta();
		metavoidc.setDisplayName("§d§lVIP KOMBO §7| R$42,00 (Permanente)");
		ArrayList<String> descvoidc = new ArrayList<>();
		descvoidc.add("§7");
		descvoidc.add("§d»§7 Tag KOMBO no servidor");
		descvoidc.add("§d»§7 Todos os 44 kits liberados");
		descvoidc.add("§d»§7 Voar no spawn");
		descvoidc.add("§d»§7 Personalizacao de personagem no spawn");
		descvoidc.add("§d»§7 Efeitos no personagem dentro do spawn");
		descvoidc.add("§d»§7 Falar colorido no chat");
		descvoidc.add("§d»§7 Ganhe 150K de Dolls");
		descvoidc.add("§d»§7 Entrar com o servidor lotado");
		descvoidc.add("§d»§7 Pode falar com o chat desativado");
		descvoidc.add("§d»§7 Troca de skin dentro do servidor");
		descvoidc.add("§d»§7 Tag exclusiva no discord");
		descvoidc.add("§7");
		descvoidc.add("§dClique aqui para comprar§7!");
		metavoidc.setLore(descvoidc);
		voidc.setItemMeta(metavoidc);
		inv.setItem(15, voidc);
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		ItemMeta vidrox = vidro.getItemMeta();
		vidrox.setDisplayName("§6§lKombo§f§lPvP");
		vidro.setItemMeta(vidrox);
		ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
		ItemMeta vidrom2 = vidro.getItemMeta();
		vidrom2.setDisplayName("§6§lKombo§f§lPvP");
		vidro2.setItemMeta(vidrom2);
		ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
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
		inv.setItem(8, vidro);
		inv.setItem(9, vidro3);
		inv.setItem(10, vidro3);
		inv.setItem(12, vidro3);
		inv.setItem(14, vidro3);
		inv.setItem(16, vidro3);
		inv.setItem(17, vidro3);
		inv.setItem(18, vidro2);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro2);
		inv.setItem(21, vidro);
		inv.setItem(22, vidro2);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro2);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro2);

		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; metapyro2++) {
			@SuppressWarnings("unused")
			ItemStack itemStack = arrayOfItemStack[metapyro2];
		}
		p.openInventory(inv);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("loja")) {
			Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dLOJA§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§a§lVIP NORMAL §7| R$16 (Permanente)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage(
						OutfitPvP.prefix + " §8➸ §7Acesse o link abaixo para comprar §a§lVIP NORMAL§7:");
				p.sendMessage("§dhttps://kombonetwork.buycraft.net");
				p.sendMessage("§7");
				p.sendMessage("§7");
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§9§lVIP MVP §7| R$28,00 (Permanente)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage(OutfitPvP.prefix + " §8➸ §7Acesse o link abaixo para comprar §9§lVIP MVP§7:");
				p.sendMessage("§dhttps://kombonetwork.buycraft.net");
				p.sendMessage("§7");
				p.sendMessage("§7");
				return;
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§d§lVIP KOMBO §7| R$42,00 (Permanente)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage("§7");
				p.sendMessage(
						OutfitPvP.prefix + " §8➸ §7Acesse o link abaixo para comprar §d§lVIP KOMBO§7:");
				p.sendMessage("§dhttps://kombonetwork.buycraft.net");
				p.sendMessage("§7");
				p.sendMessage("§7");
				return;
			}
		}

	}
}
