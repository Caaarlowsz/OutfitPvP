package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;

public class SetGroupCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setgroup")) {
			if (!sender.hasPermission("zey.pvp.setgroup")) {
				sender.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}

			if (args.length != 2) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §8➸ §cErrado, utilize a sintaxe correta: /setgroup [Jogador(a)] [Grupo]");
				p.sendMessage(
						"§cGrupos disponiveis§f: §7NORMAL§f, §bYT§f, §3YT+§f, §2BUILDER§f, §eHELPER§f, §dTRIAL§f, §1GC§f, §5MOD§f, §3MODGC§f, §5MOD+§f, §cADMIN§f, §cGERENTE§f, §3DEV§f, §fCOORDENADOR§f, §4DIRETOR§f, §4DONO§f.");
				return true;
			}

			String grupo = args[1];
			Player player = Bukkit.getPlayer(args[0]);
			if (grupo.equalsIgnoreCase("normal")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §7§lNORMAL");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " delete");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §7§lNORMAL§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("youtuber+")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §3§lYT+");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set YouTuber+");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §3§lYT+§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("youtuber")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §b§lYT");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set YouTuber");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §b§YT§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("builder")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §2§lBUILDER");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set Builder");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para  §2§lBUILDER§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("helper")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §e§lHELPER");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Helper");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §e§lHELPER§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("trial")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §d§lTRIAL");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Trial");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §d§lTRIAL§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("gc")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §1§lGC");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set GC");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §1§lGC§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("modgc")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §3§lMODGC");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set ModGC");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §3§lMODGC§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("mod")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §5§lMOD");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Mod");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §5§lMOD§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("mod+")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §5§lMOD+");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Mod+");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §5§lMOD+§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("admin")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §c§lADMIN");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Admin");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §c§lADMIN§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("admingc")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §c§lADMINGC");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set AdminGC");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §c§lADMINGC§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("gerente")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §c§lGERENTE");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set Gerente");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §c§lGERENTE§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("developer")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §3§lDEV");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set Developer");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §3§lDEV§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (grupo.equalsIgnoreCase("subdona")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4§lS-DONA");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set SubDona");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §4§lS-DONA§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("coordenador")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §f§lCOORDENADOR");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set Coordenador");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §f§lCOORDENADOR§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("diretor")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4§lDIRETOR");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"pex user " + player.getName() + " group set Diretor");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §4§lDIRETOR§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("dona")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4[DONA]");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Dona");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §4[DONA]§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}

			if (sender.hasPermission("*") && grupo.equalsIgnoreCase("dono")) {
				p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4§lDONO");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Dono");
				player.kickPlayer(
						"§cAviso de alteração de grupo\n§fSeu grupo foi alterado para §4§lDONO§f.\n§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
				return true;
			}
		}

		return false;
	}
}
