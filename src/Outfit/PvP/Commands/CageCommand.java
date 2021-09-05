package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class CageCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao e um jogador.");
			return true;
		} else {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("cage") && player.hasPermission("zey.pvp.cage")) {
				if (args.length == 0) {
					player.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §cErrado, utilize a sintaxe correta: /cage [Jogador(a)]");
					return true;
				}

				if (args.length == 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					if (target != null) {
						this.cagePlayer(target);
						player.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você prendeu o jogador(a): §e"
								+ target.getName());
					} else {
						player.sendMessage(
								String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
					}
				}
			}

			return false;
		}
	}

	public void cagePlayer(Player target) {
		target.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		target.teleport(target.getLocation().add(0.0D, 11.0D, -0.05D));
	}
}
