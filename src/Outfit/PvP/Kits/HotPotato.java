package Outfit.PvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class HotPotato implements Listener {
	public static ArrayList<String> emhotpotato;

	static {
		HotPotato.emhotpotato = new ArrayList<String>();
	}

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onInteract(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player k = (Player) e.getRightClicked();
			if (p.getItemInHand().getType().equals(Material.POTATO)
					&& Habilidade.getAbility(p).equalsIgnoreCase("HotPotato")) {
				if (Gladiator.lutando.containsKey(p.getName())) {
				} else {
					if (Cooldown.add(p)) {
						KitUtil.MensagemCooldown(p);
						return;
					}
					Cooldown.add(p, 20);
					HotPotato.emhotpotato.add(k.getName());
					p.sendMessage(OutfitPvP.prefix + " §8➸ §aHotPotato Colocada");
					k.sendMessage(OutfitPvP.prefix
							+ " §8➸ §eVocê está com a tnt do hotpotato tire ou ira explodir em 5 segundos!");
					k.sendMessage(OutfitPvP.prefix
							+ " §8➸ §cClique com o botao direito na hotpotato para tira-la.");

					final ItemStack tnt = new ItemStack(Material.TNT);
					final ItemMeta tntmeta = tnt.getItemMeta();
					tntmeta.setDisplayName("§cTNT");
					tnt.setItemMeta(tntmeta);

					k.getInventory().setHelmet(tnt);

					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(OutfitPvP.prefix
										+ " §8➸ §eVocê está com a tnt, ela será explodida em 4 segundos");
							}
						}
					}.runTaskLater(OutfitPvP.getInstance1(), 0L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(OutfitPvP.prefix
										+ " §8➸ §eVocê está com a tnt, ela será explodida em 3 segundos");
							}
						}
					}.runTaskLater(OutfitPvP.getInstance1(), 20L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(OutfitPvP.prefix
										+ " §8➸ §eVocê está com a tnt, ela será explodida em 2 segundos");
							}
						}
					}.runTaskLater(OutfitPvP.getInstance1(), 40L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(OutfitPvP.prefix
										+ " §8➸ §e§lVocê está com a tnt, ela será explodida em 1 segundo");
							}
						}
					}.runTaskLater(OutfitPvP.getInstance1(), 60L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
								k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
								k.setLastDamage(9999.0);
								HotPotato.emhotpotato.remove(k.getName());
							}
						}
					}.runTaskLater(OutfitPvP.getInstance1(), 80L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
						@Override
						public void run() {
							KitUtil.ccooldown(p);
						}
					}, 500L);
				}
			}
		}
	}

	@EventHandler
	public void onRemoverTNT(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (Habilidade.getAbility(p) != "Nenhum" && e.getSlot() == 39
				&& e.getCurrentItem().getType().equals(Material.TNT)
				&& HotPotato.emhotpotato.contains(p.getName())) {
			HotPotato.emhotpotato.remove(p.getName());
			e.setCancelled(true);
			p.getInventory().setHelmet(null);
			p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê desarmou a hotpotato.");
			p.closeInventory();
		}
	}
}
