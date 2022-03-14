package Outfit.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Outfit.PvP.Essencial.Cooldown;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Hulk implements Listener {
	@EventHandler
	public void PickUpPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
				final Player r = (Player) e.getRightClicked();
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}
				if (p.getItemInHand().getType() != Material.SADDLE) {
					return;
				}
				if (p.getPassenger() != null) {
					p.sendMessage(
                            OutfitPvP.prefix + " §8➸ §cAguarde o outro jogador(a) sair da sua cabeça.");
					return;
				}
				if (r.getPassenger() != null) {
					return;
				}
				Cooldown.add(p, 6);
				p.setPassenger(r);
				r.sendMessage(
                        OutfitPvP.prefix + " §8➸ §7Um Hulk lhe predeu Aperde §a§lSHIFT§7 para se soltar.");
			}
		}
	}
}
