package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MacroTestCommand implements Listener, CommandExecutor {
   static final HashMap<String, Integer> Clicks = new HashMap<String, Integer>();
   static final ArrayList<String> macro = new ArrayList<String>();

   public static void testeMAcro(final Player p, final Player t) {
      p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §e§lMACROTEST: §7Testando no jogador(a): §e" + t.getName());
      macro.add(t.getName());
      Clicks.put(t.getName(), 0);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
         public void run() {
            p.sendMessage("§c ");
            p.sendMessage("                 §e§lMACROTEST              ");
            p.sendMessage("§e» §bJogador: §7" + t.getName());
            p.sendMessage("§e» §bTotal De Clicks: §7" + MacroTestCommand.Clicks.get(t.getName()));
            p.sendMessage("§e» §bClicks 5s: §7" + (Integer)MacroTestCommand.Clicks.get(t.getName()) / 2);
            p.sendMessage("§e» §bClicks 1s: §7" + (Integer)MacroTestCommand.Clicks.get(t.getName()) / 10);
            p.sendMessage("§c ");
            MacroTestCommand.macro.remove(t.getName());
            if ((Integer)MacroTestCommand.Clicks.get(t.getName()) >= 350) {
               Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + "1 semana [AutoBan] Uso de Macro/AutoClicker");
            }

         }
      }, 200L);
   }

   @EventHandler
   public void macro(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if (macro.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)) {
         Clicks.put(p.getName(), (Integer)Clicks.get(p.getName()) + 1);
      }

   }

   public final boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
      Player p = (Player)Sender;
      if (p.hasPermission("zey.pvp.testmacro")) {
         if (Args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /testmacro [Jogador(a)]");
            return true;
         }

         Player t = Bukkit.getPlayer(Args[0]);
         if (t != null) {
            testeMAcro(p, t);
         }
      }

      return false;
   }
}
