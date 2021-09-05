package Outfit.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector.PacketTabHeader;

import Outfit.PvP.Main.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;

public class TabPersonalizado implements Listener {

	@EventHandler
	void TabDoServidor(PlayerJoinEvent evento) {
		final Player p = evento.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {
				CraftPlayer player = (CraftPlayer) p;
				if (player.getHandle().playerConnection.networkManager.getVersion() < 47) {
					return;
				}
				IChatBaseComponent header = ChatSerializer.a("{\"text\": \"    " + Main.prefix
						+ " §7- §fServidor De PvP \n§7Bem vindo: §d" + p.getName() + "\n" + "\"}");
				IChatBaseComponent footer = ChatSerializer
						.a("{\"text\": \"" + "\n" + "§7IP: §fkombopvp.com" + "\n" + "§7Jogadores: §f"
								+ Bukkit.getOnlinePlayers().length + " §7Ping: §f" + ((CraftPlayer) p).getHandle().ping
								+ " §7Kit: §f" + Habilidade.getAbility(p) + "\n§ehttps://discord.gg/FDFhphW" + "\"}");
				PacketTabHeader packet = new PacketTabHeader(header, footer);
				player.getHandle().playerConnection.sendPacket(packet);
			}
		}, 1, 20L);
	}
}
