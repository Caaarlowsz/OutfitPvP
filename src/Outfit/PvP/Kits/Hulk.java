package Outfit.PvP.Kits;

import org.bukkit.event.player.*;

import Outfit.PvP.Essencial.*;
import Outfit.PvP.Eventos.*;
import Outfit.PvP.Main.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    KitUtil.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.SADDLE) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cAguarde o outro jogador(a) sair da sua cabeça.");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Um Hulk lhe predeu Aperde §a§lSHIFT§7 para se soltar.");
            }
        }
    }
}
