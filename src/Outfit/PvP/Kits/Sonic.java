package Outfit.PvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Main.Main;

public class Sonic implements Listener {
	public int boost;
	public static ArrayList<String> Sonic;
	public static HashMap<String, ItemStack[]> Armadura;
	public static Main plugin;
	public static HashMap<String, ItemStack[]> saveinv;
	public static HashMap<String, ItemStack[]> armadura;
	public static HashMap<String, ItemStack[]> Armadura2;
	public static List<Player> cooldownm;

	static {
		Outfit.PvP.Kits.Sonic.Sonic = new ArrayList<String>();
		Outfit.PvP.Kits.Sonic.Armadura = new HashMap<String, ItemStack[]>();
		Outfit.PvP.Kits.Sonic.saveinv = new HashMap<String, ItemStack[]>();
		Outfit.PvP.Kits.Sonic.armadura = new HashMap<String, ItemStack[]>();
		Outfit.PvP.Kits.Sonic.Armadura2 = new HashMap<String, ItemStack[]>();
		Outfit.PvP.Kits.Sonic.cooldownm = new ArrayList<Player>();
	}

	public Sonic(final Main main) {
		this.boost = Integer.valueOf(6);
	}

	@EventHandler
	public void SonicLick(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK
				&& KitAPI.Sonic.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Outfit.PvP.Kits.Sonic.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cAguarde o cooldown terminar.");
				return;
			}
			Outfit.PvP.Kits.Sonic.cooldownm.add(p);
			p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
			p.getLocation();
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					((Player) pertos).damage(10.0);
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					((Player) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 105));
				}
			}
			final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
			final LeatherArmorMeta kCapacete = (LeatherArmorMeta) Capacete.getItemMeta();
			kCapacete.setColor(Color.BLUE);
			Capacete.setItemMeta((ItemMeta) kCapacete);
			final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
			final LeatherArmorMeta kPeitoral = (LeatherArmorMeta) Peitoral.getItemMeta();
			kPeitoral.setColor(Color.BLUE);
			Peitoral.setItemMeta((ItemMeta) kPeitoral);
			final ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
			final LeatherArmorMeta kCalss = (LeatherArmorMeta) Calss.getItemMeta();
			kCalss.setColor(Color.BLUE);
			Calss.setItemMeta((ItemMeta) kCalss);
			final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
			final LeatherArmorMeta kBota = (LeatherArmorMeta) Capacete.getItemMeta();
			kBota.setColor(Color.BLUE);
			Bota.setItemMeta((ItemMeta) kBota);
			Outfit.PvP.Kits.Sonic.Armadura.put(p.getName(), p.getInventory().getArmorContents());
			p.getInventory().setHelmet(Capacete);
			p.getInventory().setChestplate(Peitoral);
			p.getInventory().setLeggings(Calss);
			p.getInventory().setBoots(Bota);
			p.updateInventory();
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.updateInventory();
				}
			}, 50L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@SuppressWarnings("unlikely-arg-type")
				@Override
				public void run() {
					Outfit.PvP.Kits.Sonic.cooldownm.remove(p);
					Outfit.PvP.Kits.Sonic.Sonic.remove(p);
					KitUtil.ccooldown(p);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 700L);
		}
	}
}
