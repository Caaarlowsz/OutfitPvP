package Outfit.PvP.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;

public class C4 implements Listener {
	public static HashMap<String, Item> bomba = new HashMap<String, Item>();

	@EventHandler
	public void aoBotar(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("C4")) {
			ItemStack itemb2;
			ItemMeta itembm2;
			Item item2;
			if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
				if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
						&& p.getItemInHand().getType() == Material.STONE_BUTTON) {
					if (Cooldown.add(p)) {
						KitUtil.MensagemCooldown(p);
						return;
					}

					itemb2 = new ItemStack(Material.SLIME_BALL);
					itembm2 = itemb2.getItemMeta();
					itembm2.setDisplayName("§e§lC4");
					itemb2.setItemMeta(itembm2);
					p.getInventory().setItemInHand(itemb2);
					item2 = (Item) bomba.get(p.getName());
					bomba.remove(p.getName());
					item2.remove();
					p.updateInventory();
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aC4 Desarmada");
				}
			} else if (p.getItemInHand().getType() == Material.SLIME_BALL) {
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}

				Location loc = p.getLocation();
				Vector vec = new Vector(0, 2, 0);
				Location direc = loc.add(vec);
				Item item = p.getWorld().dropItem(direc, new ItemStack(Material.TNT, 1));
				item.setVelocity(p.getEyeLocation().getDirection());
				bomba.put(p.getName(), item);
				ItemStack itemb = new ItemStack(Material.STONE_BUTTON);
				ItemMeta itembm = itemb.getItemMeta();
				itembm.setDisplayName("§e§lC4");
				itemb.setItemMeta(itembm);
				p.getInventory().setItemInHand(itemb);
				p.updateInventory();
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cSua C4 foi implantada");
			} else if (p.getItemInHand().getType() == Material.STONE_BUTTON) {
				itemb2 = new ItemStack(Material.SLIME_BALL);
				itembm2 = itemb2.getItemMeta();
				itembm2.setDisplayName("§e§lC4");
				itemb2.setItemMeta(itembm2);
				p.getInventory().setItemInHand(itemb2);
				item2 = (Item) bomba.get(p.getName());
				p.getWorld().createExplosion(item2.getLocation(), 1.5F);
				item2.getWorld().playEffect(item2.getLocation(), Effect.EXPLOSION_HUGE, 10);
				bomba.remove(p.getName());
				item2.remove();
				p.updateInventory();
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua C4 foi ativada");
				Cooldown.add(p, 20);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
					public void run() {
						KitUtil.ccooldown(p);
					}
				}, 400L);
			}
		}

	}
}
