package Outfit.PvP.Sumo;


import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Utils.Proteção;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

public class CmdsSpeedSumo
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if ((SpeedSumo.Partida1) && (cmd.getName().equalsIgnoreCase("speedsumo")) && (Habilidade.getAbility(p) == "Sumo"))
    {
      if (args.length == 0) {
        return true;
      }
      if (args.length == 1)
      {
        final Player Player2 = Bukkit.getPlayerExact(args[0]);
        if ((Player2 instanceof Player))
        {
          EventsSumo.JogandoSumoPlayer.add(p);
          EventsSumo.JogandoSumoPlayer.add(Player2);
          EventsSumo.JogandoSair.put(p.getName(), Player2.getName());
          EventsSumo.JogandoSair.put(Player2.getName(), p.getName());
          EventsSumo.congelar.add(p);
          EventsSumo.congelar.add(Player2);
          SpeedSumo.NeginhoSegundos.remove(Player2);
          SpeedSumo.NeginhoSegundos.remove(p);
          if (SpeedSumo.Iniciou.contains(p))
          {
            SpeedSumo.Iniciou.remove(p);
            SpeedSumo.Partida1 = false;
          }
          if (SpeedSumo.Iniciou.contains(Player2))
          {
            SpeedSumo.Iniciou.remove(Player2);
            SpeedSumo.Partida1 = false;
          }
          World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("s2.world"));
          double x = Main.instance.getConfig().getDouble("s2.x");
          double y = Main.instance.getConfig().getDouble("s2.y");
          double z = Main.instance.getConfig().getDouble("s2.z");
          Location s2 = new Location(w, x, y, z);
          s2.setPitch((float)Main.instance.getConfig().getDouble("s2.pitch"));
          s2.setYaw((float)Main.instance.getConfig().getDouble("s2.yaw"));
          Player2.teleport(s2);
          World a = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("s1.world"));
          double b = Main.instance.getConfig().getDouble("s1.x");
          double c = Main.instance.getConfig().getDouble("s1.y");
          double d = Main.instance.getConfig().getDouble("s1.z");
          Location s1 = new Location(a, b, c, d);
          s1.setPitch((float)Main.instance.getConfig().getDouble("s1.pitch"));
          s1.setYaw((float)Main.instance.getConfig().getDouble("s1.yaw"));
          p.teleport(s1);
          TheTitle.sendTitle(Player2, " ");
          TheTitle.sendSubTitle(Player2, "§d" + Player2.getName() + " §7vs§d " + p.getName());
          TheTitle.sendTitle(p, " ");
          TheTitle.sendSubTitle(p, "§d" + p.getName() + " §7vs§d " + Player2.getName());
          EventsSumo.ChamouDuelo.remove(Player2);
          EventsSumo.AceitarDuelo.remove(Player2);
          EventsSumo.ChamouDuelo.remove(p);
          EventsSumo.AceitarDuelo.remove(p);
          p.getInventory().clear();
          Player2.getInventory().clear();
          p.updateInventory();
          Player2.updateInventory();
          EventsSumo.inPvP.add(p);
          EventsSumo.inPvP.add(Player2);
          Proteção.setImortal(Player2, false);
          Proteção.setImortal(p, false);
          
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              Player[] arrayOfPlayer;
              int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
              for (int i = 0; i < j; i++)
              {
                Player plr = arrayOfPlayer[i];
                Player2.hidePlayer(plr);
                p.hidePlayer(plr);
                p.showPlayer(Player2);
                Player2.showPlayer(p);
              }
            }
          }, 2L);
          
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run()
            {
              if (EventsSumo.congelar.contains(p))
              {
                p.setMaxHealth(20);
                p.setHealth(20);
                Player2.setMaxHealth(20);
                Player2.setHealth(20);
              }
            }
          }, 20L);
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run()
            {
              if (EventsSumo.congelar.contains(p))
              {
                p.setMaxHealth(20);
                p.setHealth(20);
                Player2.setMaxHealth(20);
                Player2.setHealth(20);
              }
            }
          }, 40L);
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run()
            {
              if (EventsSumo.congelar.contains(p))
              {
                p.setMaxHealth(20);
                p.setHealth(20);
                Player2.setMaxHealth(20);
                Player2.setHealth(20);
                EventsSumo.congelar.remove(p);
              }
            }
          }, 60L);
        }
      }
    }
    return false;
  }
}

