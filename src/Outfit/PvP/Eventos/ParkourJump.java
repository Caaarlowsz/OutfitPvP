package Outfit.PvP.Eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Config.ZeyCoins;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Warps.Parkour;

public class ParkourJump implements Listener {
	public static ArrayList<String> jump = new ArrayList<String>();
	ArrayList<String> nofalldamage = new ArrayList<String>();
	ArrayList<String> nofalldamagewait = new ArrayList<String>();

	public ParkourJump(OutfitPvP main) {
	}

	@EventHandler
	public void onPlayerJumpBaixo(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK
				&& WarpAPI.getWarp(p) == "Parkour") {
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0F, 5.0F);
			World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
			double x = Parkour.plugin.getConfig().getDouble("parkour.x");
			double y = Parkour.plugin.getConfig().getDouble("parkour.y");
			double z = Parkour.plugin.getConfig().getDouble("parkour.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) Parkour.plugin.getConfig().getDouble("parkour.pitch"));
			lobby.setYaw((float) Parkour.plugin.getConfig().getDouble("parkour.yaw"));
			p.teleport(lobby);
			p.setHealthScale(20.0D);
			ZeyCoins.addMoney(p, 25000);
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê terminou o Parkour");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §aVocê ganhou 25000 Dolls!");
		}

	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (this.nofalldamage.contains(player.getName()) && event.getCause().equals(DamageCause.FALL)) {
				event.setCancelled(true);
				this.nofalldamage.remove(player.getName());
			}
		}

	}
}
