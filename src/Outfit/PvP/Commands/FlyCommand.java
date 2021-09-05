package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Main.Main;

public class FlyCommand implements CommandExecutor {
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (!(s instanceof Player)) {
			return false;
		} else {
			Player p = (Player) s;
			if (!p.hasPermission("zey.pvp.fly")) {
				p.sendMessage(
						String.valueOf(Main.prefix) + " §8➸ §cVocê precisa ser §1§lBETA §cou superior, para voar.");
				return true;
			} else if (WarpAPI.getWarp(p) == "Arena") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Evento") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Fps") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Potion") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Challenge") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Parkour") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Knockback") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Fisherman") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Void") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (WarpAPI.getWarp(p) == "Main") {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
				return true;
			} else if (args.length == 0) {
				if (p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §7Modo Fly §c§lDESABILITADO §7para o jogador(a): §e" + p.getName());
					return true;
				} else {
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Modo Fly §a§lHABILITADO §7para o jogador(a): §e"
							+ p.getName());
					return true;
				}
			} else if (args.length != 1) {
				s.sendMessage("§8➸ §cErrado, Utilize a sintaxe correta: /fly [Jogador(a)]");
				return true;
			} else if (!p.hasPermission("zey.pvp.fly.others")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cVocê precisa ser §a[FRIEND] §cou superior, para permitir um jogador(a) voar.");
				return true;
			} else {
				Player t = Bukkit.getPlayerExact(args[0]);
				if (t == null) {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline.");
					return true;
				} else if (t.getAllowFlight()) {
					t.setAllowFlight(false);
					t.setFlying(false);
					p.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §7Você §c§lDESABILITOU §7o Fly para o jogador(a): §e" + t.getName());
					t.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Fly §c§lDESABILITADO §7pelo jogador(a): §e"
							+ p.getName());
					return true;
				} else {
					t.setAllowFlight(true);
					t.setFlying(true);
					p.sendMessage(String.valueOf(Main.prefix)
							+ " §8➸ §7Você §a§lHABILITOU §7o modo Fly para o jogador(a): §e" + t.getName());
					t.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Fly §a§lHABILITADO §7pelo jogador(a): §e"
							+ p.getName());
					return true;
				}
			}
		}
	}
}
