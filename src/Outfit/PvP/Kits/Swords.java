package Outfit.PvP.Kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import Outfit.PvP.Eventos.Habilidade;

public class Swords implements Listener {
	@EventHandler
	public void SwordKit(final PlayerInteractEvent e) {
		final Player player = e.getPlayer();
		if (Habilidade.getAbility(player) == "Swords" && (player.getItemInHand().getType() == Material.WOOD_SWORD
				|| player.getItemInHand().getType() == Material.GOLD_SWORD
				|| player.getItemInHand().getType() == Material.STONE_SWORD
				|| player.getItemInHand().getType() == Material.IRON_SWORD)) {
			player.updateInventory();
			final Random sword = new Random();
			final int Swordds = sword.nextInt(5);
			switch (Swordds) {
			case 0: {
				player.getItemInHand().setType(Material.GOLD_SWORD);
				player.updateInventory();
				break;
			}
			case 1: {
				player.getItemInHand().setType(Material.WOOD_SWORD);
				player.updateInventory();
				break;
			}
			case 2: {
				player.getItemInHand().setType(Material.STONE_SWORD);
				player.updateInventory();
				break;
			}
			case 3: {
				player.getItemInHand().setType(Material.IRON_SWORD);
				player.updateInventory();
				break;
			}
			case 5: {
				player.getItemInHand().setType(Material.STONE_SWORD);
				player.updateInventory();
				break;
			}
			}
		}
	}
}
