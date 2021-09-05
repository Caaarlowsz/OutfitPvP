package Outfit.PvP.Commands;

import Outfit.PvP.Main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadCommand implements CommandExecutor, Listener {
   Main main;

   public HeadCommand(Main plugin) {
      plugin = this.main;
   }

   public HeadCommand() {
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (!(sender instanceof Player)) {
         sender.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cApenas jogadores podem usar isso.");
         return true;
      } else {
         if (sender instanceof Player) {
            Player p = (Player)sender;
            if (args.length == 0) {
               p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /head [Jogador(a)]");
            }

            if (args.length != 0 && args.length == 1) {
               if (p.hasPermission("zey.pvp.head")) {
                  ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
                  skullItem.setDurability((short)3);
                  SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
                  skullMeta.setOwner(args[0]);
                  skullItem.setItemMeta(skullMeta);
                  p.getInventory().addItem(new ItemStack[]{skullItem});
                  p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §aHead adicionada ao seu inventario.");
               } else {
                  p.sendMessage("§cVocê não tem permissão para isso.");
               }
            }
         }

         return false;
      }
   }
}
