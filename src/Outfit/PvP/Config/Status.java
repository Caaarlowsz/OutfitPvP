package Outfit.PvP.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class Status implements Listener {
	@EventHandler
	void aoLogar(PlayerJoinEvent evento) {
		/* 17 */ Player jogador = evento.getPlayer();
		/* 18 */ if (OutfitPvP.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			/* 20 */ OutfitPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills",
					Integer.valueOf(0));
			/* 21 */ OutfitPvP.plugin.saveConfig();
		}
		/* 23 */ if (OutfitPvP.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			/* 25 */ OutfitPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes",
					Integer.valueOf(0));
			/* 26 */ OutfitPvP.plugin.saveConfig();
		}
		/* 23 */ if (OutfitPvP.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".ks") == null) {
			/* 25 */ OutfitPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".ks",
					Integer.valueOf(0));
			/* 26 */ OutfitPvP.plugin.saveConfig();
		}
	}

	@EventHandler
	void aoMatar(PlayerDeathEvent evento) {
		/* 33 */ if ((evento.getEntity().getKiller() instanceof Player)) {
			/* 35 */ Player jogador = evento.getEntity().getKiller();

			/* 37 */ int kills = OutfitPvP.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
			int ks = OutfitPvP.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".ks");
			/* 38 */ OutfitPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills",
					Integer.valueOf(kills + 1));
			OutfitPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".ks", Integer.valueOf(ks + 1));
			/* 39 */ OutfitPvP.plugin.saveConfig();
		}
	}

	/* 56 */ public static int getKills(Player p) {
		return OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
	}

	/* 56 */ public static int getDeaths(Player p) {
		return OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
	}

	/* 56 */ public static int getKs(Player p) {
		return OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".ks");
	}

}
