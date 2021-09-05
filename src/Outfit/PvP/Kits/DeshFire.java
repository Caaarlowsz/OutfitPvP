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
import org.bukkit.util.Vector;

import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Main.Main;

public class DeshFire implements Listener {
	public int boost;
	public static ArrayList<String> Deshfire;
	public static HashMap<String, ItemStack[]> Armadura;
	public static HashMap<String, ItemStack[]> saveinv;
	public static HashMap<String, ItemStack[]> armadura;
	public static HashMap<String, ItemStack[]> Armadura2;
	public static List<Player> cooldownm;

	static {
		DeshFire.Deshfire = new ArrayList<String>();
		DeshFire.Armadura = new HashMap<String, ItemStack[]>();
		DeshFire.saveinv = new HashMap<String, ItemStack[]>();
		DeshFire.armadura = new HashMap<String, ItemStack[]>();
		DeshFire.Armadura2 = new HashMap<String, ItemStack[]>();
		DeshFire.cooldownm = new ArrayList<Player>();
	}

	public DeshFire(final Main main) {
		this.boost = Integer.valueOf(6);
	}

	@EventHandler
	public void DeshClick(final PlayerInteractEvent event) {
		final int fire = Integer.valueOf(6);
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK
				&& KitAPI.DeshFire.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (DeshFire.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cAguarde o cooldown terminar.");
				return;
			}
			DeshFire.cooldownm.add(p);
			p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
			p.getLocation();
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					((Player) pertos).damage(10.0);
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					((Player) pertos).setFireTicks(fire * 20);
				}
			}
			final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
			final LeatherArmorMeta kCapacete = (LeatherArmorMeta) Capacete.getItemMeta();
			kCapacete.setColor(Color.RED);
			Capacete.setItemMeta((ItemMeta) kCapacete);
			final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
			final LeatherArmorMeta kPeitoral = (LeatherArmorMeta) Peitoral.getItemMeta();
			kPeitoral.setColor(Color.RED);
			Peitoral.setItemMeta((ItemMeta) kPeitoral);
			final ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
			final LeatherArmorMeta kCalss = (LeatherArmorMeta) Calss.getItemMeta();
			kCalss.setColor(Color.RED);
			Calss.setItemMeta((ItemMeta) kCalss);
			final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
			final LeatherArmorMeta kBota = (LeatherArmorMeta) Capacete.getItemMeta();
			kBota.setColor(Color.RED);
			Bota.setItemMeta((ItemMeta) kBota);
			DeshFire.Armadura.put(p.getName(), p.getInventory().getArmorContents());
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
					DeshFire.cooldownm.remove(p);
					DeshFire.Deshfire.remove(p);
					KitUtil.ccooldown(p);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 700L);
		}
	}
}
