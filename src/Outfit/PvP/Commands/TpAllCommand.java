package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.CombatLog;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class TpAllCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if (!p.hasPermission("zey.pvp.tp.all")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você puxou §a§lTODOS §7os jogadores até você.");
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §7O jogador(a): §e" + p.getName()
						+ "§7 puxou todos os jogadores até ele.");

				for (Player todos : Bukkit.getOnlinePlayers()) {
					if (todos != p) {
						todos.teleport(p);
						CombatLog.Sair.remove(todos.getName());

						Habilidade.setAbility(todos, "Nenhum");
						WarpAPI.setWarp(todos, "Evento");
						KitUtil.tirarArmadura(todos);
						todos.getInventory().clear();
						MenuWarps.RemoveWarp(todos);
						Proteção.setImortal(todos, false);
						Proteção.isImortal(todos);
						todos.setAllowFlight(false);
						todos.setFlying(false);
						KitAPI.remove(todos);
						Habilidade.removeAbility(todos);
						KitAPI.removeAbility(todos);
						todos.setGameMode(GameMode.SURVIVAL);
						todos.setFireTicks(0);
					}
				}
			}
		}
		return false;
	}
}
