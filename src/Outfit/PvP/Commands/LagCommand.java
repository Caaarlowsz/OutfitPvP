package Outfit.PvP.Commands;

import java.lang.management.ManagementFactory;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import Outfit.PvP.APIs.Lag;
import Outfit.PvP.Main.Main;

public class LagCommand implements CommandExecutor {
	public static int TickCount = 0;
	public static long[] Ticks = new long[63];
	public static long LastTick = 0L;

	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if (arg1.getName().equalsIgnoreCase("ping")) {
			if (arg3.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Seu ping é de §d"
						+ ((CraftPlayer) p).getHandle().ping + " §7ms");
				return true;
			} else {
				Player target = Bukkit.getPlayer(arg3[0]);
				if (target == null) {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
					return true;
				} else {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7O jogador(a): §d" + target.getName()
							+ " §7está com um ping de §d" + ((CraftPlayer) target).getHandle().ping + " §7ms");
					return true;
				}
			}
		} else if (arg1.getName().equalsIgnoreCase("lag")) {
			int ping = ((CraftPlayer) p).getHandle().ping;
			long RAM_TOTAL = Runtime.getRuntime().totalMemory();
			long RAM_FREE = Runtime.getRuntime().freeMemory();
			long RAM_USED = RAM_TOTAL - RAM_FREE;
			double RAM_USED_PERCENTAGE = (double) (RAM_USED * 100L / RAM_TOTAL);
			double tps = Lag.getTPS();
			double lag = (double) Math.round((1.0D - tps / 20.0D) * 100.0D);
			double usedCPU = 0.0D;

			try {
				usedCPU = getProcessCpuLoad();
			} catch (Exception var22) {
			}

			p.sendMessage("§7 ");
			p.sendMessage("§7Coletando informações...");
			p.sendMessage("§7Você está no Servidor§8: " + Main.prefix + "§7, online aqui§8: §d"
					+ Bukkit.getOnlinePlayers().length);
			p.sendMessage("  §d- §7Uso de processamento§8: §d" + usedCPU + " %§8, §7lag§8: §d"
					+ (usedCPU >= 90.0D ? "sim" : "nao"));
			p.sendMessage("  §d- §7Sobrecarregamento geral§8: §d" + RAM_USED_PERCENTAGE + " %§8, §7lag§8: §d"
					+ (RAM_USED_PERCENTAGE >= 90.0D ? "sim" : "nao"));
			p.sendMessage("  §d- §7Seu ping é de§8: §d" + ping + " ms§8, §7lag§8: §d" + (ping >= 250 ? "sim" : "nao"));
			p.sendMessage("  §d- §7Servidor rodando em§8: §d" + Lag.getTPS() + " TPS§8, §7lag§8: §d" + lag + " %");
			p.sendMessage(this.getString(RAM_USED_PERCENTAGE >= 90.0D ? "sim" : "nao", ping >= 450 ? "sim" : "nao",
					usedCPU >= 90.0D ? "sim" : "nao"));
			p.sendMessage("§7 ");
			return true;
		} else {
			return false;
		}
	}

	public static double getTPS() {
		return getTPS(100);
	}

	public static double getTPS(int ticks) {
		if (TickCount < ticks) {
			return 20.0D;
		} else {
			int target = (TickCount - 1 - ticks) % Ticks.length;
			long elapsed = System.currentTimeMillis() - Ticks[target];
			return (double) ticks / ((double) elapsed / 1000.0D) > 20.0D ? 20.0D
					: (double) ticks / ((double) elapsed / 1000.0D);
		}
	}

	public static double getElapsed(int tickID) {
		if (TickCount - tickID >= Ticks.length) {
			return (double) (TickCount - tickID) * getTPS();
		} else {
			long time = Ticks[tickID % Ticks.length];
			return (double) (System.currentTimeMillis() - time);
		}
	}

	public void run() {
		Ticks[TickCount % Ticks.length] = System.currentTimeMillis();
		++TickCount;
	}

	public String getString(String lagram, String lagping, String lagprocess) {
		if (lagram.equalsIgnoreCase("nao") && lagping.equalsIgnoreCase("nao") && lagprocess.equalsIgnoreCase("nao")) {
			return "§aO Servidor e sua Internet estão em excelente estado.";
		} else if (lagram.equalsIgnoreCase("sim") && lagping.equalsIgnoreCase("nao")
				&& lagprocess.equalsIgnoreCase("nao")) {
			return "§2O Servidor e sua Internet estão em ótimo estado.";
		} else if (lagram.equalsIgnoreCase("sim") && lagping.equalsIgnoreCase("sim")
				&& lagprocess.equalsIgnoreCase("nao")) {
			return "§6O Servidor e sua Internet estão em bom estado.";
		} else if (lagram.equalsIgnoreCase("sim") && lagping.equalsIgnoreCase("sim")
				&& lagprocess.equalsIgnoreCase("sim")) {
			return "§cO Servidor e sua Internet estão em péssimo estado.";
		} else {
			return lagram.equalsIgnoreCase("nao") && lagping.equalsIgnoreCase("sim")
					&& lagprocess.equalsIgnoreCase("nao") ? "§cSua Internet não está em boas condições" : "";
		}
	}

	public static double getProcessCpuLoad() throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
		AttributeList list = mbs.getAttributes(name, new String[] { "ProcessCpuLoad" });
		if (list.isEmpty()) {
			return Double.NaN;
		} else {
			Attribute att = (Attribute) list.get(0);
			Double value = (Double) att.getValue();
			return value == -1.0D ? Double.NaN : (double) ((int) (value * 1000.0D)) / 10.0D;
		}
	}
}
