package Outfit.PvP.Eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Config.Status;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Essencial.KitUtil;
import com.github.caaarlowsz.outfitmc.kitpvp.OutfitPvP;
import Outfit.PvP.Score.SPlayer;
import Outfit.PvP.Warps.Parkour;
import hi.Reaction.BossBar.BossBarAPI;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;

public class Geral implements Listener {
	@EventHandler
	public void onMe(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/me") || event.getMessage().toLowerCase().startsWith("/pl")
				|| event.getMessage().toLowerCase().startsWith("/plugins")
				|| event.getMessage().toLowerCase().startsWith("/ver")
				|| event.getMessage().toLowerCase().startsWith("/bukkit")
				|| event.getMessage().toLowerCase().startsWith("/help")
				|| event.getMessage().toLowerCase().startsWith("/version")
				|| event.getMessage().toLowerCase().startsWith("/about")
				|| event.getMessage().toLowerCase().startsWith("/?")) {
			event.setCancelled(true);
			p.sendMessage("§fPlugins (3): §aKomboPvP§f, §aKomboAPI§f, §aKomboUtils");
		}

	}

	@EventHandler
	public void onPlayerColor(SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}

		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}

		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}

		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}

	}

	@EventHandler
	public void Block(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/kill")
				|| event.getMessage().toLowerCase().startsWith("//calc")
				|| event.getMessage().toLowerCase().startsWith("//eval")
				|| event.getMessage().toLowerCase().startsWith("//evaluate")
				|| event.getMessage().toLowerCase().startsWith("//calculate")) {
			event.setCancelled(true);
			p.sendMessage(OutfitPvP.prefix + " §8➸ §cEsse comando nao foi encontrado.");
		}

	}

	@EventHandler
	public void Top(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/topkills")) {
			event.setCancelled(true);
			p.performCommand("pvpstats top kills");
		}

	}

	@EventHandler
	public void RemoveItems(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/remove")) {
			event.setCancelled(true);
			p.performCommand("remove items 999999999");
		}

	}

	@EventHandler
	public void Stats(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/stats")) {
			event.setCancelled(true);
			p.performCommand("status");
		}

	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (!e.isCancelled()) {
			if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				final Player hitter = (Player) e.getDamager();
				if (Habilidade.getAbility(p) == "Nenhum" || Habilidade.getAbility(hitter) == "Nenhum"
						|| WarpAPI.getWarp(p) == "Challenge" || WarpAPI.getWarp(hitter) == "Challenge") {
					return;
				}

				if (hitter.getGameMode() == GameMode.CREATIVE) {
					return;
				}

				if (WarpAPI.getWarp(p) == "Fps" || WarpAPI.getWarp(p) == "Main" || WarpAPI.getWarp(p) == "1v1"
						|| WarpAPI.getWarp(p) == "Potion" || WarpAPI.getWarp(p) == "Evento") {
					BossBarAPI.setMessage(hitter, "§fNick: §7" + p.getName() + " §fClan: " + SPlayer.ClanHIT(p));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
						public void run() {
							BossBarAPI.removeBar(hitter);
						}
					}, 60L);
				}

				if (WarpAPI.getWarp(p) == "Arena") {
					BossBarAPI.setMessage(hitter, "§fNick: §7" + p.getName() + " §fClan: §7" + SPlayer.ClanHIT(p)
							+ " §fKit: §7" + Habilidade.getAbility(p));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
						public void run() {
							BossBarAPI.removeBar(hitter);
						}
					}, 60L);
				}
			}

		}
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		e.setDeathMessage(null);
		final Player p = e.getEntity();
		if (p.getKiller() instanceof Player) {
			Player k = p.getKiller();
			Location l = k.getLocation();
			Location lp = p.getLocation();
			int mortes = OutfitPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
			OutfitPvP.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".mortes", mortes + 1);
			OutfitPvP.plugin.saveConfig();
			p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você foi morto por §c" + k.getName());
			k.sendMessage(OutfitPvP.prefix + " §8➸ §7Você adquiriu §d100 Dolls!");
			p.sendMessage(OutfitPvP.prefix + " §8➸ §7Você perdeu §c50 Dolls!");
			k.sendMessage(OutfitPvP.prefix + " §8➸ §7Você matou o jogador(a): §d" + p.getName());
			k.playSound(l, Sound.FIREWORK_LAUNCH, 10.0F, 1.0F);
			p.playSound(lp, Sound.ARROW_HIT, 10.0F, 1.0F);
			if (WarpAPI.getWarp(p) == "Fps" || WarpAPI.getWarp(p) == "Potion" || WarpAPI.getWarp(p) == "Main") {
				KitUtil.darFullIron(p.getKiller());
			}

			if (Status.getKs(p) >= 4) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7acabou com um §d§lKILLSTREAK §7de §d§l" + Status.getKs(p) + " §7do jogador: §d§l"
						+ p.getName());
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d250 Dolls §7por acabar com o §dKillStreak §7do openente!");
				ZeyCoins.addMoney(k, 250);
			}

			if (Status.getKs(k) == 4) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l5");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d500 Dolls §7por fazer um §dKillStreak §7de §d5§7!");
				ZeyCoins.addMoney(k, 500);
			}

			if (Status.getKs(k) == 9) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l10");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d1000 Dolls §7por fazer um §dKillStreak §7de §d10§7!");
				ZeyCoins.addMoney(k, 1000);
			}

			if (Status.getKs(k) == 14) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l15");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d1500 Dolls §7por fazer um §dKillStreak §7de §d15§7!");
				ZeyCoins.addMoney(k, 1500);
			}

			if (Status.getKs(k) == 19) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l20");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d2000 Dolls §7por fazer um §dKillStreak §7de §d20§7!");
				ZeyCoins.addMoney(k, 2000);
			}

			if (Status.getKs(k) == 24) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l25");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d2500 Dolls §7por fazer um §dKillStreak §7de §d25§7!");
				ZeyCoins.addMoney(k, 2500);
			}

			if (Status.getKs(k) == 29) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l30");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d3000 Dolls §7por fazer um §dKillStreak §7de §d30§7!");
				ZeyCoins.addMoney(k, 3000);
			}

			if (Status.getKs(k) == 34) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d" + k.getName()
						+ " §7está com um §dKILLSTREAK §7de §d§l35");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d3500 Dolls §7por fazer um §dKillStreak §7de §d35§7!");
				ZeyCoins.addMoney(k, 3500);
			}

			if (Status.getKs(k) == 39) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l40");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d4000 Dolls §7por fazer um §dKillStreak §7de §d40§7!");
				ZeyCoins.addMoney(k, 4000);
			}

			if (Status.getKs(k) == 44) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l45");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d4500 Dolls §7por fazer um §dKillStreak §7de §d45§7!");
				ZeyCoins.addMoney(k, 4500);
			}

			if (Status.getKs(k) == 49) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l50");
				k.sendMessage(OutfitPvP.prefix
						+ " §8➸ §7Você ganhou §d5000 Dolls §7por fazer um §dKillStreak §7de §d50§7!");
				ZeyCoins.addMoney(k, 5000);
			}

			if (Status.getKs(k) == 54) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l55");
			}

			if (Status.getKs(k) == 59) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d" + k.getName()
						+ " §7está com um §dKILLSTREAK §7de §d§l60");
			}

			if (Status.getKs(k) == 64) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d" + k.getName()
						+ " §7está com um §dKILLSTREAK §7de §d§l65");
			}

			if (Status.getKs(k) == 69) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l70");
			}

			if (Status.getKs(k) == 74) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l75");
			}

			if (Status.getKs(k) == 79) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l80");
			}

			if (Status.getKs(k) == 84) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l85");
			}

			if (Status.getKs(k) == 89) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l90");
			}

			if (Status.getKs(k) == 94) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7está com um §d§lKILLSTREAK §7de §d§l95");
			}

			if (Status.getKs(k) == 99) {
				Bukkit.broadcastMessage(OutfitPvP.prefix + " §8➸ §d§l" + k.getName()
						+ " §7alcançou o §d§lKILLSTREAK §7máximo de §d§l100§f!");
			}

			OutfitPvP.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".ks", 0);
			OutfitPvP.plugin.saveConfig();
		}

		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.plugin, new Runnable() {
			public void run() {
				double x;
				double y;
				double z;
				Location lobby;
				World w;
				if (WarpAPI.getWarp(p) == "Challenge") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("lava.world"));
					x = OutfitPvP.instance.getConfig().getDouble("lava.x");
					y = OutfitPvP.instance.getConfig().getDouble("lava.y");
					z = OutfitPvP.instance.getConfig().getDouble("lava.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("lava.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("lava.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Void") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("void.world"));
					x = OutfitPvP.instance.getConfig().getDouble("void.x");
					y = OutfitPvP.instance.getConfig().getDouble("void.y");
					z = OutfitPvP.instance.getConfig().getDouble("void.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("void.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("void.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Fps") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("fps.world"));
					x = OutfitPvP.instance.getConfig().getDouble("fps.x");
					y = OutfitPvP.instance.getConfig().getDouble("fps.y");
					z = OutfitPvP.instance.getConfig().getDouble("fps.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("fps.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("fps.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Main") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("themain.world"));
					x = OutfitPvP.instance.getConfig().getDouble("themain.x");
					y = OutfitPvP.instance.getConfig().getDouble("themain.y");
					z = OutfitPvP.instance.getConfig().getDouble("themain.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("themain.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("themain.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Knockback") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("kb.world"));
					x = OutfitPvP.instance.getConfig().getDouble("kb.x");
					y = OutfitPvP.instance.getConfig().getDouble("kb.y");
					z = OutfitPvP.instance.getConfig().getDouble("kb.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("kb.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("kb.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Fisherman") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("fish.world"));
					x = OutfitPvP.instance.getConfig().getDouble("fish.x");
					y = OutfitPvP.instance.getConfig().getDouble("fish.y");
					z = OutfitPvP.instance.getConfig().getDouble("fish.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("fish.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("fish.yaw"));
					p.teleport(lobby);
				} else if (WarpAPI.getWarp(p) == "Potion") {
					p.spigot().respawn();
					w = Bukkit.getServer().getWorld(OutfitPvP.instance.getConfig().getString("potion.world"));
					x = OutfitPvP.instance.getConfig().getDouble("potion.x");
					y = OutfitPvP.instance.getConfig().getDouble("potion.y");
					z = OutfitPvP.instance.getConfig().getDouble("potion.z");
					lobby = new Location(w, x, y, z);
					lobby.setPitch((float) OutfitPvP.instance.getConfig().getDouble("potion.pitch"));
					lobby.setYaw((float) OutfitPvP.instance.getConfig().getDouble("potion.yaw"));
					p.teleport(lobby);
				} else {
					e.getEntity().setFlying(false);
					e.getEntity().setAllowFlight(false);
					if (e.getEntity().isOnline()) {
						EntityPlayer ep = ((CraftPlayer) e.getEntity()).getHandle();
						ep.playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
					}

				}
			}
		}, 1L);
	}

	@EventHandler
	public void onVoidDeath(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location l = p.getLocation();
		if (WarpAPI.getWarp(p) != "Void") {
			if (l.getBlockY() <= 0) {
				p.setHealth(0);
			}

		}
	}

	@EventHandler
	public void onVoidTeleport(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location l = p.getLocation();
		World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
		double x = Parkour.plugin.getConfig().getDouble("parkour.x");
		double y = Parkour.plugin.getConfig().getDouble("parkour.y");
		double z = Parkour.plugin.getConfig().getDouble("parkour.z");
		Location lobby = new Location(w, x, y, z);
		lobby.setPitch((float) Parkour.plugin.getConfig().getDouble("parkour.pitch"));
		lobby.setYaw((float) Parkour.plugin.getConfig().getDouble("parkour.yaw"));
		if (l.getBlockY() <= 0 && WarpAPI.getWarp(p) == "Parkour") {
			p.setHealth(20.0D);
			p.teleport(lobby);
		}

	}

	@EventHandler
	public void onCreeperSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Creeper) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onSkeletonSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onSpiderSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Spider) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onWitchSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Witch) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onPSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Pig) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onWitherSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wither) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void nuncaChover(WeatherChangeEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler
	public void onZombieSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void aoPing(ServerListPingEvent e) {
		Random info = new Random();
		int Motd = info.nextInt(3);
		switch (Motd) {
		case 0:
			e.setMotd(OutfitPvP.motd);
			break;
		case 1:
			e.setMotd(OutfitPvP.motd2);
			break;
		case 2:
			e.setMotd(OutfitPvP.motd3);
		}

		if (Bukkit.hasWhitelist()) {
			e.setMotd(OutfitPvP.motd4);
		}

	}

	@EventHandler
	public void onCheio(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if (event.getResult() == Result.KICK_FULL) {
			if (p.hasPermission("zey.pvp.slotvip")) {
				event.setResult(Result.ALLOWED);
			} else {
				event.setKickMessage("§cDesculpe, o servidor está lotado.");
			}
		} else if (event.getResult() == Result.KICK_WHITELIST) {
			event.setKickMessage("\n \n §cEstamos em manutenção, para sua melhor jogabilidade, retorne em breve!");
		}

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void banAds(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("zey.pvp.falarsites") && (e.getMessage().contains(".net")
				|| e.getMessage().contains("Entre agora") || e.getMessage().contains("meu server")
				|| e.getMessage().contains("(.)") || e.getMessage().contains(".host")
				|| e.getMessage().contains(".minesv") || e.getMessage().contains(".playbr")
				|| e.getMessage().contains(".cookiehosting") || e.getMessage().contains(".playmine")
				|| e.getMessage().contains(".com") || e.getMessage().contains(".server")
				|| e.getMessage().contains(".me") || e.getMessage().contains(".io") || e.getMessage().contains(".com")
				|| e.getMessage().contains(".com.br") || e.getMessage().contains(".pro")
				|| e.getMessage().contains(".nu") || e.getMessage().contains(".tk") || e.getMessage().contains("(,)")
				|| e.getMessage().contains(",net") || e.getMessage().contains(",host")
				|| e.getMessage().contains(",minesv") || e.getMessage().contains(",playbr")
				|| e.getMessage().contains(",cookiehosting") || e.getMessage().contains(",playmine")
				|| e.getMessage().contains(",com") || e.getMessage().contains(",server")
				|| e.getMessage().contains(",me") || e.getMessage().contains(",io") || e.getMessage().contains(",com")
				|| e.getMessage().contains(",com.br") || e.getMessage().contains(",pro")
				|| e.getMessage().contains(",nu") || e.getMessage().contains(",tk"))) {
			e.setCancelled(true);
			p.sendMessage("§cNão divulgue servidores ou sites aqui, você será temporariamente banido.");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
					"tempban " + p.getName() + " 5 m [AutoBan] Divulgação de servidores ou links");
		}

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void banofensa(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("zey.pvp.falarmerda")
				&& (e.getMessage().contains("filho da puta") || e.getMessage().contains("vadia")
						|| e.getMessage().contains("sua mãe") || e.getMessage().contains("sua mae")
						|| e.getMessage().contains("aql puta") || e.getMessage().contains("seu lixo")
						|| e.getMessage().contains("vai se fuder") || e.getMessage().contains("puta"))) {
			e.setCancelled(true);
			p.sendMessage(
					"§cVocê usou alguns argumentos indevidos, contra jogadores(a) por isso, sera mutado temporariamente.");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
					"tempmute " + p.getName() + " 2 m [AutoMute] Uso de argumentos indevidos, contra Player.");
		}

	}

	@EventHandler
	public void onSlimeSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Slime) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onGhastSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ghast) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onPigZombieSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof PigZombie) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onEndermanSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Enderman) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onCaveSpiderSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof CaveSpider) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onSheepSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Sheep) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onCowSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onChickenSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Chicken) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onSquidSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Squid) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void clicarBussola(final PlayerInteractEvent e) {
		boolean parar = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
				if (entidades instanceof Player
						&& e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
					if (entidades.getLocation().getY() > 170.0) {
						return;
					}
					parar = true;
					e.getPlayer().setCompassTarget(entidades.getLocation());
					e.getPlayer().sendMessage(OutfitPvP.prefix
							+ " §8➸ §7Bússola apontando para o jogador(a): §d" + ((Player) entidades).getName());
					return;
				}
			}
			if (!parar) {
				e.getPlayer().sendMessage(OutfitPvP.prefix + " §8➸ §7Nenhum jogador(a) foi encontrado!");
				e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntity1(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player d = (Player) e.getDamager();
			if (d.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_SWORD
					|| d.getItemInHand().getType() == Material.GOLD_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.FISHING_ROD
					|| d.getItemInHand().getType() == Material.STONE_AXE || d.getItemInHand().getType() == Material.BOW
					|| d.getItemInHand().getType() == Material.IRON_SWORD
					|| d.getItemInHand().getType() == Material.DIAMOND_AXE) {
				d.getItemInHand().setDurability((short) 0);
				d.updateInventory();
			}
		}

	}

	@EventHandler
	public void noBreaking(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.FISHING_ROD
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			p.getItemInHand().setDurability((short) 0);
			p.updateInventory();
		}

	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
		if (e.getItemDrop().getItemStack().getType() == Material.LEATHER_CHESTPLATE) {
			e.setCancelled(false);
		}

		if (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) {
			e.setCancelled(false);
		}

		if (e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM) {
			e.setCancelled(false);
		}

		if (e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM) {
			e.setCancelled(false);
		}

		if (e.getItemDrop().getItemStack().getType() == Material.BOWL) {
			e.setCancelled(false);
		}

		if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void dropar(final ItemSpawnEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(OutfitPvP.getPlugin(), new Runnable() {
			public void run() {
				e.getEntity().remove();
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 1);
			}
		}, 20L);
	}

	@EventHandler
	public void entityDamagePedra(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_SWORD) {
				e.setDamage(e.getDamage() * 0.6D);
				return;
			}

			if (p.getItemInHand().getType() == Material.WOOD_SWORD) {
				e.setDamage(e.getDamage() * 0.5D);
				return;
			}

			if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				e.setDamage(e.getDamage() * 0.7D);
			}
		}

	}

	@EventHandler
	public void achivments(PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void nohunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
		event.setFoodLevel(20);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplosion(EntityExplodeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onUnknown(PlayerCommandPreprocessEvent event) {
		if (!event.isCancelled()) {
			Player p = event.getPlayer();
			String msg = event.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if (topic == null) {
				event.setCancelled(true);
				p.sendMessage(OutfitPvP.prefix + " §8➸ §cEsse comando nao foi encontrado!");
			}

		}
	}

	@EventHandler
	public void onSopa(final PlayerInteractEvent e) {
		final ItemStack pote = new ItemStack(Material.BOWL, 1);
		final ItemMeta kpote = pote.getItemMeta();
		kpote.setDisplayName("§dPote");
		pote.setItemMeta(kpote);
		final Damageable hp;
		final Player p = (Player) (hp = e.getPlayer());
		if (hp.getHealth() != 20.0) {
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + 7.0 > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0));
				if (!Habilidade.getAbility(p).equalsIgnoreCase("QuickDropper")) {
					p.getItemInHand().setItemMeta(kpote);
					p.getItemInHand().setType(Material.BOWL);
				} else {
					p.getItemInHand().setType(Material.BOWL);
					p.getPlayer().getInventory().remove(p.getItemInHand());
					p.getInventory().remove(new ItemStack(Material.BOWL, 1));
					p.getLocation().getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
					p.updateInventory();
				}
			}
		}
	}
}
