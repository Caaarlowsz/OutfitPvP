package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class MarcaCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("marca")) {
			if (args.length == 0) {
				p.sendMessage(" ");
				p.sendMessage(
						String.valueOf(Main.prefix) + " §8➸ §fAqui estão há lista de todas as Marcas, do servidor:");
				p.sendMessage("                              ");
				p.sendMessage("§8[§d$512000 §f- §d$1000000§8] §aGUCCI");
				p.sendMessage("§8[§d$256000 §f- §d$512000§8] §bROLEX");
				p.sendMessage("§8[§d$128000 §f- §d$256000§8] §6L-VUITTON");
				p.sendMessage("§8[§d$64000 §f- §d$128000§8] §2LACOSTE");
				p.sendMessage("§8[§d$32000 §f- §d$64000§8] §4SUPREME");
				p.sendMessage("§8[§d$16000 §f- §d$32000§8] §eOFFWHITE");
				p.sendMessage("§8[§d$8000 §f- §d$16000§8] §5BAPE");
				p.sendMessage("§8[§d$4000 §f- §d$8000§8] §9NIKE");
				p.sendMessage("§8[§d$2000 §f- §d$4000§8] §dADIDAS");
				p.sendMessage("§8[§d$1000 §f- §d$2000§8] §3CAMELO");
				p.sendMessage("§8[§d$0 §f- §d$1000§8] §7Mendigo");
				p.sendMessage("                              ");
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §fVocê pode adquirir estas Marcas, matando jogadores. Apos matar os jogadores você ganhara uns dolls, e com esse dolls você ira upar, voce poder apostar para ganhar mais dolls! Boa sorte.");
				p.sendMessage(" ");
			}
		}
		return false;
	}
}
