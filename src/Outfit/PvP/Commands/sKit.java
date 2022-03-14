package Outfit.PvP.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;

public class sKit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> itens = new HashMap<String, ItemStack[]>();
	public HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();

	public sKit(OutfitPvP main) {
	}

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException var3) {
			return false;
		}
	}

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player p = (Player) Sender;
		if (Label.equalsIgnoreCase("skit") && Sender instanceof Player) {
			if (!p.hasPermission("zey.pvp.skit")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}

			if (Args.length == 0) {
				p.sendMessage("       ");
				p.sendMessage("                " + OutfitPvP.prefix);
				p.sendMessage("");
				p.sendMessage("§b» §eUtilize /skit criar [Kit]");
				p.sendMessage("§b» §eUtilize /skit aplicar [Kit] [Raio de Blocos]");
				p.sendMessage("       ");
				return true;
			}

			String nome;
			if (Args[0].equalsIgnoreCase("criar")) {
				if (Args.length == 1) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cUse: /skit para ver um mini-tutorial.");
					return true;
				}

				nome = Args[1];
				this.itens.put(nome, p.getInventory().getContents());
				this.armor.put(nome, p.getInventory().getArmorContents());
				p.sendMessage(OutfitPvP.prefix + " §8➸ §aO Kit: §e" + Args[1] + " §aFoi Criado");
				return true;
			}

			if (Args[0].equalsIgnoreCase("aplicar")) {
				if (Args.length <= 2) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cUtlize /skit para ver um mini-tutorial.");
					return true;
				}

				nome = Args[1];
				if (!this.itens.containsKey(nome) && !this.armor.containsKey(nome)) {
					p.sendMessage(OutfitPvP.prefix + " §8➸ §cO Kit §e" + nome + " §cnão existe");
					return true;
				}

				if (isInt(Args[2])) {
					int n = Integer.parseInt(Args[2]);
					for (Entity e : p.getNearbyEntities(n, n, n)) {
						if (e instanceof Player) {
							Player p2 = (Player) e;
							p2.getInventory().setArmorContents(this.armor.get(nome));
							p2.getInventory().setContents(this.itens.get(nome));
						}
					}

					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(OutfitPvP.prefix + " §f» §7O Kit §e" + nome
							+ " §7foi aplicado em um raio de §e" + n + " §ablocos");
					Bukkit.getServer().broadcastMessage("");
					p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você aplicou o kit §e" + nome
							+ " §7em um raio de §e" + n + " §7blocos");
					return true;
				}
			}
		}

		return false;
	}
}
