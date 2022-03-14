package Outfit.PvP.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Phantom implements Listener {

	public static HashMap<Player, ItemStack[]> salvarArmadura = new HashMap<Player, ItemStack[]>();

	@EventHandler
	public void onTntLaunch(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Phantom") && (p.getItemInHand().getType() == Material.FEATHER)) {
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				e.setCancelled(true);
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}

				salvarArmadura.put(p, p.getInventory().getArmorContents());

				p.getInventory().setArmorContents(null);
				ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta kPeito = (LeatherArmorMeta) Peito.getItemMeta();
				kPeito.setDisplayName("§f§lPhantom");
				kPeito.setColor(Color.WHITE);
				Peito.setItemMeta(kPeito);

				ItemStack Calça = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta kCaça = (LeatherArmorMeta) Calça.getItemMeta();
				kCaça.setDisplayName("§f§lPhantom");
				kCaça.setColor(Color.WHITE);
				Calça.setItemMeta(kCaça);

				ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta kBota = (LeatherArmorMeta) Bota.getItemMeta();
				kBota.setDisplayName("§f§lPhantom");
				kBota.setColor(Color.WHITE);
				Bota.setItemMeta(kBota);

				ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta kCasapete = (LeatherArmorMeta) Capacete.getItemMeta();
				kCasapete.setDisplayName("§f§lPhantom");
				kCasapete.setColor(Color.WHITE);
				Capacete.setItemMeta(kCasapete);

				p.getInventory().setChestplate(Peito);
				p.getInventory().setLeggings(Calça);
				p.getInventory().setHelmet(Capacete);
				p.getInventory().setBoots(Bota);
				p.updateInventory();

				p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê pode voar por 5 segundos!");
				Cooldown.add(p, 25);

				p.setAllowFlight(true);
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
					public void run() {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cO seu modo pássaro acabou!");
						p.getInventory().setArmorContents(null);

						p.closeInventory();
						p.getInventory().remove(Material.LEATHER_BOOTS);
						p.getInventory().remove(Material.LEATHER_CHESTPLATE);
						p.getInventory().remove(Material.LEATHER_HELMET);
						p.getInventory().remove(Material.LEATHER_LEGGINGS);
						p.updateInventory();

						p.getInventory().setArmorContents(salvarArmadura.get(p));
						p.setAllowFlight(false);
					}
				}, 5 * 20);
			}
		}
	}
}