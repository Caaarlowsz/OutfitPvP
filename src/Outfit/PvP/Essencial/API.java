package Outfit.PvP.Essencial;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.Main.Main;

public class API {
	public static ItemStack capacete;
	public static ItemMeta capacetemeta;
	public static ItemStack peitoral;
	public static ItemMeta peitoralmeta;
	public static ItemStack cal\u00e7a;
	public static ItemMeta cal\u00e7ameta;
	public static ItemStack bota;
	public static ItemMeta botameta;
	public static ItemStack sopa;
	public static ItemMeta sopameta;

	public static void BroadCast(final String msg) {
		Bukkit.getServer().broadcastMessage(msg);
	}

	public static void Msg(final Player p, final String msg) {
		p.sendMessage(msg);
	}

	public static void darItemInv(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final int lugar) {

		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);

	}

	public static ItemStack Item(final Material material, final int quantidade, final int id, final String nome) {

		final ItemStack item = new ItemStack(material, quantidade, (short) (byte) id);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(nome);
		item.setItemMeta(meta);
		return item;

	}

	public static void CriarItem(final Player p, final Material material, final int quantidade, final byte id,
			final String nome, final Enchantment ench, final int level, final boolean trueoufalse, final int lugar) {

		final ItemStack item = new ItemStack(material, quantidade, (short) id);
		final ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		itemm.addEnchant(ench, level, trueoufalse);
		item.setItemMeta(itemm);
		p.getInventory().setItem(lugar, item);

	}

	public static void DarSopa(final Player p) {
		API.sopa = new ItemStack(Material.MUSHROOM_SOUP);
		(API.sopameta = API.sopa.getItemMeta()).setDisplayName("§dSopa");
		API.sopa.setItemMeta(API.sopameta);
		for (int i = 1; i < 37; ++i) {
			p.getInventory().addItem(new ItemStack[] { API.sopa });
		}
		CriarItem(p, Material.RED_MUSHROOM, 64, (byte) 0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 13);
		CriarItem(p, Material.BROWN_MUSHROOM, 64, (byte) 0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 15);
		CriarItem(p, Material.BOWL, 64, (byte) 0, "§6Recraft", Enchantment.ARROW_DAMAGE, 0, false, 14);
	}

	public static void ClearPlayer(final Player p) {

		p.setHealth(20.0);
		p.setFoodLevel(20);
		p.getInventory().clear();
		p.getInventory().setArmorContents((ItemStack[]) null);
		for (final PotionEffect potion : p.getActivePotionEffects()) {
			p.removePotionEffect(potion.getType());

		}
	}

	public static void Som(final Player p, final Sound som, final float volume) {
		p.playSound(p.getLocation(), som, volume, volume);
	}

	public static void spawnFirework(final Location loc) {
		final Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		final FireworkMeta fwm = fw.getFireworkMeta();
		final Random r = new Random();
		final int rt = r.nextInt(4) + 1;
		FireworkEffect.Type type = FireworkEffect.Type.BALL;
		if (rt == 1) {
			type = FireworkEffect.Type.BALL;
		}
		if (rt == 2) {
			type = FireworkEffect.Type.BALL_LARGE;
		}
		if (rt == 3) {
			type = FireworkEffect.Type.BURST;
		}
		if (rt == 4) {
			type = FireworkEffect.Type.CREEPER;
		}
		if (rt == 5) {
			type = FireworkEffect.Type.STAR;
		}
		final Color c1 = Color.WHITE;
		final Color c2 = Color.PURPLE;
		final Color c3 = Color.GRAY;
		final FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2)
				.withFade(c3).with(type).trail(r.nextBoolean()).build();
		fwm.addEffect(effect);
		fwm.setPower(1);
		fw.setFireworkMeta(fwm);
	}

	public static void darArmor(final Player p) {

		API.capacete = new ItemStack(Material.IRON_HELMET);
		API.capacetemeta = API.capacete.getItemMeta();
		API.capacete.setItemMeta(API.capacetemeta);

		API.peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
		API.peitoralmeta = API.peitoral.getItemMeta();
		API.peitoral.setItemMeta(API.peitoralmeta);

		API.cal\u00e7a = new ItemStack(Material.IRON_LEGGINGS);
		API.cal\u00e7ameta = API.cal\u00e7a.getItemMeta();
		API.cal\u00e7a.setItemMeta(API.cal\u00e7ameta);

		API.bota = new ItemStack(Material.IRON_BOOTS);
		API.botameta = API.bota.getItemMeta();
		API.bota.setItemMeta(API.botameta);

		p.getInventory().setHelmet(API.capacete);
		p.getInventory().setChestplate(API.peitoral);
		p.getInventory().setLeggings(API.cal\u00e7a);
		p.getInventory().setBoots(API.bota);
	}

	public static String getShortStr(final String name) {
		if (name.length() >= 16) {
			final String shorts = name.substring(0, 13);
			return shorts;
		}
		if (name.length() >= 15) {
			final String shorts = name.substring(0, 13);
			return shorts;
		}
		return name;
	}

	public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
	}

	public static void firstEmpty(final Inventory inv, final ItemStack item) {
		for (final ItemStack item2 : inv.getContents()) {
			if (item2 == null) {
				inv.setItem(inv.firstEmpty(), item);
			}
		}
	}

	public static ItemStack itemStack(final Material material, final String nome) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static void AutomaticMessage() {

		Random random = new Random();
		switch (random.nextInt(8)) {
		case 1:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7O servidor está em fase §d§lBETA§7. Caso você encontre algum §d§lERRO§7, reporte em nosso Discord!");
			Bukkit.broadcastMessage(" ");
			break;
		case 2:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(Main.prefix) + " §8➸ §7Para fazer uma denúncia, use: §d/report (nick) (motivo)§7.");
			Bukkit.broadcastMessage(" ");
			break;
		case 3:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7Entre no nosso §d§lDISCORD §7e fique por dentro de nossas novidades! §8[§dhttps://discord.gg/FDFhphW]");
			Bukkit.broadcastMessage(" ");
			break;
		case 4:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7Deseja tag §b§lYT §7digite §d/youtuber §7para saber os requisitos.");
			Bukkit.broadcastMessage(" ");
			break;
		case 5:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7Há algum interesse em integrar à nossa §d§lSTAFF§7, §7utilize §d/aplicar§7.");
			Bukkit.broadcastMessage(" ");
			break;
		case 6:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7Fique atento as §d§lREGRAS§7 e evite ser banido do servidor, §7utilize §d/regras§7.");
			Bukkit.broadcastMessage(" ");
			break;
		case 7:
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(Main.prefix)
					+ " §8➸ §7Quer saber seu status? use o comando §d/status §7para saber seu status!");
			Bukkit.broadcastMessage(" ");
			break;
		case 8:
			Bukkit.broadcastMessage(" ");
			break;
		}
	}

	public static void fillLinhaInventory(final Inventory inv, final int fristSlot, final ItemStack slot1,
			final ItemStack slot2, final ItemStack slot3, final ItemStack slot4, final ItemStack slot5,
			final ItemStack slot6, final ItemStack slot7, final ItemStack slot8, final ItemStack slot9) {
		inv.setItem(fristSlot, slot1);
		inv.setItem(fristSlot + 1, slot2);
		inv.setItem(fristSlot + 2, slot3);
		inv.setItem(fristSlot + 3, slot4);
		inv.setItem(fristSlot + 4, slot5);
		inv.setItem(fristSlot + 5, slot6);
		inv.setItem(fristSlot + 6, slot7);
		inv.setItem(fristSlot + 7, slot8);
		inv.setItem(fristSlot + 8, slot9);
	}
}
