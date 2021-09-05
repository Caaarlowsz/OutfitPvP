package Outfit.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.APIs.ChatInterativo;
import Outfit.PvP.APIs.ClanAPI;
import Outfit.PvP.APIs.TagsAPI;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Score.SPlayer;
import ca.wacos.nametagedit.NametagAPI;

public class TagCommand implements CommandExecutor, Listener {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cApenas jogadores podem usar isso.");
			return true;
		}
		Player p = (Player) sender;
		if(args.length == 0) {
			if (p.getName().equalsIgnoreCase("dasdasdsa") || p.getName().equalsIgnoreCase("EOFLUXO")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lDONA","/tag dona" , "§d(Clique) §7" + "§7Exemplo: §4§lDONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§4§lS-DONA","/tag subdona" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lDEV","/tag developer" , "§d(Clique) §7" + "§7Exemplo: §3§lDEV §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lSPRO","/tag spro" , "§d(Clique) §7" + "§7Exemplo: §b§lYT§b§lYT §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA §1","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.dono")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lDONO","/tag dono" , "§d(Clique) §7" + "§7Exemplo: §4§lDONO §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§4§lS-DONO","/tag subdono" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONO §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lDIRETOR","/tag diretor" , "§d(Clique) §7" + "§7Exemplo: §6§lDIRETOR §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lDEV","/tag developer" , "§d(Clique) §7" + "§7Exemplo: §3§lDEV §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lMANAGER","/tag manager" , "§d(Clique) §7" + "§7Exemplo: §6§lMANAGER §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lSPRO","/tag spro" , "§d(Clique) §7" + "§7Exemplo: §e§lSPRO §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.dona")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lDONA","/tag dona" , "§d(Clique) §7" + "§7Exemplo: §4§lDONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§4§lS-DONA","/tag subdona" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lDEV","/tag developer" , "§d(Clique) §7" + "§7Exemplo: §3§lDEV §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lSPRO","/tag spro" , "§d(Clique) §7" + "§7Exemplo: §e§lSPRO §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.subdono")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lS-DONO","/tag subdono" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONO §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lDIRETOR","/tag diretor" , "§d(Clique) §7" + "§7Exemplo: §6§lDIRETOR §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lMANAGER","/tag manager" , "§d(Clique) §7" + "§7Exemplo: §6§lMANAGER §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.diretor")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§6§lDIRETOR","/tag diretor" , "§d(Clique) §7" + "§7Exemplo: §6§lDIRETOR §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lMANAGER","/tag manager" , "§d(Clique) §7" + "§7Exemplo: §6§lMANAGER §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.coordenador")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§f§lCOORDENADOR","/tag coordenador" , "§d(Clique) §7" + "§7Exemplo: §f§lCOORD §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.subdona")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lS-DONA","/tag subdona" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lMANAGER","/tag manager" , "§d(Clique) §7" + "§7Exemplo: §6§lMANAGER §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.developer")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§4§lDONO","/tag dono" , "§d(Clique) §7" + "§7Exemplo: §4§lDONO §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§4§lDONA","/tag dona" , "§d(Clique) §7" + "§7Exemplo: §4§lDONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lDIRETOR","/tag diretor" , "§d(Clique) §7" + "§7Exemplo: §6§lDIRETOR §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§4§lS-DONA","/tag subdona" , "§d(Clique) §7" + "§7Exemplo: §4§lS-DONA §4" + p.getName());
				ChatInterativo.Comando(p.getName(), "§3§lDEV","/tag developer" , "§d(Clique) §7" + "§7Exemplo: §3§lDEV §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lSPRO","/tag spro" , "§d(Clique) §7" + "§7Exemplo: §e§lSPRO §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.gerente")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§c§lGERENTE","/tag gerente" , "§d(Clique) §7" + "§7Exemplo: §c§lGERENTE §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
		}
			if(p.hasPermission("grupo.admingc")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§c§lADMINGC","/tag admingc" , "§d(Clique) §7" + "§7Exemplo: §c§lADMINGC §f" + p.getName());
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.admin")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§c§lADMIN","/tag admin" , "§d(Clique) §7" + "§7Exemplo: §c§lADMIN §c" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.mod+")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§5§lMOD+","/tag mod+" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD+ §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.modgc")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§5§lMODGC","/tag modgc" , "§d(Clique) §7" + "§7Exemplo: §5§lMODGC §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.mod")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§5§lMOD","/tag mod" , "§d(Clique) §7" + "§7Exemplo: §5§lMOD §5" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.manager")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§6§lMANAGER","/tag manager" , "§d(Clique) §7" + "§7Exemplo: §6§lMANAGER §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.gc")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§1§lGC","/tag gc" , "§d(Clique) §7" + "§7Exemplo: §1§lGC §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.trial")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§d§lTRIAL","/tag trial" , "§d(Clique) §7" + "§7Exemplo: §d§lTRIAL §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.helper")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§e§lHELPER","/tag helper" , "§d(Clique) §7" + "§7Exemplo: §e§lHELPER §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.builder")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§2§lBUILDER","/tag builder" , "§d(Clique) §7" + "§7Exemplo: §2§lBUILDER §2" + p.getName());
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.youtuber+")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§3§lYT+","/tag youtuber+" , "§d(Clique) §7" + "§7Exemplo: §3§lYT+ §3" + p.getName());
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.youtuber")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§b§lYT","/tag youtuber" , "§d(Clique) §7" + "§7Exemplo: §b§lYT §b" + p.getName());
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.spro")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§e§lSPRO","/tag spro" , "§d(Clique) §7" + "§7Exemplo: §e§lSPRO §e" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.beta")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§1§lBETA","/tag beta" , "§d(Clique) §7" + "§7Exemplo: §1§lBETA §1" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.supremo")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§d§lKOMBO","/tag kombo" , "§d(Clique) §7" + "§7Exemplo: §d§lKOMBO §d" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.pro")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§6§lPRO","/tag pro" , "§d(Clique) §7" + "§7Exemplo: §6§lPRO §6" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.mvp")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§9§lMVP","/tag mvp" , "§d(Clique) §7" + "§7Exemplo: §9§lMVP §9" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			if(p.hasPermission("grupo.vip")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
				p.sendMessage("§E");
				ChatInterativo.Comando(p.getName(), "§a§lVIP","/tag vip" , "§d(Clique) §7" + "§7Exemplo: §a§lVIP §a" + p.getName());
				ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
				return true;
			}
			p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §fLista de §d§lTODAS§f as §d§lTAGS§f disponiveis para você:");
			p.sendMessage("§E");
			ChatInterativo.Comando(p.getName(), "§7§lNORMAL","/tag normal" , "§d(Clique) §7" + "§7Exemplo: §7" + p.getName());
			return true;
		}
		if(p.hasPermission("tag.dono")) {
			if(args[0].equalsIgnoreCase("dono")) {
				TagsAPI.setarTag(p, "§4§lDONO§4 ");
				NametagAPI.setPrefix(p.getName(), "§4§lDONO§4 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §4§lDONO");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.dona")) {
			if(args[0].equalsIgnoreCase("dona")) {
				TagsAPI.setarTag(p, "§4§lDONA§4 ");
				NametagAPI.setPrefix(p.getName(), "§4§lDONA§4 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §4§lDONA");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.diretor")) {
			if(args[0].equalsIgnoreCase("diretor")) {
				TagsAPI.setarTag(p, "§6§lDIRETOR§6 ");
				NametagAPI.setPrefix(p.getName(), "§6§lDIRETOR§6 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §6§lDIRETOR");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.subdono")) {
			if(args[0].equalsIgnoreCase("subdono")) {
				TagsAPI.setarTag(p, "§4§lS-DONO§4 ");
				NametagAPI.setPrefix(p.getName(), "§4§lS-DONO§4 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §4§lS-DONO");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.subdona")) {
			if(args[0].equalsIgnoreCase("subdona")) {
				TagsAPI.setarTag(p, "§4§lS-DONA§4 ");
				NametagAPI.setPrefix(p.getName(), "§4§lS-DONA§4 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §4§lS-DONA");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.developer")) {
			if(args[0].equalsIgnoreCase("developer")) {
				TagsAPI.setarTag(p, "§3§lDEV§3 ");
				NametagAPI.setPrefix(p.getName(), "§3§lDEV§3 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §3§lDEV");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.gerente")) {
			if(args[0].equalsIgnoreCase("gerente")) {
				TagsAPI.setarTag(p, "§c§lGERENTE§c ");
				NametagAPI.setPrefix(p.getName(), "§c§lGERENTE§c ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §c§lGERENTE");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.admingc")) {
			if(args[0].equalsIgnoreCase("admingc")) {
				TagsAPI.setarTag(p, "§c§lADMINGC§c ");
				NametagAPI.setPrefix(p.getName(), "§c§lADMINGC§c ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §c§lADMINGC");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.admin")) {
			if(args[0].equalsIgnoreCase("admin")) {
				TagsAPI.setarTag(p, "§c§lADMIN§c ");
				NametagAPI.setPrefix(p.getName(), "§c§lADMIN§c ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §c§lADMIN");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.mod+")) {
			if(args[0].equalsIgnoreCase("mod+")) {
				TagsAPI.setarTag(p, "§5§lMOD+§5 ");
				NametagAPI.setPrefix(p.getName(), "§5§lMOD+§5 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §5§lMOD+");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.modgc")) {
			if(args[0].equalsIgnoreCase("modgc")) {
				TagsAPI.setarTag(p, "§5§lMODGC§5 ");
				NametagAPI.setPrefix(p.getName(), "§5§lMODGC§5 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §5§lMODGC");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.mod")) {
			if(args[0].equalsIgnoreCase("mod")) {
				TagsAPI.setarTag(p, "§5§lMOD§5 ");
				NametagAPI.setPrefix(p.getName(), "§5§lMOD§5 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §5§lMOD");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.manager")) {
			if(args[0].equalsIgnoreCase("manager")) {
				TagsAPI.setarTag(p, "§6§lMANAGER§6 ");
				NametagAPI.setPrefix(p.getName(), "§6§lMANAGER§6 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §6§lMANAGER");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.gc")) {
			if(args[0].equalsIgnoreCase("gc")) {
				TagsAPI.setarTag(p, "§1§lGC§1 ");
				NametagAPI.setPrefix(p.getName(), "§1§lGC§1 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §1§lGC");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.trial")) {
			if(args[0].equalsIgnoreCase("trial")) {
				TagsAPI.setarTag(p, "§d§lTRIAL§d ");
				NametagAPI.setPrefix(p.getName(), "§d§lTRIAL§d ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §d§lTRIAL");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.helper")) {
			if(args[0].equalsIgnoreCase("helper")) {
				TagsAPI.setarTag(p, "§e§lHELPER§e ");
				NametagAPI.setPrefix(p.getName(), "§e§lHELPER§e ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §e§lHELPER");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.builder")) {
			if(args[0].equalsIgnoreCase("builder")) {
				TagsAPI.setarTag(p, "§2§lBUILDER§2 ");
				NametagAPI.setPrefix(p.getName(), "§2§lBUILDER§2 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §2§lBUILDER");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.youtuber+")) {
			if(args[0].equalsIgnoreCase("youtuber+")) {
				TagsAPI.setarTag(p, "§3§lYT+§3 ");
				NametagAPI.setPrefix(p.getName(), "§3§lYT+§3 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §3§lYT+");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.youtuber")) {
			if(args[0].equalsIgnoreCase("youtuber")) {
				TagsAPI.setarTag(p, "§b§lYT§b ");
				NametagAPI.setPrefix(p.getName(), "§b§lYT§b ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §b§lYT");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.spro")) {
			if(args[0].equalsIgnoreCase("spro")) {
				TagsAPI.setarTag(p, "§e§lSPRO§e ");
				NametagAPI.setPrefix(p.getName(), "§e§lSPRO§e ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §e§lSPRO");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.beta")) {
			if(args[0].equalsIgnoreCase("beta")) {
				TagsAPI.setarTag(p, "§1§lBETA§1 ");
				NametagAPI.setPrefix(p.getName(), "§1§lBETA§1 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §1§lBETA");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.outfit")) {
			if(args[0].equalsIgnoreCase("kombo")) {
				TagsAPI.setarTag(p, "§d§lKOMBO§d ");
				NametagAPI.setPrefix(p.getName(), "§d§lKOMBO§d ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §d§lKOMBO");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.pro")) {
			if(args[0].equalsIgnoreCase("pro")) {
				TagsAPI.setarTag(p, "§6§lPRO§6 ");
				NametagAPI.setPrefix(p.getName(), "§6§lPRO§6 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §6§lPRO");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.mvp")) {
			if(args[0].equalsIgnoreCase("mvp")) {
				TagsAPI.setarTag(p, "§9§lMVP§9 ");
				NametagAPI.setPrefix(p.getName(), "§9§lMVP§9 ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §9§lMVP");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.vip")) {
			if(args[0].equalsIgnoreCase("vip")) {
				TagsAPI.setarTag(p, "§a§lVIP§a ");
				NametagAPI.setPrefix(p.getName(), "§a§lVIP§a ");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §a§lVIP§a");
				
				return true;
			 }
			}
		if(p.hasPermission("tag.normal")) {
			if(args[0].equalsIgnoreCase("normal")) {
				TagsAPI.setarTag(p, "§7");
				NametagAPI.setPrefix(p.getName(), "§7");
				if (ClanAPI.getClanPlayer(p) == null) {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
			      } else {
			        NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
			    }
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aSua TAG foi alterada para §7§lNORMAL");
				
				return true;
			 }
			}
		return false;
	}
}
