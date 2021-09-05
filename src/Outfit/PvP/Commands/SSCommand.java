package Outfit.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import Outfit.PvP.APIs.TagsAPI;
import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.Score.SPlayer;
import Outfit.PvP.Utils.Proteção;
import ca.wacos.nametagedit.NametagAPI;
import hi.Reaction.BossBar.BossBarAPI;


public class SSCommand implements CommandExecutor, Listener {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ss")) {
			if (!(sender.hasPermission("zey.pvp.ss"))) {
				sender.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				String ss = args[0];
				Player target = Bukkit.getPlayerExact(args[1]);
				if(ss.equalsIgnoreCase("puxar")) {
					
	                if (target == null) {
	                    p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
	                    return true;
	                }
	                
                    final World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("ss.world"));
                    final double x = Main.instance.getConfig().getDouble("ss.x");
                    final double y = Main.instance.getConfig().getDouble("ss.y");
                    final double z = Main.instance.getConfig().getDouble("ss.z");
                    final Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)Main.instance.getConfig().getDouble("ss.pitch"));
                    lobby.setYaw((float)Main.instance.getConfig().getDouble("ss.yaw"));
                    target.teleport(lobby);

                	if (p.hasPermission("zey.pvp.admin") &&  	
        					Outfit.PvP.APIs.WarpAPI.getWarp(p) == "Nenhuma") {
    					Main.admins.remove(p.getName());
    					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você saiu do modo §c§lADMIN");
    					
    					for (Player players : Bukkit.getOnlinePlayers()) {
    						players.showPlayer(p);
    					}
                	}
                	
                    TheTitle.sendTitle(target, "§d§lSCREENSHARE");
                    TheTitle.sendSubTitle(target, "§7Siga todas as ordens ditas pelo staffer: §d" + p.getName());
					
                    MenuWarps.RemoveWarp(target);
                    KitAPI.remove(target);
			        Habilidade.removeAbility(target);
			        KitAPI.removeAbility(target);
			        
			        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstace(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                        p.teleport(lobby);
                        
        			    Outfit.PvP.APIs.WarpAPI.setWarp(target, "SCREENSHARE");
        			    Outfit.PvP.APIs.WarpAPI.setWarp(p, "SS-CHECK");
        			    
                        TheTitle.sendTitle(p, "§d§lSCREENSHARE");
                        TheTitle.sendSubTitle(p, "§7Voce puxou o jogador: §d" + target.getName());
        			    
                        }
                    }, 8L);
			        
			        target.getInventory().setBoots((ItemStack)null);
			        target.getInventory().setChestplate((ItemStack)null);
			        target.getInventory().setLeggings((ItemStack)null);
			        target.getInventory().setHelmet((ItemStack)null);
			        target.getInventory().clear();
			        
			        p.getInventory().setBoots((ItemStack)null);
			        p.getInventory().setChestplate((ItemStack)null);
			        p.getInventory().setLeggings((ItemStack)null);
			        p.getInventory().setHelmet((ItemStack)null);
			        p.getInventory().clear();
            		
			        target.setExp(0.0f);
			        target.setHealthScale(20.0);
			        target.setExhaustion(20.0f);
			        target.setFireTicks(0);
			        target.setFoodLevel(20000);
			        target.setHealth(20.0);
			        
			        p.setGameMode(GameMode.SURVIVAL);
			        BuildCommand.embuild.remove(p);
			        
			        Proteção.setImortal(target, true);
            		Proteção.isImortal(target);
            		
    				TagsAPI.setarTag(target, "§c§lSS §7");
    				NametagAPI.setPrefix(target.getName(), "§c§lSS §7");
    				NametagAPI.setSuffix(target.getName(), " " + SPlayer.Rank(target));
    				
    				NametagAPI.setPrefix(p.getName(), "§c§lSTAFF §7");
    				NametagAPI.setSuffix(p.getName(), " " + SPlayer.Rank(p));
            		
                    BossBarAPI.setMessage(target, "§d§lSCREENSHARE §f- §c§lNAO DESLOGUE!");

					target.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVoce foi puxado para §c§lSCREENSHARE§c!");
					Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §7O jogador(a): §d" + target.getName() + " §7foi §c§lPUXADO§7 para §d§lSCREENSHARE §7pelo staffer §d" + p.getName() + "§7!");
					return true;
				}
				
					if(ss.equalsIgnoreCase("liberar")) {	
						
		            if (target == null) {
		                p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cEste jogador(a) está offline ou não existe.");
		                return true;
		            }	
						
		            TagsAPI.SetarTag(target);
		            TagsAPI.SetarTag(p);
		            
					target.performCommand("spawn");
					p.performCommand("spawn");
					
				    BossBarAPI.removeBar(target);
				    target.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aVoce foi liberado do §a§lSCREENSHARE§a!");
					Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §8➸ §7O jogador(a): §d" + target.getName() + " §7foi §a§lLIBERADO§7 do §d§lSCREENSHARE §7pelo staffer §d" + p.getName() + "§7!");		
					return true;
					}
				} else {
					p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /ss [Puxar | Liberar] [Jogador(a)]");
					return true;
				}
		}
		return false;
	}
	
	@EventHandler
    public void onCommandSS(PlayerCommandPreprocessEvent event)
	 {
	    Player p = event.getPlayer();
	    if(Outfit.PvP.APIs.WarpAPI.getWarp(p) == "SCREENSHARE" && (
	      (event.getMessage().toLowerCase().startsWith("/"))))
	    {
	      event.setCancelled(true);
	      p.sendMessage(String.valueOf(Main.prefix) + (" §8➸ §cVoce nao pode usar comandos no §c§lSCREENSHARE§c!"));
	    }
	 }
	
    @EventHandler
    public void onPlayerMoveSS(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if(Outfit.PvP.APIs.WarpAPI.getWarp(player) == "SCREENSHARE") {
            event.setTo(player.getLocation());
        }
    }
    
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
    public void onChatSS(AsyncPlayerChatEvent event) {
	final Player p = event.getPlayer();
	
	if (Outfit.PvP.APIs.WarpAPI.getWarp(p) == "SCREENSHARE" || Outfit.PvP.APIs.WarpAPI.getWarp(p) == "SS-CHECK") {
	
    for (Player s : Bukkit.getOnlinePlayers()) {
    	if (Outfit.PvP.APIs.WarpAPI.getWarp(s) == "SCREENSHARE" || Outfit.PvP.APIs.WarpAPI.getWarp(s) == "SS-CHECK") {
			s.sendMessage("§8[§d§lSS-CHAT§8] " + p.getDisplayName() + " §d➸ §f" + event.getMessage().replace("%", " Porcento(s)"));
			event.setCancelled(true);
    	}
			}
        }
    }
}