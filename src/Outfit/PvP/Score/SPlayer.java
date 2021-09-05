package Outfit.PvP.Score;

import Outfit.PvP.APIs.ClanAPI;
import Outfit.PvP.Account.Grupos;
import Outfit.PvP.Clan.Clan;
import Outfit.PvP.Config.ClanConfig;
import Outfit.PvP.Config.Status;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class SPlayer {
   private String player;
   private ScoreB sb;
   public static Main plugin;

   public static String Clan(Player p) {
      Clan clan = ClanAPI.getClanPlayer(p);
      return clan == null ? "§dNenhum" : ClanAPI.getClanPlayerString(p);
   }

   public static String ClanC(Player p) {
      Clan clan = ClanAPI.getClanPlayer(p);
      return clan == null ? "§8]" : " §8| §f" + ClanConfig.getConfig().getString(clan.getName() + ".Tag") + "§8]".replace("&", "§");
   }

   public static String ClanHIT(Player p) {
      Clan clan = ClanAPI.getClanPlayer(p);
      return clan == null ? "§7Nenhum" : "§8[§f" + ClanConfig.getConfig().getString(clan.getName() + ".Tag") + "§8]".replace("&", "§");
   }

   public static String ClanTag(Player p) {
      Clan clan = ClanAPI.getClanPlayer(p);
      return clan == null ? "§7Nenhum" : "§8[" + ClanConfig.getConfig().getString(clan.getName() + ".Tag") + "§8]".replace("&", "§");
   }

   public static String Rank(Player p) {
      double a = (double)Status.getKills(p);
      if (a <= 100.0D) {
         return "§8[§f-§8]";
      } else if (a <= 200.0D) {
         return ChatColor.GREEN + "§8[§a⚌§8]";
      } else if (a <= 300.0D) {
         return ChatColor.YELLOW + "§8[§e☰§8]";
      } else if (a <= 400.0D) {
         return "§8[§1✥§8]";
      } else if (a <= 500.0D) {
         return "§8[§7✯§8]";
      } else if (a <= 600.0D) {
         return "§8[§6✪§8]";
      } else if (a <= 700.0D) {
         return ChatColor.AQUA + "§8[§b❈§8]";
      } else if (a <= 800.0D) {
         return "§8[§2✸§8]";
      } else if (a <= 900.0D) {
         return ChatColor.RED + "§8[§c✹§8]";
      } else if (a <= 1000.0D) {
         return "§8[§3✷§8]";
      } else {
         return a <= 1500.0D ? "§8[§4✪§8]" : "§8[§4✪§8]";
      }
   }

   public static String RankC(Player p) {
      double a = (double)Status.getKills(p);
      if (a <= 100.0D) {
         return "§8[§f- §8| ";
      } else if (a <= 200.0D) {
         return ChatColor.GREEN + "§8[§a⚌ §8| ";
      } else if (a <= 300.0D) {
         return ChatColor.YELLOW + "§8[§e☰ §8| ";
      } else if (a <= 400.0D) {
         return "§8[§1✥ §8| ";
      } else if (a <= 500.0D) {
         return "§8[§7✯ §8| ";
      } else if (a <= 600.0D) {
         return "§8[§6✪ §8| ";
      } else if (a <= 700.0D) {
         return ChatColor.AQUA + "§8[§b❈ §8| ";
      } else if (a <= 800.0D) {
         return "§8[§2✸ §8| ";
      } else if (a <= 900.0D) {
         return ChatColor.RED + "§8[§c✹ §8| ";
      } else if (a <= 1000.0D) {
         return "§8[§3✷ §8| ";
      } else {
         return a <= 1500.0D ? "§8[§4✪ §8| " : "§8[§4✪ §8| ";
      }
   }

   public static String getRankConfig(Player p) {
      double a = (double)Status.getKills(p);
      if (a <= 100.0D) {
         return "§7Unranked";
      } else if (a <= 200.0D) {
         return "§aINICIANTE";
      } else if (a <= 300.0D) {
         return "§eAPRENDIZ";
      } else if (a <= 400.0D) {
         return "§1EXPERT";
      } else if (a <= 500.0D) {
         return "§7SILVER";
      } else if (a <= 600.0D) {
         return "§6GOLD";
      } else if (a <= 700.0D) {
         return "§bDIAMOND";
      } else if (a <= 800.0D) {
         return "§2EMERALD";
      } else if (a <= 900.0D) {
         return "§cRUBY";
      } else if (a <= 1000.0D) {
         return "§3SAFIRA";
      } else {
         return a <= 1500.0D ? "§4LENDARIO" : "§4LENDARIO";
      }
   }

   public static String getNomeRank(Player p) {
      double a = (double)Status.getKills(p);
      if (a <= 100.0D) {
         return "§7Unranked";
      } else if (a <= 200.0D) {
         return "§aINICIANTE";
      } else if (a <= 300.0D) {
         return "§eAPRENDIZ";
      } else if (a <= 400.0D) {
         return "§1EXPERT";
      } else if (a <= 500.0D) {
         return "§7SILVER";
      } else if (a <= 600.0D) {
         return "§6GOLD";
      } else if (a <= 700.0D) {
         return "§bDIAMOND";
      } else if (a <= 800.0D) {
         return "§2EMERALD";
      } else if (a <= 900.0D) {
         return "§CRUBY";
      } else if (a <= 1000.0D) {
         return "§3SAFIRA";
      } else {
         return a <= 1500.0D ? "§4LENDARIO" : "§4LENDARIO";
      }
   }

   public static String Liga(Player p) {
      double a = (double)Status.getKills(p);
      if (a <= 100.0D) {
         return "§7Unranked";
      } else if (a <= 200.0D) {
         return "§aINICIANTE";
      } else if (a <= 300.0D) {
         return "§eAPRENDIZ";
      } else if (a <= 400.0D) {
         return "§1EXPERT";
      } else if (a <= 500.0D) {
         return "§7SILVER";
      } else if (a <= 600.0D) {
         return "§6GOLD";
      } else if (a <= 700.0D) {
         return "§bDIAMOND";
      } else if (a <= 800.0D) {
         return "§2EMERALD";
      } else if (a <= 900.0D) {
         return "§cRUBY";
      } else if (a <= 1000.0D) {
         return "§3SAFIRA";
      } else {
         return a <= 1500.0D ? "§4LENDARIO" : "§4LENDARIO";
      }
   }

   public static String Marca(Player p) {
      double a = (double)ZeyCoins.getPlayerMoney(p);
      if (a <= 1000.0D) {
         return "§7Mendigo";
      } else if (a <= 2000.0D) {
         return "§3CAMELO";
      } else if (a <= 4000.0D) {
         return "§dADIDAS";
      } else if (a <= 8000.0D) {
         return "§9NIKE";
      } else if (a <= 16000.0D) {
         return "§5BAPE";
      } else if (a <= 32000.0D) {
         return "§eOFFWHITE";
      } else if (a <= 64000.0D) {
         return "§4SUPREME";
      } else if (a <= 128000.0D) {
         return "§2LACOSTE";
      } else if (a <= 256000.0D) {
         return "§6L-VUITTON";
      } else if (a <= 512000.0D) {
         return "§bROLEX";
      } else {
         return a <= 1000000.0D ? "§aGUCCI" : "§aGUCCI";
      }
   }

   public static String MarcaC(Player p) {
      double a = (double)ZeyCoins.getPlayerMoney(p);
      if (a <= 1000.0D) {
         return "§7Mendigo";
      } else if (a <= 2000.0D) {
         return "§3CAMELO";
      } else if (a <= 4000.0D) {
         return "§dADIDAS";
      } else if (a <= 8000.0D) {
         return "§9NIKE";
      } else if (a <= 16000.0D) {
         return "§5BAPE";
      } else if (a <= 32000.0D) {
         return "§eOFFWHITE";
      } else if (a <= 64000.0D) {
         return "§4SUPREME";
      } else if (a <= 128000.0D) {
         return "§2LACOSTE";
      } else if (a <= 256000.0D) {
         return "§6L-VUITTON";
      } else if (a <= 512000.0D) {
         return "§bROLEX";
      } else {
         return a <= 1000000.0D ? "§aGUCCI" : "§aGUCCI";
      }
   }

   public SPlayer(String player) {
      this.player = player;
      (this.sb = new ScoreB()).setSlot(DisplaySlot.SIDEBAR);
      this.sb.addLine(15, "§c ");
      this.sb.addLine(14, "§4» §fGrupo: ");
      this.sb.addLine(13, "§c» §fRank: ");
      this.sb.addLine(12, "§d» §fMarca: ");
      this.sb.addLine(11, "§f ");
      this.sb.addLine(10, "§5» §fMatou: ");
      this.sb.addLine(9, "§9» §fKillStreak: ");
      this.sb.addLine(8, "§3» §fMorreu: ");
      this.sb.addLine(7, "§c ");
      this.sb.addLine(6, "§b» §fDolls: §e");
      this.sb.addLine(5, "§a» §fClan: §e");
      this.sb.addLine(4, "§e» §fKit: ");
      this.sb.addLine(3, "§6» §fPlayers: ");
      this.sb.addLine(2, "§d ");
      this.sb.addLine(1, "§dkombopvp.com");
   }

   @SuppressWarnings("deprecation")
public synchronized void updateScoreboard() {
      if (!this.sb.hasBoard(this.getPlayer())) {
         this.sb.setForPlayer(this.getPlayer());
      }

      Player p = Bukkit.getPlayer(this.player);
      this.sb.setName(Main.bk.getText());
      this.sb.updateLine(14, "§fCargo §4» §f" + Grupos.getGrupos(p));
      this.sb.updateLine(10, "§fMatou §5» §a" + Status.getKills(p));
      this.sb.updateLine(8, "§fMorreu §3» §c" + Status.getDeaths(p));
      this.sb.updateLine(6, "§fDolls §b» §2$" + ZeyCoins.getPlayerMoney(p));
      this.sb.updateLine(5, "§fClan §a» §d" + Clan(p));
      this.sb.updateLine(4, "§fKit §e» §d" + Habilidade.getAbility(p));
      this.sb.updateLine(9, "§fKillStreak §9» §6" + Status.getKs(p));
      this.sb.updateLine(3, "§fJogadores §6» §7" + Bukkit.getOnlinePlayers().length);
      this.sb.updateLine(13, "§fRank §c» " + Liga(p));
      this.sb.updateLine(12, "§fMarca §d» " + Marca(p));
   }

   public Player getPlayer() {
      return Bukkit.getPlayer(this.player);
   }
}
