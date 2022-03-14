package Outfit.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Outfit.PvP.Menus.MenuGeral1;
import Outfit.PvP.Menus.MenuKits;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Warps.Parkour;

public class Direito implements Listener {
	@EventHandler
	public void AbrirMenuGeral(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals(Material.HOPPER_MINECART)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dMenu §7(Clique)")
				&& Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
				MenuGeral1.guiKits(p);
			}
		}
	}

	@EventHandler
	public void AbrirMenuKits(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals(Material.STORAGE_MINECART)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dKits §7(Clique)")
				&& Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
				MenuKits.GuiKit(p);
			}
		}
	}

	@EventHandler
	public void AbrirMenuWarps(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals(Material.EXPLOSIVE_MINECART)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dWarps §7(Clique)")
				&& Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
				MenuWarps.guiKits(p);
			}
		}
	}

	@EventHandler
	public void Regras(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals(Material.PAPER)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dRegras §7(Clique)")
				&& Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
				p.chat("/regras");
			}
		}
	}

	@EventHandler
	public void ReiniciarParkour(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals(Material.REDSTONE)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")
				&& Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Parkour") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CLICK, 5.0f, 5.0f);
				final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
				final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
				final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
				final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
				final Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Parkour.plugin.getConfig().getDouble("parkour.pitch"));
				lobby.setYaw((float) Parkour.plugin.getConfig().getDouble("parkour.yaw"));
				p.teleport(lobby);
				p.setHealthScale(20.0);
			}
		}
	}
}
