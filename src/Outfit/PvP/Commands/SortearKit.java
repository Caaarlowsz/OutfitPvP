package Outfit.PvP.Commands;

import Outfit.PvP.Essencial.HorarioAPI;
import Outfit.PvP.Essencial.ListKits;
import Outfit.PvP.Main.Main;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SortearKit implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender.hasPermission("zey.pvp.sortearkit")) {
         final ArrayList<String> Kit = new ArrayList<String>();
         ListKits[] var9;
         int var8 = (var9 = ListKits.values()).length;

         for(int var7 = 0; var7 < var8; ++var7) {
            ListKits s = var9[var7];
            if (!Kit.contains(s.name())) {
               Kit.add(s.name().toLowerCase());
            }
         }

         Bukkit.broadcastMessage("               §c(!) §e§lKitPvP §c(!)         ");
         Bukkit.broadcastMessage("");
         Bukkit.broadcastMessage("          §aEstamos iniciando um §7Sorteio§a!  ");
         Bukkit.broadcastMessage("           §aPrêmio Ao Vencedor: §7Um Kit Aleatório!       ");
         Bukkit.broadcastMessage("              §aHorário de Inicio: §7" + HorarioAPI.getHorario());
         Bukkit.broadcastMessage("");
         Bukkit.broadcastMessage("                 §c(!) §e§LSORTEIOS §c(!)            ");
         (new BukkitRunnable() {
            public void run() {
               ArrayList<Player> Players = new ArrayList<Player>();
               Player[] var5;
               @SuppressWarnings("deprecation")
			int x = (var5 = Bukkit.getOnlinePlayers()).length;

               Player all;
               for(int var3 = 0; var3 < x; ++var3) {
                  all = var5[var3];
                  if (!Players.contains(all)) {
                     Players.add(all);
                  }
               }

               all = (Player)Players.get((new Random()).nextInt(Players.size()));
               Bukkit.broadcastMessage("           §c(!) §e§lKitPvP §c(!) ");
               Bukkit.broadcastMessage("");
               Bukkit.broadcastMessage("       §aO Sorteio de §7Um kit§a Foi Finalizado!");
               Bukkit.broadcastMessage("       §aO Ganhador Foi: §7" + all.getName());
               Bukkit.broadcastMessage("     §aHorário de Término: §7" + HorarioAPI.getHorario());
               Random r = new Random();
               x = r.nextInt(Kit.size());
               Bukkit.broadcastMessage("         §aO Kit Ganho Foi: §7" + (String)Kit.get(x));
               Bukkit.broadcastMessage("");
               Bukkit.broadcastMessage("           §c(!) §e§LSORTEIOS §c(!)    ");
               Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + all.getName() + " add kit." + (String)Kit.get(x));
            }
         }).runTaskLater(Main.instance, 200L);
      }

      return false;
   }
}
