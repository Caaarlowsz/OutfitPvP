package Outfit.PvP.Sumo;


import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

public class SpeedSumo
  implements Listener
{
  public static boolean Partida1 = false;
  public static String Nome = "";
  public static List<Player> Iniciou = new ArrayList();
  public static List<Player> NeginhoSegundos = new ArrayList();
  public static HashMap<String, Player> Player2 = new HashMap();
  public static HashMap<String, Player> Player1 = new HashMap();
  
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((p.getItemInHand().equals(JoinSumo.CinzaS)) && ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      if (Partida1)
      {
        p.performCommand("speedsumo " + Nome);
        Nome = "";
        return;
      }
      if (!Partida1)
      {
        Nome = p.getName();
        Partida1 = true;
        Iniciou.add(p);
        Trocar(p);
        p.sendMessage(String.valueOf(Main.prefix) + " §8-> §aVoce entrou na fila para o sumo rapido.");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            SpeedSumo.NeginhoSegundos.add(p);
          }
        }, 2L);
      }
    }
  }
  
  public void Trocar(Player p)
  {
    if (Iniciou.contains(p))
    {
      p.getInventory().setItem(5, new ItemStack(JoinSumo.Verde1S));
      p.updateInventory();
    }
  }
  
  @EventHandler
  public void onInteract2(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((p.getItemInHand().equals(JoinSumo.Verde1S)) || (p.getItemInHand().equals(JoinSumo.Verde2S)) || (p.getItemInHand().equals(JoinSumo.Verde3S)))
    {
      if (((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) && (NeginhoSegundos.contains(p)))
      {
        Partida1 = false;
        Nome = "";
        Iniciou.remove(p);
        NeginhoSegundos.remove(p);
        p.sendMessage(String.valueOf(Main.prefix) + " §8-> §cVoce saiu da fila de sumo rápido.");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            p.getInventory().setItem(5, JoinSumo.CinzaS);
            p.updateInventory();
          }
        }, 1L);
        return;
      }
      if (!NeginhoSegundos.contains(p)) {}
    }
  }
}
