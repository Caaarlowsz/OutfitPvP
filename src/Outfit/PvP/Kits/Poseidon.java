package Outfit.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;

public class Poseidon implements Listener {
	@EventHandler
	public void aoPoseidon(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		final Block b = p.getLocation().getBlock();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Poseidon")
				&& (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
			KitUtil.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
			KitUtil.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
			KitUtil.darEfeito(p, PotionEffectType.SPEED, 8, 0);
		}
	}
}
