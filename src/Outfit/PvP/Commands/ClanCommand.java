package Outfit.PvP.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.APIs.ClanAPI;
import Outfit.PvP.Clan.Clan;
import Outfit.PvP.Clan.ClanManager;
import Outfit.PvP.Config.ClanConfig;
import Outfit.PvP.Config.ZeyCoins;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Score.SPlayer;
import ca.wacos.nametagedit.NametagAPI;

public class ClanCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (Cmd.getName().equalsIgnoreCase("clan")) {

			if (Args.length == 0) {
				p.sendMessage(" ");
				p.sendMessage("§8» §5§lCLAN MENU");
				p.sendMessage(" ");
				p.sendMessage("§d/clan criar [Nome] [Tag] §f- Cria um clan");
				p.sendMessage("§d/clan deletar §f- Deleta o Clan");
				p.sendMessage("§d/clan convidar [Nome] §f- Convida alguém");
				p.sendMessage("§d/clan aceitar [Nome] §f- Aceita um pedido de Clan");
				p.sendMessage("§d/clan tag §f- Adicona a tag do clan no nick");
				p.sendMessage("§d/clan expulsar [Nome] §f- Expulsa alguém");
				p.sendMessage("§d/clan sair §f- Sai do clan");
				p.sendMessage("§d/clan msg [Mensagem] §f- Envia mensagem para o clan");
				p.sendMessage("§d/clan info §f- Informações do clan");
				p.sendMessage(" ");
				return true;
			}
			try {
				if (Args[0].equalsIgnoreCase("aceitar")) {
					if (ClanAPI.getClanPlayer(p) != null) {
						p.sendMessage("Você já possui um Clan");
						return true;
					}
					String clan = Args[1];
					if (!ClanAPI.pedidos.get(clan).contains(p.getName().toLowerCase())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ Você não recebeu convite desse Clan");
						return true;
					}
					Clan clann = ClanManager.getClan(Args[1]);
					if (clann == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cEste clan não existe!");
						return true;
					}
					ClanAPI.addPlayerToClan(p, ClanManager.getClan(clan));
					ClanAPI.senMessage(ClanAPI.getClanPlayerString(p), "§d# §f" + p.getName() + " §fse aliou ao Clan");
					ClanAPI.pedidos.get(clan).remove(p.getName().toLowerCase());

				}
				if (Args[0].equalsIgnoreCase("convidar")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §8➸ §cVocê não possui um Clan");
						return true;
					}
					if (!ClanAPI.getOwner(ClanAPI.getClanPlayerString(p)).equalsIgnoreCase(p.getName())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não é o Dono desse Clan");
						return true;
					}
					if (Bukkit.getPlayer(Args[1].toLowerCase()) != null
							&& ClanAPI.getClanPlayer(Bukkit.getPlayer(Args[1].toLowerCase())) != null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cEsse Jogador já possui um Clan");
						return true;
					}
					if (!ClanAPI.pedidos.containsKey(ClanAPI.getClanPlayerString(p))) {
						ClanAPI.pedidos.put(ClanAPI.getClanPlayerString(p), new ArrayList<String>());
					}
					if (ClanAPI.pedidos.get(ClanAPI.getClanPlayerString(p)) == null) {
						ClanAPI.pedidos.put(ClanAPI.getClanPlayerString(p), new ArrayList<String>());
					}
					String nick = Args[1].toLowerCase();
					ArrayList<String> list = ClanAPI.pedidos.get(ClanAPI.getClanPlayerString(p));
					if (!list.contains(nick)) {
						list.add(nick);
						Player vic = Bukkit.getPlayer(nick);
						if (vic != null) {
							vic.sendMessage(" ");
							vic.sendMessage("§5§lCLAN §8» §fVocê recebeu um Convite do clan §f"
									+ ClanAPI.getClanPlayerString(p) + " §f(" + ClanConfig.getConfig()
											.getString(ClanAPI.getClanPlayerString(p) + ".Tag").replace("&", "§")
									+ "§f)");
							vic.sendMessage("§5§lCLAN §8» §fUse §d/clan aceitar " + ClanAPI.getClanPlayerString(p)
									+ " §fou apenas ignore essa Mensagem");
							vic.sendMessage(" ");
						}
						ClanAPI.pedidos.put(ClanAPI.getClanPlayerString(p), list);
						ClanAPI.senMessage(ClanAPI.getClanPlayerString(p),
								"§d# §f" + nick + " §dfoi convidado para o Clan");
						return true;
					} else {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cJá existe um convite para esse Nick");

						return true;
					}
				}
				if (Args[0].equalsIgnoreCase("info")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					p.sendMessage(" ");
					p.sendMessage("§8» §5§lCLAN-INFO");
					p.sendMessage(" ");
					p.sendMessage("§3» §fNome do Clan: §d" + ClanAPI.getClanPlayerString(p));
					p.sendMessage("§b» §fTag do Clan: " + ClanConfig.getConfig()
							.getString(ClanAPI.getClanPlayerString(p) + ".Tag").replace("&", "§"));
					p.sendMessage("§a» §fLider: §d" + ClanAPI.getOwner(ClanAPI.getClanPlayerString(p)));
					p.sendMessage("§e» §fOnline: §d" + ClanAPI.getOnlineSize(ClanAPI.getClanPlayerString(p)));
					p.sendMessage(" ");
				}
				if (Args[0].equalsIgnoreCase("tag")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					if (Args[1].length() > 3) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cA tag nao pode ultrapassar 3 caracteres");
						return true;
					}
					NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));
					p.sendMessage(OutfitPvP.prefix + " §8➸ §aTag adicionada com sucesso.");
				}
				if (Args[0].equalsIgnoreCase("expulsar")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					if (!ClanAPI.getOwner(ClanAPI.getClanPlayerString(p)).equalsIgnoreCase(p.getName())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não é o Dono desse Clan");
						return true;
					}
					Player vic = Bukkit.getPlayer(Args[1]);
					if (vic.getName().equals(p.getName())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não pode kikar você mesmo");
						return true;
					}
					if (vic == null) {
						OfflinePlayer vicoff = Bukkit.getOfflinePlayer(Args[1]);
						if (!ClanAPI.getClanPlayerString(vicoff).equalsIgnoreCase(ClanAPI.getClanPlayerString(p))) {
							p.sendMessage(OutfitPvP.prefix + " §8➸ §cEsse jogador nao pertence ao seu Clan");
							return true;
						}
						ClanAPI.kickPlayer(vicoff, ClanAPI.getClanPlayerString(p));
						ClanAPI.senMessage(ClanAPI.getClanPlayerString(p),
								"§c# §f" + p.getName() + " §fexpulsou o Jogador §d" + vicoff.getName());
						return true;
					}
					if (!ClanAPI.getClanPlayerString(vic).equalsIgnoreCase(ClanAPI.getClanPlayerString(p))) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cEsse jogador nao pertence ao seu Clan");
						return true;
					}
					ClanAPI.kickPlayer(vic, ClanAPI.getClanPlayerString(p));
					ClanAPI.senMessage(ClanAPI.getClanPlayerString(p),
							"§c# §f" + p.getName() + " §fexpulsou o Jogador §d" + vic.getName());
					vic.sendMessage("§cVocê foi expulso do Clan");
					NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(vic));

					return true;
				}
				if (Args[0].equalsIgnoreCase("msg")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					String message = " ";
					for (int i = 1; i < Args.length; i++) {
						if (i == Args.length - 1) {
							message = message + Args[i];
						} else {
							message = message + Args[i] + " ";
						}
					}
					ClanAPI.senMessage(ClanAPI.getClanPlayerString(p),
							"§8[§d" + SPlayer.Clan(p) + "§8] §7" + p.getName() + " §8➸§f" + message.replace("&", "§"));
				}
				if (Args[0].equalsIgnoreCase("deletar")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					if (!ClanAPI.getOwner(ClanAPI.getClanPlayerString(p)).equalsIgnoreCase(p.getName())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não é o Dono desse Clan");
						return true;
					}

					p.sendMessage(OutfitPvP.prefix + " §8➸ §cClan deletado com Sucesso");
					Bukkit.broadcastMessage("§5§lCLAN §8» §d" + p.getName() + " §fdeletou o Clan §8➸ §c"
							+ ClanAPI.getClanPlayerString(p));
					Clan clan = ClanManager.getClan(ClanAPI.getClanPlayerString(p));
					clan.delete();
					NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));

				}
				if (Args[0].equalsIgnoreCase("sair")) {
					if (ClanAPI.getClanPlayer(p) == null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não possui um Clan");
						return true;
					}
					if (ClanAPI.getOwner(ClanAPI.getClanPlayerString(p)).equalsIgnoreCase(p.getName())) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê não pode sair do seu Clan");
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cUse [/clan deletar] para deletar o Clan");
						return true;
					}
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê saiu do Clan");
					ClanAPI.senMessage(ClanAPI.getClanPlayerString(p), "§c# §f" + p.getName() + " §fsaiu do Clan");
					NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
					ClanAPI.kickPlayer(p, ClanAPI.getClanPlayerString(p));

				}
				if (Args[0].equalsIgnoreCase("criar")) {
					if (ZeyCoins.getPlayerMoney(p) < 2500) {
						p.sendMessage(OutfitPvP.prefix
								+ " §8➸ §cÉ necessário ter 2500 de coins para criar um Clan");
						return true;
					}
					if (ClanAPI.clanExist(Args[1])) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cEste clan já existe");
						return true;
					}
					if (ClanAPI.getClanPlayer(p) != null) {
						p.sendMessage(OutfitPvP.prefix + " §8➸ §cVocê já possui um Clan");
						return true;
					}
					String tag = Args[2].replace("&", "§").replace("§k", "").replace("§l", "").replace("§m", "")
							.replace("§o", "").replace("§n", "");
					String tag2 = ChatColor.stripColor(tag);
					if ((tag2.length() > 3) || (tag2.length() < 3) || Args[2].length() > 9) {
						p.sendMessage(
								OutfitPvP.prefix + " §8➸ §cA tag do clan deve ter apenas 3 caracteres.");
						return true;
					}
					for (String CLAN : ClanManager.getAllClansString()) {
						if (ClanConfig.getConfig().getString(CLAN + ".Tag").equalsIgnoreCase(tag)) {
							p.sendMessage(OutfitPvP.prefix + " §8➸ §cJá existe um Clan com essa Tag");
							return true;
						}
					}
					ClanAPI.createClan(p, tag, Args[1]);
					ZeyCoins.removeMoney(p, 2500);
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cClan criado com Sucesso!");
					Bukkit.broadcastMessage("§5§lCLAN §8» §d" + p.getName() + " §fcriou o Clan §8➸ §c" + Args[1]);
					NametagAPI.setSuffix(p.getName(), " " + SPlayer.ClanTag(p));

				}
			} catch (Exception ex) {
				p.sendMessage(" ");
				p.sendMessage("§8» §5§lCLAN MENU");
				p.sendMessage(" ");
				p.sendMessage("§d/clan criar [Nome] [Tag] §f- Cria um clan");
				p.sendMessage("§d/clan deletar §f- Deleta o Clan");
				p.sendMessage("§d/clan convidar [Nome] §f- Convida alguém");
				p.sendMessage("§d/clan aceitar [Nome] §f- Aceita um pedido de Clan");
				p.sendMessage("§d/clan expulsar [Nome] §f- Expulsa alguém");
				p.sendMessage("§d/clan sair §f- Sai do clan");
				p.sendMessage("§d/clan msg [Mensagem] §f- Envia mensagem para o clan");
				p.sendMessage("§d/clan info §f- Informações do clan");
				p.sendMessage(" ");
			}
		}
		return false;
	}

}
