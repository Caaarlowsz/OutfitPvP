package Outfit.PvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Outfit.PvP.Score.SPlayer;

public class ChatForm implements Listener {
	@EventHandler
	public void modificarchat(AsyncPlayerChatEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.hasPermission("zey.pvp.falarcolorido")) {
			evento.setFormat(SPlayer.RankC(jogador) + SPlayer.MarcaC(jogador) + SPlayer.ClanC(jogador) + " "
					+ jogador.getDisplayName() + " §8➸§f "
					+ evento.getMessage().replace("&", "§").replace("%", ".".replace("<3", "§4❤§f")));
		} else {
			evento.setFormat(SPlayer.RankC(jogador) + SPlayer.MarcaC(jogador) + SPlayer.ClanC(jogador) + " "
					+ jogador.getDisplayName() + " §8➸§f " + evento.getMessage().replace("%", "."));
		}

		if (jogador.hasPermission("zey.pvp.falarcoloridostaff")) {
			evento.setFormat(SPlayer.RankC(jogador) + SPlayer.MarcaC(jogador) + SPlayer.ClanC(jogador) + " "
					+ jogador.getDisplayName() + " §8➸§f "
					+ evento.getMessage().replace("&", "§").replace("%", ".").replace("<3", "§4❤§f"));
		}

	}
}
