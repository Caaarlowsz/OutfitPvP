package Outfit.PvP.Commands;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Utils.Proteção;
import net.minecraft.util.com.google.common.collect.Maps;

public class AdminCommand implements CommandExecutor {

	public OutfitPvP main;
	public Map<String, ItemStack[]> inv = Maps.newHashMap();
	public Map<String, ItemStack[]> armor = Maps.newHashMap();

	public AdminCommand(OutfitPvP main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(OutfitPvP.prefix + " §8➸ §cApenas jogadores podem usar isso.");
			return true;
		}

		Player p = (Player) sender;

		if (label.equalsIgnoreCase("admin")) {
			if (p.hasPermission("zey.pvp.admin")) {
				if (!OutfitPvP.admins.contains(p.getName())) {
					OutfitPvP.admins.add(p.getName());

					for (Player players : Bukkit.getOnlinePlayers()) {
						if (!players.hasPermission("zey.pvp.admin.ver")) {
							players.hidePlayer(p);
						}
					}

					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					KitAPI.removeAbility(p);

					Outfit.PvP.APIs.WarpAPI.setWarp(p, "Nenhuma");

					p.getInventory().setBoots(null);
					p.getInventory().setChestplate(null);
					p.getInventory().setLeggings(null);
					p.getInventory().setHelmet(null);
					p.getInventory().clear();

					p.setExp(0.0f);
					p.setHealthScale(20.0);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					p.setFoodLevel(20000);
					p.setHealth(20.0);

					p.setGameMode(GameMode.CREATIVE);
					BuildCommand.embuild.add(p);

					Proteção.setImortal(p, false);
					Proteção.isImortal(p);

					p.getInventory().clear();
					p.getInventory().setArmorContents(null);

					ItemStack c = new ItemStack(Material.PAPER);
					ItemMeta cm = c.getItemMeta();
					cm.setDisplayName("§cInformações §7(Clique No Player)");
					c.setItemMeta(cm);

					ItemStack a = new ItemStack(Material.BEDROCK);
					ItemMeta am = a.getItemMeta();
					am.setDisplayName("§cSS §7(Clique No Player)");
					a.setItemMeta(am);

					ItemStack f = new ItemStack(Material.SLIME_BALL);
					ItemMeta fm = f.getItemMeta();
					fm.setDisplayName("§cTroca-Rapida §7(Clique)");
					f.setItemMeta(fm);

					ItemStack k = new ItemStack(Material.STICK);
					ItemMeta km = k.getItemMeta();
					km.setDisplayName("§cKnock-Back §7(Bata No Player)");
					km.addEnchant(Enchantment.KNOCKBACK, 10, true);
					k.setItemMeta(km);

					ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta sm = s.getItemMeta();
					sm.setDisplayName("§cEspada-PvP §7(Bata No Player)");
					sm.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
					s.setItemMeta(sm);

					p.getInventory().setItem(8, c);
					p.getInventory().setItem(3, a);
					p.getInventory().setItem(4, f);
					p.getInventory().setItem(5, k);
					p.getInventory().setItem(0, s);

					p.updateInventory();

					p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você entrou no modo §a§lADMIN");

				} else {
					OutfitPvP.admins.remove(p.getName());

					for (Player players : Bukkit.getOnlinePlayers()) {
						players.showPlayer(p);
					}

					p.getInventory().clear();

					Proteção.setImortal(p, false);
					Proteção.isImortal(p);

					p.setGameMode(GameMode.SURVIVAL);
					Outfit.PvP.APIs.WarpAPI.setWarp(p, "Nenhuma");

					p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você saiu do modo §c§lADMIN");
					BuildCommand.embuild.remove(p);
				}
			}
		}
		return false;
	}
}
