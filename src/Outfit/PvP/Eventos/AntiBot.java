package Outfit.PvP.Eventos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.maxgamer.maxbans.MaxBans;
import org.maxgamer.maxbans.banmanager.IPBan;

import Outfit.PvP.Main.Main;

public class AntiBot implements Listener {
	static int BotAttack = 0;
	public static List<String> NoBot = new ArrayList<>();
	public static List<String> InServer = new ArrayList<>();
	public static List<String> FastLogin = new ArrayList<>();

	@EventHandler(priority = EventPriority.MONITOR)
	public void NoBot(AsyncPlayerPreLoginEvent event) throws MalformedURLException, IOException {
		final String ip = event.getAddress().getHostAddress();
		IPBan ipban = MaxBans.instance.getBanManager().getIPBan(ip);
		String ip2 = event.getAddress().getHostName();
		if (InServer.contains(ip2)) {
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
					"§4§lANTIBOT§r\n§cMultiplas Contas!\n§7Esse IP ja esta logado no servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
			return;
		}
		if (ipban != null) {
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
					"§4§lBLACKLIST§r\n§cIP Banido!\n§7Esse IP foi permanentemente banido do servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
		}
		if ((!NoBot.contains(ip)) && (ipban == null)) {
			String url = "http://proxycheck.io/v2/" + ip + "?key=330t46-r70221-08211a-z786k8&vpn=1&asn=1";
			final Scanner Scanner = new Scanner(new URL(url).openStream());
			if (BotAttack >= 100) {
				event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
						"§4§lANTIBOT§r\n§cWhitelist ativada!\n§7O servidor esta sofrendo ataques de bot's nesse momento tente entrar novamente em 5 minutos!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						if (AntiBot.BotAttack >= 100) {
							AntiBot.BotAttack = 0;
						}
					}
				}, 6000L);
				return;
			}
			if ((Scanner.findWithinHorizon("yes", 0) != null) || (Scanner.findWithinHorizon("VPN", 0) != null)
					|| (Scanner.findWithinHorizon("Google LLC", 0) != null)
					|| (Scanner.findWithinHorizon("North America", 0) != null)
					|| (Scanner.findWithinHorizon("United States", 0) != null)
					|| (Scanner.findWithinHorizon("Indonesia", 0) != null)
					|| (Scanner.findWithinHorizon("Germany", 0) != null)
					|| (Scanner.findWithinHorizon("Singapore", 0) != null)
					|| (Scanner.findWithinHorizon("France", 0) != null)
					|| (Scanner.findWithinHorizon("India", 0) != null)
					|| (Scanner.findWithinHorizon("Russia", 0) != null)
					|| (Scanner.findWithinHorizon("Colombia", 0) != null)
					|| (Scanner.findWithinHorizon("Bangladesh", 0) != null)
					|| (Scanner.findWithinHorizon("Thailand", 0) != null)) {
				event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
						"§4§lANTIBOT§r\n§cProxy Detectada!\n§7Desative para se conectar ao servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ipban -s " + ip + " [AntiBot] Uso de VPN/Proxy!");
				BotAttack += 1;
				Scanner.close();
				return;
			}
			if (Scanner.findWithinHorizon("no", 0) != null) {
				if (FastLogin.contains(ip)) {
					event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
							"§4§lANTIBOT§r\n§cVoce esta fazendo isso muito rapido!\n§7Aguarde 5 segundos e tente novamente!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				} else {
					event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
							"§d§lCHECKING§r\n§aSua conexao foi verificada com sucesso!\n§7Relogue novamente ao servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				}
				FastLogin.add(ip);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						AntiBot.NoBot.add(ip);
						AntiBot.FastLogin.remove(ip);
						Scanner.close();
					}
				}, 50L);
				return;
			}
			if (Scanner.findWithinHorizon("error", 0) != null) {
				if (FastLogin.contains(ip)) {
					event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
							"§4§lANTIBOT§r\n§cVoce esta fazendo isso muito rapido!\n§7Aguarde 5 segundos e tente novamente!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				} else {
					event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
							"§d§lCHECKING§r\n§cFalha ao verificar sua conexao com o servidor!\n§7Relogue novamente ao servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
				}
				FastLogin.add(ip);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						AntiBot.NoBot.add(ip);
						AntiBot.FastLogin.remove(ip);
						Scanner.close();
					}
				}, 50L);
				return;
			}
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
					"§d§lCHECKING§r\n§cO sistema de verificação esta offline no momento!\n§7Tente entrar mais tarde no servidor!\n\n§fDiscord: §ddiscord.gg/FuxCUsufhk");
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void Entrar(PlayerJoinEvent e) {
		InServer.add(e.getPlayer().getAddress().getHostName());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void Sair(PlayerQuitEvent e) {
		InServer.remove(e.getPlayer().getAddress().getHostName());
	}
}
