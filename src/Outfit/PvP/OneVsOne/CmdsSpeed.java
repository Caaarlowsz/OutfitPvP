package Outfit.PvP.OneVsOne;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Utils.Proteção;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class CmdsSpeed implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      final Player p = (Player)sender;
      if (Speed1v1.Partida1 && cmd.getName().equalsIgnoreCase("speed1v1") && Habilidade.getAbility(p) == "1v1") {
         if (args.length == 0) {
            return true;
         }

         if (args.length == 1) {
            final Player Player2 = Bukkit.getPlayerExact(args[0]);
            if (Player2 instanceof Player) {
               Events1v1.Jogando1v1Player.add(p);
               Events1v1.Jogando1v1Player.add(Player2);
               Events1v1.JogandoSair.put(p.getName(), Player2.getName());
               Events1v1.JogandoSair.put(Player2.getName(), p.getName());
               Events1v1.congelar.add(p);
               Events1v1.congelar.add(Player2);
               Speed1v1.NeginhoSegundos.remove(Player2);
               Speed1v1.NeginhoSegundos.remove(p);
               if (Speed1v1.Iniciou.contains(p)) {
                  Speed1v1.Iniciou.remove(p);
                  Speed1v1.Partida1 = false;
               }

               if (Speed1v1.Iniciou.contains(Player2)) {
                  Speed1v1.Iniciou.remove(Player2);
                  Speed1v1.Partida1 = false;
               }

               World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("loc2.world"));
               double x = Main.instance.getConfig().getDouble("loc2.x");
               double y = Main.instance.getConfig().getDouble("loc2.y");
               double z = Main.instance.getConfig().getDouble("loc2.z");
               Location loc2 = new Location(w, x, y, z);
               loc2.setPitch((float)Main.instance.getConfig().getDouble("loc2.pitch"));
               loc2.setYaw((float)Main.instance.getConfig().getDouble("loc2.yaw"));
               Player2.teleport(loc2);
               World a = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("loc1.world"));
               double b = Main.instance.getConfig().getDouble("loc1.x");
               double c = Main.instance.getConfig().getDouble("loc1.y");
               double d = Main.instance.getConfig().getDouble("loc1.z");
               Location loc1 = new Location(a, b, c, d);
               loc1.setPitch((float)Main.instance.getConfig().getDouble("loc1.pitch"));
               loc1.setYaw((float)Main.instance.getConfig().getDouble("loc1.yaw"));
               p.teleport(loc1);
               TheTitle.sendTitle(Player2, " ");
               TheTitle.sendSubTitle(Player2, "§d" + Player2.getName() + " §7vs§d " + p.getName());
               TheTitle.sendTitle(p, " ");
               TheTitle.sendSubTitle(p, "§d" + p.getName() + " §7vs§d " + Player2.getName());
               Events1v1.ChamouDuelo.remove(Player2);
               Events1v1.AceitarDuelo.remove(Player2);
               Events1v1.ChamouDuelo.remove(p);
               Events1v1.AceitarDuelo.remove(p);
               p.getInventory().clear();
               Player2.getInventory().clear();
               Events1v1.inPvP.add(p);
               Events1v1.inPvP.add(Player2);
               ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
               Espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
               ItemMeta Espada2 = Espada.getItemMeta();
               Espada2.setDisplayName("§5§oEspada");
               Espada.setItemMeta(Espada2);
               p.getInventory().addItem(new ItemStack[]{Espada});
               Player2.getInventory().addItem(new ItemStack[]{Espada});
               Player2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
               Player2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
               Player2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
               Player2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
               p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
               p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
               p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
               p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
               Proteção.setImortal(Player2, false);
               Proteção.setImortal(p, false);

               for(int i = 1; i < 9; ++i) {
                  ItemStack Fisherman = new ItemStack(Material.MUSHROOM_SOUP);
                  p.getInventory().addItem(new ItemStack[]{Fisherman});
                  Player2.getInventory().addItem(new ItemStack[]{Fisherman});
                  Player2.updateInventory();
                  p.updateInventory();

                  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                		public void run() {
                	        for (Player plr : Bukkit.getOnlinePlayers()) {
                	        Player2.hidePlayer(plr);
                	   p.hidePlayer(plr);
                	         p.showPlayer(Player2);
                	        Player2.showPlayer(p);
                	        }
                		}
                	},2L);	
                  
                  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                     public void run() {
                        if (Events1v1.congelar.contains(p)) {
                           p.setMaxHealth(20);
                           p.setHealth(20);
                           Player2.setMaxHealth(20);
                           Player2.setHealth(20);
                        }

                     }
                  }, 20L);
                  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                     public void run() {
                        if (Events1v1.congelar.contains(p)) {
                           p.setMaxHealth(20);
                           p.setHealth(20);
                           Player2.setMaxHealth(20);
                           Player2.setHealth(20);
                        }

                     }
                  }, 40L);
                  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                     public void run() {
                        if (Events1v1.congelar.contains(p)) {
                           p.setMaxHealth(20);
                           p.setHealth(20);
                           Player2.setMaxHealth(20);
                           Player2.setHealth(20);
                           Events1v1.congelar.remove(p);
                        }

                     }
                  }, 60L);
               }
            }
         }
      }

      return false;
   }
}
