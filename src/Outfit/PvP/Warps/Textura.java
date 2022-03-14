package Outfit.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class Textura implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public Textura(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("textura")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("tx.world"));
			double x = plugin.getConfig().getDouble("tx.x");
			double y = plugin.getConfig().getDouble("tx.y");
			double z = plugin.getConfig().getDouble("tx.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("tx.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("tx.yaw"));
			p.teleport(lobby);
			p.getInventory().clear();
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aTeleportado com sucesso");
			TheTitle.sendTitle(p, "§d§lTEXTURA");
			TheTitle.sendSubTitle(p, "§7Teleportado com sucesso!");
			if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
				OutfitPvP.admins.remove(p.getName());
				p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você saiu do modo §c§lADMIN");
				Player[] var17;
				int var16 = (var17 = Bukkit.getOnlinePlayers()).length;

				for (int var15 = 0; var15 < var16; ++var15) {
					Player players = var17[var15];
					players.showPlayer(p);
				}
			}

			p.setAllowFlight(false);
			p.setFlying(false);
			KitAPI.remove(p);
			Habilidade.setAbility(p, "Nenhum");
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			if (WarpAPI.getWarp(p) != "Textura") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "Textura");
				MenuWarps.AddWarp(p);
			}

			Proteção.setImortal(p, true);
			Proteção.isImortal(p);
			KitAPI.setitem(p, Material.DIAMOND_SWORD, "§fEspada de Diamante", 0, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.GOLD_SWORD, "§fEspada de Ouro", 1, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.IRON_SWORD, "§fEspada de Ferro", 2, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.STONE_SWORD, "§fEspada de Pedra", 3, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.WOOD_SWORD, "§fEspada de Madeira", 4, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.COMPASS, "§fBulssola", 6, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.MUSHROOM_SOUP, "§fSopa", 7, Enchantment.DAMAGE_ALL, 0, false);
			KitAPI.setitem(p, Material.BOWL, "§fPote", 8, Enchantment.DAMAGE_ALL, 0, false);
		}

		return false;
	}
}
