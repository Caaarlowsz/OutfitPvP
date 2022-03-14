package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class YTCommand implements CommandExecutor {
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player player = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("youtuber")) {
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage(
					OutfitPvP.prefix + " §8➸ §fRequesitos para tag: §3§lYT+ §f| §b§lYT §f| §6§lPRO§f!");
			player.sendMessage("§7 ");
			player.sendMessage(OutfitPvP.prefix
					+ " §8➸ §3§lYT+§7: Confiança do dono e um feedback bom sendo constante nos vídeos.");
			player.sendMessage("§7 ");
			player.sendMessage(OutfitPvP.prefix + " §8➸ §b§lYT§7: 200 visualizações e 50 likes,");
			player.sendMessage("§7 ");
			player.sendMessage(OutfitPvP.prefix + " §8➸ §6§lPRO§7: §7100 visualizações e 20 likes.");
			player.sendMessage("§7 ");
		}

		return false;
	}
}
