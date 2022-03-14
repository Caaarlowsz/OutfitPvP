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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class TheMain implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public TheMain(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("main")) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("themain.world"));
			double x = plugin.getConfig().getDouble("themain.x");
			double y = plugin.getConfig().getDouble("themain.y");
			double z = plugin.getConfig().getDouble("themain.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("themain.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("themain.yaw"));
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
			p.setAllowFlight(false);
			p.setFlying(false);
			TheTitle.sendTitle(p, "§d§lMAIN");
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

			Habilidade.setAbility(p, "Warp");
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			if (WarpAPI.getWarp(p) != "Main") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "Main");
				MenuWarps.AddWarp(p);
			}

			Proteção.setImortal(p, false);
			Proteção.isImortal(p);
			KitUtil.darFullIron(p);
			p.setHealthScale(20.0D);
			ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
			espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().setItem(0, espada);
			p.setFireTicks(0);
			ItemStack sopas = new ItemStack(Material.BOWL, 64);
			ItemMeta ksopas = sopas.getItemMeta();
			sopas.setItemMeta(ksopas);
			ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
			ItemMeta kcogur = cogur.getItemMeta();
			cogur.setItemMeta(kcogur);
			ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
			ItemMeta kcogum = cogum.getItemMeta();
			cogum.setItemMeta(kcogum);
			p.getInventory().setItem(13, sopas);
			p.getInventory().setItem(14, cogur);
			p.getInventory().setItem(15, cogum);
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));

			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}

			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
		}

		return false;
	}
}
