package Outfit.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Utils.Proteção;

public class Lava implements Listener, CommandExecutor {
	public static OutfitPvP plugin;

	public Lava(OutfitPvP main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("challenge")) {
			Player p = (Player) sender;
			p.setFlying(false);
			p.setAllowFlight(false);
			p.setGameMode(GameMode.SURVIVAL);
			World w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("lava.world"));
			double x = OutfitPvP.instance.getConfig().getDouble("lava.x");
			double y = OutfitPvP.instance.getConfig().getDouble("lava.y");
			double z = OutfitPvP.instance.getConfig().getDouble("lava.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("lava.pitch"));
			lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("lava.yaw"));
			p.getInventory().clear();
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aTeleportado com sucesso");
			TheTitle.sendTitle(p, "§d§lCHALLENGE");
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
			Habilidade.setAbility(p, "Warp");
			KitAPI.removeAbility(p);
			BuildCommand.embuild.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			Proteção.setImortal(p, true);
			Proteção.isImortal(p);
			if (WarpAPI.getWarp(p) != "Challenge") {
				MenuWarps.RemoveWarp(p);
				WarpAPI.setWarp(p, "Challenge");
				MenuWarps.AddWarp(p);
			}

			p.getInventory().setBoots(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setHelmet(null);
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
			p.teleport(lobby);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
