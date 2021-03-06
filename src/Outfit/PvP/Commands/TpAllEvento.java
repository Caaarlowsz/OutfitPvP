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
import Outfit.PvP.Utils.Proteção;

public class TpAllEvento implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tpevento")) {
			if (!p.hasPermission("zey.pvp.tp.all")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você puxou §a§lTODOS §7os jogadores até você.");

				for (Player tpe : Bukkit.getOnlinePlayers()) {
					if (tpe != p) {

						if (WarpAPI.getWarp(tpe) == "Evento") {
							CombatLog.Sair.remove(tpe.getName());

							Habilidade.setAbility(tpe, "Nenhum");
							WarpAPI.setWarp(tpe, "Evento");
							KitUtil.tirarArmadura(tpe);
							tpe.getInventory().clear();
							Proteção.setImortal(tpe, false);
							Proteção.isImortal(tpe);
							tpe.setAllowFlight(false);
							tpe.setFlying(false);
							KitAPI.remove(tpe);
							Habilidade.removeAbility(tpe);
							KitAPI.removeAbility(tpe);
							tpe.setGameMode(GameMode.SURVIVAL);
							tpe.setFireTicks(0);
							tpe.teleport(p);
						}
					}
				}
			}
		}
		return false;
	}
}