package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class AplicarCommand implements CommandExecutor {
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player player = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("aplicar")) {
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage(
					OutfitPvP.prefix + " §8➸ §aEntre no nosso discord para ver os cargos disponiveis!");
			player.sendMessage("§7 ");
			player.sendMessage(OutfitPvP.prefix + " §8➸ §fDiscord§7: §fhttps://discord.gg/FDFhphW");
			player.sendMessage("§7 ");
		}

		return false;
	}
}
