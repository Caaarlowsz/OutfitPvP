package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class SCCommand implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce precisa ser um player!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (!(p.hasPermission("zey.pvp.sc"))) {
				p.sendMessage(OutfitPvP.prefix + " §8➸ §cVoce nao tem permissao!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(OutfitPvP.prefix + " §8➸ §cUse: /sc [mensagem]");
				return true;
			} else {
				String message = "";
				for (int i = 0; i < args.length; i++) {
					if (i == args.length - 1) {
						message = message + args[i];
					} else {
						message = message + args[i] + " ";
					}
				}
				for (Player s : Bukkit.getOnlinePlayers()) {
					if (s.hasPermission("zey.pvp.sc")) {
						s.sendMessage("§8[§d§lSCHAT§8] " + p.getDisplayName() + " §d➸ §f" + message.replace("&", "§"));
					}
				}
			}
		}
		return false;
	}
}