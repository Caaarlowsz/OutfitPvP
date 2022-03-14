package Outfit.PvP.Menus;

import java.util.ArrayList;
import java.util.List;

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
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Outfit.PvP.Commands.IniciarCommand;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class MenuKits implements Listener, CommandExecutor {
	public MenuKits(final OutfitPvP main) {
	}

	public static void GuiKit(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory(p, 54, "§8[§dKITS§8]");

		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§6§lKombo§f§lPvP");
		vidro.setItemMeta(vidrom);

		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
		final ItemMeta vidrom2 = vidro.getItemMeta();
		vidrom2.setDisplayName("§6§lKombo§f§lPvP");
		vidro2.setItemMeta(vidrom);

		final ItemStack exit = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta exitx = exit.getItemMeta();
		exitx.setDisplayName("§c§lVOLTAR");
		exit.setItemMeta(exitx);

		final ItemStack warps = new ItemStack(Material.REDSTONE);
		final ItemMeta warpsx = exit.getItemMeta();
		warpsx.setDisplayName("§d§lWARPS");
		warps.setItemMeta(warpsx);

		final ItemStack page2 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		final ItemMeta page2x = page2.getItemMeta();
		page2x.setDisplayName("§8[§dKITS§8] §7(Pag. 2).");
		page2.setItemMeta(page2x);

		inv.setItem(0, vidro);
		inv.setItem(1, vidro2);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro2);
		inv.setItem(3, vidro2);
		inv.setItem(4, warps);
		inv.setItem(5, vidro2);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro2);
		inv.setItem(8, page2);
		inv.setItem(45, vidro2);
		inv.setItem(46, vidro);
		inv.setItem(47, vidro2);
		inv.setItem(48, vidro);
		inv.setItem(49, vidro2);
		inv.setItem(50, vidro);
		inv.setItem(51, vidro2);
		inv.setItem(52, vidro);
		inv.setItem(53, vidro2);

		{
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lPvP");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Kit sem habilidades.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.ajnin") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lAjnin");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Teleporte o ultimo");
			descpyro.add("§7jogador hitado para você.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.archer") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.BOW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lArcher");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Ganhe um Arco");
			descpyro.add("§7e muitas flechas.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.armor") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.GOLD_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lArmor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Ganhe uma armadura");
			descpyro.add("§7de ouro temporaria.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.avatar") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.BEACON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lAvatar");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Transforme-se um `Avatar'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.c4") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lC4");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Plante C4s e");
			descpyro.add("§7exploda jogadores.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.deshfire") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lDeshFire");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Dê um `Desh' pra frente e");
			descpyro.add("§7ponha fogo nos jogadores.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.fisherman") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lFisherman");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Pesque os jogadores.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.kangaroo") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lKangaroo");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Vire um kanguru");
			descpyro.add("§7e dê `Double Jumps'");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.magma") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.FIREBALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lMagma");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Tenha 30% de chances");
			descpyro.add("§7de colocar fogo no jogador `hitado'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.monk") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lMonk");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Troque a espada");
			descpyro.add("§7do inimigo de lugar.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.ninja") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.COMPASS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lNinja");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Teleporte par o ultimo");
			descpyro.add("§7jogador `hitado'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.gladiator") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lGladiator");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Puxe um jogador(a)");
			descpyro.add("§7para uma luta 1v1 justa nos `ares'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.poseidon") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lPoseidon");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Seja o deus");
			descpyro.add("§7das águas.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.resouper") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lResouper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Recarregue suas sopas");
			descpyro.add("§7ao matar um jogador(a).");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.snail") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.WEB);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lSnail");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Tenha 30% de chance");
			descpyro.add("§7de dar lentidão no jogador `hitado'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.sonic") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lSonic");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Dê um `Desh' pra frente");
			descpyro.add("§7E deixe seus inimigos lentos.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.stomper") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lStomper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Transfira seu dano de queda");
			descpyro.add("§7para inimigos proximos.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.switcher") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lSwitcher");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Acerte bolinha nos jogadores");
			descpyro.add("§7e troque de lugar com eles.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.swords") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lSwords");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7`Troque' de espada");
			descpyro.add("§7com apenas um clique.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.forcefield") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lForceField");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Tenha há mesma habilidade");
			descpyro.add("§7que o hack forcefield.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.thor") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.GOLD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lThor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Tenha um martelo que");
			descpyro.add("§7solta raio ao clicar.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.thresh") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.LEVER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lThresh");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Acerte sua corda");
			descpyro.add("§7em algum jogador(a) e seja teleportado");
			descpyro.add("§7para o mesmo.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.grappler") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.LEASH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lGrappler");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7`Puxe' seu corpo com uma corda.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.jellyfish") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.CLAY_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lJellyfish");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Coloque uma água venenosa");
			descpyro.add("§7em seus inimigos.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.quickdropper") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.BOWL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lQuickdropper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Toda vez que você tomar sopa");
			descpyro.add("§7os potes serão dropados automaticamente.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.hulk") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.SADDLE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lHulk");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Coloque jogadores em");
			descpyro.add("§7cima da sua cabeça.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.anchor") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.ANVIL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lAnchor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Não `tome' nem dê");
			descpyro.add("§7knockBack.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.turtle") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_HELMET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lTurtle");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Não receba dano");
			descpyro.add("§7enquanto estiver de `SHIFT'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.viking") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.STONE_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lViking");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7De mais dano, com seu machado.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.camel") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.SAND);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lCamel");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Ganhe `poderes' no deserto.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.viper") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lViper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Tenha 30% de chance");
			descpyro.add("§7de dar veneno no jogador `hitado'.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.timelord") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.WATCH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lTimeLord");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Congele seus inimigos usando o tempo.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.rain") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.ARROW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lRain");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Seja um deus");
			descpyro.add("§7das flechadas.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.confuser") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.COAL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lConfuser");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Deixe seus inimigos");
			descpyro.add("§7confusos.");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("kit.antitower") || IniciarCommand.fullkit) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§d§lAntiTower");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7  ");
			descpyro.add("§8➸ §d§lINFO");
			descpyro.add("§7Não morra para o kit Stomper");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		for (int descpyro2 = (inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits")) {
			final Player p = (Player) sender;
			GuiKit(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8[§dKITS§8]") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lAntiTower")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit antitower");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8[§dKITS§8] §7(Pag. 2).")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuKits2.guiKits1(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}

			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit forcefield");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit armor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEVER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thresh");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit avatar");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuGeral.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit swords");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit terrorista");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit c4");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit archer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit jellyfish");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit magma");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sonic");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit quickdropper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SAND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit camel");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COAL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit confuser");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit timelord");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit rain");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				e.setCancelled(true);
				p.closeInventory();
				MenuWarps.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
		}
	}
}
