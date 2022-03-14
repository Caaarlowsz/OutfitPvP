package Outfit.PvP.OneVsOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Speed1v1 implements Listener {
	public static boolean Partida1 = false;
	public static String Nome = "";
	public static List<Player> Iniciou = new ArrayList();
	public static List<Player> NeginhoSegundos = new ArrayList();
	public static HashMap<String, Player> Player2 = new HashMap();
	public static HashMap<String, Player> Player1 = new HashMap();

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().equals(Join1v1.Cinza)
				&& (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
			if (Partida1) {
				p.performCommand("speed1v1 " + Nome);
				Nome = "";
				return;
			}

			if (!Partida1) {
				Nome = p.getName();
				Partida1 = true;
				Iniciou.add(p);
				this.Trocar(p);
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê entrou na fila para o 1v1 rápido.");
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						Speed1v1.NeginhoSegundos.add(p);
					}
				}, 2L);
			}
		}

	}

	public void Trocar(Player p) {
		if (Iniciou.contains(p)) {
			p.getInventory().setItem(5, new ItemStack(Join1v1.Verde1));
			p.updateInventory();
		}

	}

	@EventHandler
	public void onInteract2(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().equals(Join1v1.Verde1) || p.getItemInHand().equals(Join1v1.Verde2)
				|| p.getItemInHand().equals(Join1v1.Verde3)) {
			if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
					&& NeginhoSegundos.contains(p)) {
				Partida1 = false;
				Nome = "";
				Iniciou.remove(p);
				NeginhoSegundos.remove(p);
				p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê saiu da fila de 1v1 rápido.");
				Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
					public void run() {
						p.getInventory().setItem(5, Join1v1.Cinza);
						p.updateInventory();
					}
				}, 1L);
				return;
			}

			if (!NeginhoSegundos.contains(p)) {
				return;
			}
		}

	}
}
