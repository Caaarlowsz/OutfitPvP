package Outfit.PvP.DollsDay;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class XpDiario2 {
	public XpDiario2() {
		(new BukkitRunnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				int hora = calendar1.get(11);
				int minutos = calendar1.get(12);
				int segundos = calendar1.get(13);
				if (hora == 0 && minutos == 0 && segundos == 0) {
					Bukkit.broadcastMessage(
                            OutfitPvP.prefix + "§dDollsDiario §7Todos os Dolls diarios foram resetados!");
				}

			}
		}).runTaskTimer(OutfitPvP.instance, 0L, 20L);
	}
}
