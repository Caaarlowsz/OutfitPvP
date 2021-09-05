package Outfit.PvP.Commands;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.APIs.WarpAPI;
import Outfit.PvP.Essencial.KitAPI;
import Outfit.PvP.Essencial.KitUtil;
import Outfit.PvP.Eventos.Habilidade;
import Outfit.PvP.Main.Main;
import Outfit.PvP.Utils.Proteção;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class KitCommand implements CommandExecutor, Listener {
   public KitCommand(Main main) {
   }

   @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player)sender;
      if (label.equalsIgnoreCase("kit")) {
         if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cErrado, utilize a sintaxe correta: /kit (kit)");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Nenhuma") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cNo momento, você está no /admin. Para pegar um kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Arena") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê já está utilizando um Kit. Para pegar outro, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Evento") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Textura") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Potion") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Fps") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Parkour") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }

         if (WarpAPI.getWarp(p) == "Main") {
            p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            return true;
         }
      }

      if (p.hasPermission("zey.pvp.admin") && WarpAPI.getWarp(p) == "Nenhuma") {
         Main.admins.remove(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ Você saiu do modo §c§lADMIN");
         Player[] var9;
         int var8 = (var9 = Bukkit.getOnlinePlayers()).length;

         for(int var7 = 0; var7 < var8; ++var7) {
            Player players = var9[var7];
            players.showPlayer(p);
         }
      }

      Proteção.setImortal(p, false);
      Proteção.isImortal(p);
      if (args[0].equalsIgnoreCase("pvp")) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.swordkitpvp(p);
         Habilidade.setAbility(p, "PvP");
         KitAPI.Kit.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lPVP");
         TheTitle.sendTitle(p, "§d§lPVP");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("ajnin") && (p.hasPermission("kit.ajnin") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Ajnin");
         KitAPI.Kit.add(p.getName());
         KitAPI.Ajnin.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lAJNIN");
         TheTitle.sendTitle(p, "§d§lAJNIN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("camel") && (p.hasPermission("kit.camel") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Camel");
         KitAPI.Kit.add(p.getName());
         KitAPI.Camel.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lCamel");
         TheTitle.sendTitle(p, "§d§lCAMEL");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("anchor") && (p.hasPermission("kit.anchor") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Anchor");
         KitAPI.Kit.add(p.getName());
         KitAPI.Anchor.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lANCHOR");
         TheTitle.sendTitle(p, "§d§lANCHOR");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("armor") && (p.hasPermission("kit.armor") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Armor");
         KitAPI.Kit.add(p.getName());
         KitAPI.Armor.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lARMOR");
         KitAPI.setitem(p, Material.GOLD_INGOT, "§d§lARMOR", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lARMOR");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("rain") && (p.hasPermission("kit.rain") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Rain");
         KitAPI.Kit.add(p.getName());
         KitAPI.Rain.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lRAIN");
         KitAPI.setitem(p, Material.ARROW, "§d§lRAIN", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lRAIN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("timelord") && (p.hasPermission("kit.timelord") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "TimeLord");
         KitAPI.Kit.add(p.getName());
         KitAPI.TimeLord.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lTIMELORD");
         KitAPI.setitem(p, Material.WATCH, "§d§lTIMELORD", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lTIMELORD");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("confuser") && (p.hasPermission("kit.confuser") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Confuser");
         KitAPI.Kit.add(p.getName());
         KitAPI.Confuser.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lCONFUSER");
         KitAPI.setitem(p, Material.COAL, "§d§lCONFUSER", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lCONFUSER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("avatar") && (p.hasPermission("kit.avatar") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Avatar");
         KitAPI.Kit.add(p.getName());
         KitAPI.Avatar.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lAVATAR");
         KitAPI.setitem(p, Material.BEACON, "§d§lAVATAR", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lAVATAR");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("flash") && (p.hasPermission("kit.flash") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Flash");
         KitAPI.Kit.add(p.getName());
         KitAPI.Flash.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lFLASH");
         KitAPI.setitem(p, Material.REDSTONE_TORCH_ON, "§d§lFLASH", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lFLASH");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("C4") && (p.hasPermission("kit.C4") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "C4");
         KitAPI.Kit.add(p.getName());
         KitAPI.C4.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lC4");
         KitAPI.setitem(p, Material.SLIME_BALL, "§d§lC4", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lC4");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("DeshFire") && (p.hasPermission("kit.deshfire") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "DeshFire");
         KitAPI.Kit.add(p.getName());
         KitAPI.DeshFire.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lDESHFIRE");
         KitAPI.setitem(p, Material.REDSTONE_BLOCK, "§d§lDESHFIRE", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lDESHFIRE");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("fisherman") && (p.hasPermission("kit.fisherman") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Fisherman");
         KitAPI.Kit.add(p.getName());
         KitAPI.Fisherman.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lFISHERMAN");
         KitAPI.setitem(p, Material.FISHING_ROD, "§d§lFISHERMAN", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lFISHERMAN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("gladiator") && (p.hasPermission("kit.gladiator") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Gladiator");
         KitAPI.Kit.add(p.getName());
         KitAPI.Gladiator.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lGLADIATOR");
         KitAPI.setitem(p, Material.IRON_FENCE, "§d§lGLADIATOR", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lGLADIATOR");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("grappler") && (p.hasPermission("kit.grappler") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Grappler");
         KitAPI.Kit.add(p.getName());
         KitAPI.Grappler.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lGRAPPLER");
         KitAPI.setitem(p, Material.LEASH, "§d§lGRAPPLER", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lGRAPPLER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("hulk") && (p.hasPermission("kit.hulk") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Hulk");
         KitAPI.Kit.add(p.getName());
         KitAPI.Hulk.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lHULK");
         KitAPI.setitem(p, Material.SADDLE, "§d§lHULK", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lHULK");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("jellyfish") && (p.hasPermission("kit.jellyfish") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "JellyFish");
         KitAPI.Kit.add(p.getName());
         KitAPI.JellyFish.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lJELLYFISH");
         KitAPI.setitem(p, Material.CLAY_BALL, "§d§lJELLYFISH", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lJELLYFISH");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("quickdropper") && (p.hasPermission("kit.quickdropper") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "QuickDropper");
         KitAPI.Kit.add(p.getName());
         KitAPI.QuickDropper.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lQUICKDROPPER");
         TheTitle.sendTitle(p, "§d§lQUICKDROPPER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("kangaroo") && (p.hasPermission("kit.kangaroo") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Kangaroo");
         KitAPI.Kit.add(p.getName());
         KitAPI.Kangaroo.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lKANGAROO");
         KitUtil.darItem(p, Material.FIREWORK, 1, "§d§lKANGAROO", 1);
         TheTitle.sendTitle(p, "§d§lKANGAROO");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("magma") && (p.hasPermission("kit.magma") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Magma");
         KitAPI.Kit.add(p.getName());
         KitAPI.Magma.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lMAGMA");
         TheTitle.sendTitle(p, "§d§lMAGMA");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("monk") && (p.hasPermission("kit.monk") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Monk");
         KitAPI.Kit.add(p.getName());
         KitAPI.Monk.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lMONK");
         KitAPI.setitem(p, Material.BLAZE_ROD, "§d§lMONK", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lMONK");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("minigun") && (p.hasPermission("kit.minigun") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "MiniGun");
         KitAPI.Kit.add(p.getName());
         KitAPI.MiniGun.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lMINIGUN");
         KitAPI.setitem(p, Material.ARROW, "§d§lMINIGUN", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lMINIGUN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("phantom") && (p.hasPermission("kit.phantom") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Phantom");
         KitAPI.Kit.add(p.getName());
         KitAPI.Phantom.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lPHANTOM");
         KitAPI.setitem(p, Material.FEATHER, "§d§lPHANTOM", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lPHANTOM");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("ninja") && (p.hasPermission("kit.ninja") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Ninja");
         KitAPI.Kit.add(p.getName());
         KitAPI.Ninja.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lNINJA");
         TheTitle.sendTitle(p, "§d§lNINJA");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("poseidon") && (p.hasPermission("kit.poseidon") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Poseidon");
         KitAPI.Kit.add(p.getName());
         KitAPI.Poseidon.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lPOSEIDON");
         TheTitle.sendTitle(p, "§d§lPOSEIDON");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("resouper") && (p.hasPermission("kit.resouper") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Resouper");
         KitAPI.Kit.add(p.getName());
         KitAPI.Resouper.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lRESOUPER");
         TheTitle.sendTitle(p, "§d§lRESOUPER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("snail") && (p.hasPermission("kit.snail") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Snail");
         KitAPI.Kit.add(p.getName());
         KitAPI.Snail.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSNAIL");
         TheTitle.sendTitle(p, "§d§lSNAIL");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("sonic") && (p.hasPermission("kit.sonic") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Sonic");
         KitAPI.Kit.add(p.getName());
         KitAPI.Sonic.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSONIC");
         KitAPI.setitem(p, Material.LAPIS_BLOCK, "§d§lSONIC", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lSONIC");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("archer") && (p.hasPermission("kit.archer") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Archer");
         KitAPI.Kit.add(p.getName());
         KitAPI.Archer.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lArcher");
         KitAPI.setitem(p, Material.BOW, "§d§lARCHER", 1, Enchantment.ARROW_INFINITE, 1, false);
         KitAPI.setitem(p, Material.ARROW, "§cFLECHA", 2, Enchantment.DAMAGE_ALL, 1, false);
         TheTitle.sendTitle(p, "§d§lARCHER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("stomper") && (p.hasPermission("kit.stomper") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Stomper");
         KitAPI.Kit.add(p.getName());
         KitAPI.Stomper.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSTOMPER");
         KitAPI.setitem(p, Material.GOLDEN_APPLE, "§d§lSTOMPER", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lSTOMPER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("switcher") && (p.hasPermission("kit.switcher") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Switcher");
         KitAPI.Kit.add(p.getName());
         KitAPI.Switcher.add(p.getName());
         KitUtil.darItem(p, Material.SNOW_BALL, 15, "§d§lSWITCHER", 1);
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSWITCHER");
         TheTitle.sendTitle(p, "§d§lSWITCHER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("swords") && (p.hasPermission("kit.swords") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Swords");
         KitAPI.Kit.add(p.getName());
         KitAPI.Swords.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSWORDS");
         TheTitle.sendTitle(p, "§d§lSWORDS");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("forcefield") && (p.hasPermission("kit.forcefield") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "ForceField");
         KitAPI.Kit.add(p.getName());
         KitAPI.ForceField.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lFORCEFIELD");
         KitAPI.setitem(p, Material.NETHER_FENCE, "§d§lFORCEFIELD", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lFORCEFIELD");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("thor") && (p.hasPermission("kit.thor") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Thor");
         KitAPI.Kit.add(p.getName());
         KitAPI.Thor.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lTHOR");
         KitAPI.setitem(p, Material.GOLD_AXE, "§d§lTHOR", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lTHOR");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("thresh") && (p.hasPermission("kit.thresh") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Thresh");
         KitAPI.Kit.add(p.getName());
         KitAPI.Thresh.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lTHRESH");
         KitAPI.setitem(p, Material.LEVER, "§d§lTHRESH", 1, Enchantment.DAMAGE_ALL, 0, false);
         TheTitle.sendTitle(p, "§d§lTHRESH");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("turtle") && (p.hasPermission("kit.turtle") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Turtle");
         KitAPI.Kit.add(p.getName());
         KitAPI.Turtle.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lTURTLE");
         TheTitle.sendTitle(p, "§d§lTURTLE");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("viper") && (p.hasPermission("kit.viper") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Viper");
         KitAPI.Kit.add(p.getName());
         KitAPI.Viper.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lVIPER");
         TheTitle.sendTitle(p, "§d§lVIPER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("viking") && (p.hasPermission("kit.Viking") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitUtil.darItem(p, Material.STONE_AXE, 1, "§d§lVIKING", 0);
         Habilidade.setAbility(p, "Viking");
         KitAPI.Kit.add(p.getName());
         KitAPI.Viking.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lVIKING");
         TheTitle.sendTitle(p, "§d§lVIKING");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
         p.setAllowFlight(false);
         p.setFlying(false);
      }

      if (args[0].equalsIgnoreCase("madman") && (p.hasPermission("kit.madman") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Madman");
         KitAPI.Kit.add(p.getName());
         KitAPI.AntiTower.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lMADMAN");
         TheTitle.sendTitle(p, "§d§lMADMAN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("specialist") && (p.hasPermission("kit.specialist") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Specialist");
         KitUtil.darItem(p, Material.ENCHANTED_BOOK, 1, "§d§lSPECIALIST", 1);
         KitAPI.Kit.add(p.getName());
         KitAPI.Specialist.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lSPECIALIST");
         TheTitle.sendTitle(p, "§d§lSPECIALIST");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("alladin") && (p.hasPermission("kit.alladin") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Alladin");
         KitUtil.darItem(p, Material.CARPET, 1, "§d§lALLADIN", 1);
         KitAPI.Kit.add(p.getName());
         KitAPI.Alladin.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lALLADIN");
         TheTitle.sendTitle(p, "§d§lALLADIN");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("ryu") && (p.hasPermission("kit.ryu") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "Ryu");
         KitUtil.darItem(p, Material.DIAMOND_BLOCK, 1, "§d§lRYU", 1);
         KitAPI.Kit.add(p.getName());
         KitAPI.Ryu.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lRYU");
         TheTitle.sendTitle(p, "§d§lRYU");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("hotpotato") && (p.hasPermission("kit.hotpotato") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "HotPotato");
         KitUtil.darItem(p, Material.POTATO, 1, "§d§lHOTPOTATO", 1);
         KitAPI.Kit.add(p.getName());
         KitAPI.Specialist.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lHOTPOTATO");
         TheTitle.sendTitle(p, "§d§lHOTPOTATO");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      if (args[0].equalsIgnoreCase("AntiTower") && (p.hasPermission("kit.antitower") || IniciarCommand.fullkit)) {
         p.getInventory().clear();
         KitAPI.recraft(p);
         KitAPI.sopa(p);
         KitAPI.sword(p);
         Habilidade.setAbility(p, "AntiTower");
         KitAPI.Kit.add(p.getName());
         KitAPI.AntiTower.add(p.getName());
         p.sendMessage(String.valueOf(Main.prefix) + " §8➸ §7Você selecionou o Kit: §d§lAntiTower");
         TheTitle.sendTitle(p, "§d§lANTI-TOWER");
         TheTitle.sendSubTitle(p, "§7Kit selecionado com sucesso!");
         SetArenaCommand.TeleportArenaRandom(p);
      }

      return false;
   }
}
