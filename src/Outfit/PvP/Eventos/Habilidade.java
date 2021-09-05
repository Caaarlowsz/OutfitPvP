package Outfit.PvP.Eventos;

import Outfit.PvP.Main.Main;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Habilidade implements Listener {
   public static Map<String, String> powerMap = new HashMap<String, String>();

   public Habilidade(Main main) {
   }

   public static String NomeDoKit(String original) {
      return original.length() == 0 ? original : String.valueOf(original.substring(0, 1).toUpperCase()) + original.substring(1);
   }

   public static String getAbility(Player player) {
      if (!powerMap.containsKey(player.getName())) {
         powerMap.put(player.getName(), "Nenhum");
      }

      return (String)powerMap.get(player.getName());
   }

   public static void setAbility(Player player, String ability) {
      powerMap.put(player.getName(), ability);
   }

   public static void removeAbility(Player p) {
      powerMap.remove(p.getName());
   }

   public static void strikeLightning(Entity p) {
      Location coords = p.getLocation();
      coords.getWorld().strikeLightningEffect(coords);
      Block block = coords.getBlock();
      block.setType(Material.AIR);
   }
}
