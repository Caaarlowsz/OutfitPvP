package Outfit.PvP.Main;

import Outfit.PvP.APIs.TheTitle;
import Outfit.PvP.Cassino.ApostasListener;
import Outfit.PvP.Commands.AdminCommand;
import Outfit.PvP.Commands.AplicarCommand;
import Outfit.PvP.Commands.AutoSoupCommand;
import Outfit.PvP.Commands.BroadcastCommand;
import Outfit.PvP.Commands.BuildCommand;
import Outfit.PvP.Commands.CageCommand;
import Outfit.PvP.Commands.CcCommand;
import Outfit.PvP.Commands.ChatCommand;
import Outfit.PvP.Commands.ClanCommand;
import Outfit.PvP.Commands.ConfigCommand;
import Outfit.PvP.Commands.CrashAPI;
import Outfit.PvP.Commands.Crashar;
import Outfit.PvP.Commands.DarCoinsCommand;
import Outfit.PvP.Commands.DoarCommand;
import Outfit.PvP.Commands.FinalizarCommand;
import Outfit.PvP.Commands.FlyCommand;
import Outfit.PvP.Commands.GmCommand;
import Outfit.PvP.Commands.HeadCommand;
import Outfit.PvP.Commands.InfoCommand;
import Outfit.PvP.Commands.IniciarCommand;
import Outfit.PvP.Commands.InvCommand;
import Outfit.PvP.Commands.KitCommand;
import Outfit.PvP.Commands.LagCommand;
import Outfit.PvP.Commands.LigaCommand;
import Outfit.PvP.Commands.LimparTelaCommand;
import Outfit.PvP.Commands.MacroTestCommand;
import Outfit.PvP.Commands.MarcaCommand;
import Outfit.PvP.Commands.Morrer;
import Outfit.PvP.Commands.PvPCommand;
import Outfit.PvP.Commands.RecraftCommand;
import Outfit.PvP.Commands.ReflectionUtils;
import Outfit.PvP.Commands.Regras;
import Outfit.PvP.Commands.ReportCommand;
import Outfit.PvP.Commands.SCCommand;
import Outfit.PvP.Commands.SSCommand;
import Outfit.PvP.Commands.ScoreCommand;
import Outfit.PvP.Commands.SetArenaCommand;
import Outfit.PvP.Commands.SetGroupCommand;
import Outfit.PvP.Commands.SetVipCommand;
import Outfit.PvP.Commands.SortearKit;
import Outfit.PvP.Commands.SortearVip;
import Outfit.PvP.Commands.StatusCommand;
import Outfit.PvP.Commands.Sudo;
import Outfit.PvP.Commands.TagCommand;
import Outfit.PvP.Commands.TellCommand;
import Outfit.PvP.Commands.TpAllCommand;
import Outfit.PvP.Commands.TpAllEvento;
import Outfit.PvP.Commands.TpCommand;
import Outfit.PvP.Commands.TpHereCommand;
import Outfit.PvP.Commands.Vis;
import Outfit.PvP.Commands.YTCommand;
import Outfit.PvP.Commands.sKit;
import Outfit.PvP.Config.ClanConfig;
import Outfit.PvP.Config.ClanConfig2;
import Outfit.PvP.Config.MyConfigManager;
import Outfit.PvP.Config.Status;
import Outfit.PvP.Config.ZeyCoins;
import Outfit.PvP.DollsDay.XpDiario;
import Outfit.PvP.Essencial.API;
import Outfit.PvP.Essencial.Caixas;
import Outfit.PvP.Eventos.Admin;
import Outfit.PvP.Eventos.AntFlood;
import Outfit.PvP.Eventos.AntiBot;
import Outfit.PvP.Eventos.ChatForm;
import Outfit.PvP.Eventos.CombatLog;
import Outfit.PvP.Eventos.Direito;
import Outfit.PvP.Eventos.Entrar;
import Outfit.PvP.Eventos.GanharXP;
import Outfit.PvP.Eventos.Geral;
import Outfit.PvP.Eventos.Nerfs;
import Outfit.PvP.Eventos.ParkourJump;
import Outfit.PvP.Eventos.PlacaDaLava;
import Outfit.PvP.Eventos.PlacaDePotion;
import Outfit.PvP.Eventos.PlacaDeRecraft;
import Outfit.PvP.Eventos.PlacaDeSopa;
import Outfit.PvP.Eventos.TabPersonalizado;
import Outfit.PvP.JumpBlocks.Diamante;
import Outfit.PvP.JumpBlocks.EndPortal;
import Outfit.PvP.JumpBlocks.Esponja;
import Outfit.PvP.JumpBlocks.Ferro;
import Outfit.PvP.Kits.Ajnin;
import Outfit.PvP.Kits.Alladin;
import Outfit.PvP.Kits.Anchor;
import Outfit.PvP.Kits.AntiTower;
import Outfit.PvP.Kits.Armor;
import Outfit.PvP.Kits.Avatar;
import Outfit.PvP.Kits.C4;
import Outfit.PvP.Kits.Camel;
import Outfit.PvP.Kits.Confuser;
import Outfit.PvP.Kits.DeshFire;
import Outfit.PvP.Kits.Fisherman;
import Outfit.PvP.Kits.Flash;
import Outfit.PvP.Kits.Gladiator;
import Outfit.PvP.Kits.Grappler;
import Outfit.PvP.Kits.HotPotato;
import Outfit.PvP.Kits.Hulk;
import Outfit.PvP.Kits.JellyFish;
import Outfit.PvP.Kits.Kangaroo;
import Outfit.PvP.Kits.Madman;
import Outfit.PvP.Kits.Magma;
import Outfit.PvP.Kits.MiniGun;
import Outfit.PvP.Kits.Monk;
import Outfit.PvP.Kits.Ninja;
import Outfit.PvP.Kits.Phantom;
import Outfit.PvP.Kits.Poseidon;
import Outfit.PvP.Kits.QuickDropper;
import Outfit.PvP.Kits.Rain;
import Outfit.PvP.Kits.Resouper;
import Outfit.PvP.Kits.Ryu;
import Outfit.PvP.Kits.Snail;
import Outfit.PvP.Kits.Sonic;
import Outfit.PvP.Kits.Specialist;
import Outfit.PvP.Kits.Stomper;
import Outfit.PvP.Kits.Switcher;
import Outfit.PvP.Kits.Swords;
import Outfit.PvP.Kits.TheForceField;
import Outfit.PvP.Kits.Thor;
import Outfit.PvP.Kits.Thresh;
import Outfit.PvP.Kits.TimeLord;
import Outfit.PvP.Kits.Turtle;
import Outfit.PvP.Kits.Viking;
import Outfit.PvP.Kits.Viper;
import Outfit.PvP.Menus.MenuAdm;
import Outfit.PvP.Menus.MenuCabeças;
import Outfit.PvP.Menus.MenuEventos;
import Outfit.PvP.Menus.MenuGeral;
import Outfit.PvP.Menus.MenuKits;
import Outfit.PvP.Menus.MenuKits2;
import Outfit.PvP.Menus.MenuLojaExtras;
import Outfit.PvP.Menus.MenuLojaKits;
import Outfit.PvP.Menus.MenuLojaVips;
import Outfit.PvP.Menus.MenuOutros;
import Outfit.PvP.Menus.MenuPerfil;
import Outfit.PvP.Menus.MenuVip;
import Outfit.PvP.Menus.MenuWarps;
import Outfit.PvP.OneVsOne.CmdsSpeed;
import Outfit.PvP.OneVsOne.Events1v1;
import Outfit.PvP.OneVsOne.Speed1v1;
import Outfit.PvP.Score.BlinkEffect;
import Outfit.PvP.Score.PlayerListener;
import Outfit.PvP.Score.SManager;
import Outfit.PvP.Sumo.CmdsSpeedSumo;
import Outfit.PvP.Sumo.EventsSumo;
import Outfit.PvP.Sumo.SpeedSumo;
import Outfit.PvP.Utils.Proteção;
import Outfit.PvP.Warps.ARENA;
import Outfit.PvP.Warps.Evento;
import Outfit.PvP.Warps.Fps;
import Outfit.PvP.Warps.Knockback;
import Outfit.PvP.Warps.Lava;
import Outfit.PvP.Warps.MDR;
import Outfit.PvP.Warps.MLG;
import Outfit.PvP.Warps.Parkour;
import Outfit.PvP.Warps.Potion;
import Outfit.PvP.Warps.Set1v1;
import Outfit.PvP.Warps.SetEvento;
import Outfit.PvP.Warps.SetFish;
import Outfit.PvP.Warps.SetFps;
import Outfit.PvP.Warps.SetKnockback;
import Outfit.PvP.Warps.SetLava;
import Outfit.PvP.Warps.SetLoc1;
import Outfit.PvP.Warps.SetLoc2;
import Outfit.PvP.Warps.SetMDR;
import Outfit.PvP.Warps.SetMLG;
import Outfit.PvP.Warps.SetParkour;
import Outfit.PvP.Warps.SetPotion;
import Outfit.PvP.Warps.SetS1;
import Outfit.PvP.Warps.SetS2;
import Outfit.PvP.Warps.SetSS;
import Outfit.PvP.Warps.SetSpawn;
import Outfit.PvP.Warps.SetSumo;
import Outfit.PvP.Warps.SetTextura;
import Outfit.PvP.Warps.SetVoid;
import Outfit.PvP.Warps.SetarRdm;
import Outfit.PvP.Warps.Setthemain;
import Outfit.PvP.Warps.Spawn;
import Outfit.PvP.Warps.Textura;
import Outfit.PvP.Warps.TheMain;
import Outfit.PvP.Warps.VoidC;
import Outfit.PvP.Warps.Warp1v1;
import Outfit.PvP.Warps.WarpRdm;
import Outfit.PvP.Warps.WarpSumo;
import Outfit.PvP.Warps.wFisherman;

import java.util.Iterator;
import java.util.List;
import net.minecraft.util.com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class Main extends JavaPlugin
{
  public static String prefix;
  public static String loja;
  public static String ts;
  public static String discord;
  public static String motd;
  public static String motd2;
  public static String motd3;
  public static String motd4;
  public static Plugin plugin;
  public static Main instance;
  public static MyConfigManager manager;
  public static BlinkEffect bk = new BlinkEffect();
  private static Version version;
  public static List<String> admins = Lists.newArrayList();
  
  public static Main getInstace()
  {
    return instance;
  }

  public static Main getInstance1()
  {
    return instance;
  }

  public static Main getPlugin() {
      return (Main)JavaPlugin.getProvidingPlugin((Class<?>)Main.class);
  }

  @SuppressWarnings("deprecation")
public void onEnable() {
		for (Player todos : Bukkit.getOnlinePlayers()) {
			todos.kickPlayer("§d§lKombo§f§lNetwork \n \n §cServidor Reiniciando \n Para sua segurança e a de outros jogadores(a), você foi kickado. \n\nAguarde o servidor reiniciar e entre para jogar novamente =)");
		}
		ReflectionUtils.loadUtils();
		CrashAPI.load();
		Bukkit.getConsoleSender().sendMessage("§b§lSistema de /crash ativado");
		
   SManager.onEnable();
   this.getServer().getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    try {
      saveDefaultConfig();
    }
    catch (Exception localException) {
    }
    prefix = ("§d§lKombo§f§lPvP");
    motd = ("             §f§k!!§r §6Kombo§fPvP §d§k!!§r §8» §7Servidor de KitPvP \n               §5✵ §f§lOS §d§lMELHORES§f§l ESTÃO AQUI§d§l! §5✵");
    motd2 = ("             §f§k!!§r §6Kombo§fPvP §d§k!!§r §8» §7Servidor de KitPvP \n                   §5✵ §f§lNOVA §d§lHOST§f§l SEM LAG§d§l! §5✵");
    motd3 = ("             §f§k!!§r §6Kombo§fPvP §d§k!!§r §8» §7Servidor de KitPvP \n              §5✵ §f§lVENHA TREINAR§6§l! §5✵");
    motd4 = ("             §f§k!!§r §6Kombo§fPvP §d§k!!§r §8» §7Servidor de KitPvP \n                 §c§lSERVIDOR EM MANUNTENCAO!");
    
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
	Bukkit.getConsoleSender().sendMessage("          §d§lKombo§f§lNetwork        ");
	Bukkit.getConsoleSender().sendMessage("                                       ");
	Bukkit.getConsoleSender().sendMessage("      §d§lKombo§f§lPvP §a§lHABILITADO");
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
		public void run() {
			API.AutomaticMessage();
		}
	}, 0L, 120 * 20);
	
	Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
		public void run() {
		    Main.bk.next();
		}
	}, 0L, 20L);
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
        public void run() {
          for (World w : Bukkit.getServer().getWorlds())
            w.setTime(0L); 
        }
    },  0L, 10000L);

    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
    manager = new MyConfigManager(this);
    ZeyCoins.loadMoneyManager();

    instance = this;
    plugin = this;
	new ClanConfig(this);
	new ClanConfig2(this);
    Eventos();
    Comandos();
    Kits();
  }

   public void onDisable() {
      Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
      Bukkit.getConsoleSender().sendMessage("          §d§lOutfit§f§lNetwork        ");
      Bukkit.getConsoleSender().sendMessage("                                       ");
      Bukkit.getConsoleSender().sendMessage("      §d§lKombo§f§lPvP §c§lDESABILITADO!");
      Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
   }
   public static boolean isOldVersion()
   {
     if (version == Version.v1_7) {
       return true;
     }
     if (version == Version.v1_6) {
       return true;
     }
     if (version == Version.v1_5) {
       return true;
     }
     return false;
   }

   public static boolean isVeryOldVersion()
   {
     if (version == Version.v1_6) {
       return true;
     }
     if (version == Version.v1_5) {
       return true;
     }
     return false;
   }
   public void Eventos() {
      PluginManager Eventos = Bukkit.getPluginManager();
      Eventos.registerEvents(new AntiBot(), this);
      Eventos.registerEvents(new PlacaDaLava(), this);
      Eventos.registerEvents(new PlacaDeRecraft(), this);
      Eventos.registerEvents(new Proteção(), this);
      Eventos.registerEvents(new Admin(this), this);
      Eventos.registerEvents(new Diamante(), this);
      Eventos.registerEvents(new EndPortal(), this);
      Eventos.registerEvents(new Ferro(), this);
      Eventos.registerEvents(new Esponja(), this);
      Eventos.registerEvents(new GmCommand(this), this);
      Eventos.registerEvents(new TheTitle(), this);
      Eventos.registerEvents(new AntFlood(this), this);
      Eventos.registerEvents(new Entrar(), this);
      Eventos.registerEvents(new CcCommand(this), this);
      Eventos.registerEvents(new MenuGeral(), this);
      Eventos.registerEvents(new Direito(), this);
      Eventos.registerEvents(new CombatLog(), this);
      Eventos.registerEvents(new XpDiario(), this);
      Eventos.registerEvents(new BroadcastCommand(), this);
      Eventos.registerEvents(new SSCommand(), this);
      Eventos.registerEvents(new SetArenaCommand(this), this);
      Eventos.registerEvents(new KitCommand(this), this);
      Eventos.registerEvents(new Geral(), this);
      Eventos.registerEvents(new MenuPerfil(), this);
      Eventos.registerEvents(new MenuOutros(), this);
      Eventos.registerEvents(new TabPersonalizado(), this);
      Eventos.registerEvents(new InvCommand(), this);
      Eventos.registerEvents(new GanharXP(), this);
      Eventos.registerEvents(new MyConfigManager(this), this);
      Eventos.registerEvents(new ZeyCoins(), this);
      Eventos.registerEvents(new ChatForm(), this);
      Eventos.registerEvents(new Status(), this);
      Eventos.registerEvents(new PvPCommand(), this);
      Eventos.registerEvents(new BuildCommand(), this);
      Eventos.registerEvents(new MenuKits2(this), this);
      Eventos.registerEvents(new MenuKits(this), this);
      Eventos.registerEvents(new MenuVip(), this);
      Eventos.registerEvents(new TagCommand(), this);
      Eventos.registerEvents(new HeadCommand(), this);
      Eventos.registerEvents(new Fps(this), this);
      Eventos.registerEvents(new Textura(this), this);
      Eventos.registerEvents(new Lava(this), this);
      Eventos.registerEvents(new Potion(this), this);
      Eventos.registerEvents(new Evento(this), this);
      Eventos.registerEvents(new Parkour(this), this);
      Eventos.registerEvents(new SetarRdm(this), this);
      Eventos.registerEvents(new SetFps(this), this);
      Eventos.registerEvents(new SetLoc1(this), this);
      Eventos.registerEvents(new Set1v1(this), this);
      Eventos.registerEvents(new SetLoc2(this), this);
      Eventos.registerEvents(new SetTextura(this), this);
      Eventos.registerEvents(new SetKnockback(this), this);
      Eventos.registerEvents(new Caixas(), this);
      Eventos.registerEvents(new SetSS(this), this);
      Eventos.registerEvents(new SetMDR(this), this);
      Eventos.registerEvents(new SetMLG(this), this);
      Eventos.registerEvents(new SetPotion(this), this);
      Eventos.registerEvents(new SetLava(this), this);
      Eventos.registerEvents(new SetEvento(this), this);
      Eventos.registerEvents(new SetParkour(this), this);
      Eventos.registerEvents(new PlacaDeSopa(this), this);
      Eventos.registerEvents(new PlacaDePotion(this), this);
      Eventos.registerEvents(new SetSpawn(this), this);
      Eventos.registerEvents(new Setthemain(this), this);
      Eventos.registerEvents(new Spawn(this), this);
      Eventos.registerEvents(new TheMain(this), this);
      Eventos.registerEvents(new ARENA(this), this);
      Eventos.registerEvents(new MDR(this), this);
      Eventos.registerEvents(new MLG(this), this);
      Eventos.registerEvents(new WarpRdm(this), this);
      Eventos.registerEvents(new MenuWarps(), this);
      Eventos.registerEvents(new MenuLojaKits(this), this);
      Eventos.registerEvents(new MenuLojaVips(), this);
      Eventos.registerEvents(new MenuEventos(), this);
      Eventos.registerEvents(new MenuLojaExtras(this), this);
      Eventos.registerEvents(new MacroTestCommand(), this);
      Eventos.registerEvents(new ParkourJump(this), this);
      Eventos.registerEvents(new Vis(), this);
      Eventos.registerEvents(new MenuCabeças(this), this);
      Eventos.registerEvents(new ApostasListener(), this);
      Eventos.registerEvents(new ChatCommand(this), this);
      Eventos.registerEvents(new SpeedSumo(), this);
      Eventos.registerEvents(new EventsSumo(), this);
      Eventos.registerEvents(new Speed1v1(), this);
      Eventos.registerEvents(new Events1v1(), this);
   }

   void Comandos() {
      this.getCommand("admin").setExecutor(new AdminCommand(this));
      this.getCommand("morrer").setExecutor(new Morrer());
      this.getCommand("autosoup").setExecutor(new AutoSoupCommand(this));
      this.getCommand("bc").setExecutor(new BroadcastCommand());
      this.getCommand("build").setExecutor(new BuildCommand());
      this.getCommand("reloadcfg").setExecutor(new ConfigCommand());
      this.getCommand("cage").setExecutor(new CageCommand());
      this.getCommand("ss").setExecutor(new SSCommand());
      this.getCommand("cc").setExecutor(new CcCommand(this));
      this.getCommand("chat").setExecutor(new ChatCommand(this));
      this.getCommand("darcoins").setExecutor(new DarCoinsCommand());
      this.getCommand("doar").setExecutor(new DoarCommand());
      this.getCommand("finalizar").setExecutor(new FinalizarCommand());
      this.getCommand("fly").setExecutor(new FlyCommand());
      this.getCommand("gm").setExecutor(new GmCommand(this));
      this.getCommand("head").setExecutor(new HeadCommand());
      this.getCommand("sudo").setExecutor(new Sudo());
      this.getCommand("consolesudo").setExecutor(new Sudo());
      this.getCommand("iniciar").setExecutor(new IniciarCommand());
      this.getCommand("inv").setExecutor(new InvCommand());
      this.getCommand("kit").setExecutor(new KitCommand(this));
      this.getCommand("liga").setExecutor(new LigaCommand());
      this.getCommand("crash").setExecutor(new Crashar());
      this.getCommand("marca").setExecutor(new MarcaCommand());
      this.getCommand("testmacro").setExecutor(new MacroTestCommand());
      this.getCommand("ping").setExecutor(new LagCommand());
      this.getCommand("lag").setExecutor(new LagCommand());
      this.getCommand("pvp").setExecutor(new PvPCommand());
      this.getCommand("clan").setExecutor(new ClanCommand());
      this.getCommand("score").setExecutor(new ScoreCommand());
      this.getCommand("setarena").setExecutor(new SetArenaCommand(this));
      this.getCommand("setgroup").setExecutor(new SetGroupCommand());
      this.getCommand("setvip").setExecutor(new SetVipCommand());
      this.getCommand("regras").setExecutor(new Regras());
      this.getCommand("status").setExecutor(new StatusCommand());
      this.getCommand("skit").setExecutor(new sKit(this));
      this.getCommand("sortearkit").setExecutor(new SortearKit());
      this.getCommand("sortearvip").setExecutor(new SortearVip());
      this.getCommand("tag").setExecutor(new TagCommand());
      this.getCommand("tpall").setExecutor(new TpAllCommand());
      this.getCommand("tpevento").setExecutor(new TpAllEvento());
      this.getCommand("tp").setExecutor(new TpCommand());
      this.getCommand("tphere").setExecutor(new TpHereCommand());
      this.getCommand("vis").setExecutor(new Vis());
      this.getCommand("sc").setExecutor(new SCCommand());
      this.getCommand("limpartela").setExecutor(new LimparTelaCommand());
      this.getCommand("recraft").setExecutor(new RecraftCommand());
      this.getCommand("tell").setExecutor(new TellCommand());
      this.getCommand("aplicar").setExecutor(new AplicarCommand());
      this.getCommand("youtuber").setExecutor(new YTCommand());
      this.getCommand("ajuda").setExecutor(new InfoCommand());
      this.getCommand("report").setExecutor(new ReportCommand(this));
      this.getCommand("fps").setExecutor(new Fps(this));
      this.getCommand("warps").setExecutor(new MenuWarps());
      this.getCommand("loja").setExecutor(new MenuVip());
      this.getCommand("textura").setExecutor(new Textura(this));
      this.getCommand("knockback").setExecutor(new Knockback(this));
      this.getCommand("fisherman").setExecutor(new wFisherman(this));
      this.getCommand("challenge").setExecutor(new Lava(this));
      this.getCommand("void").setExecutor(new VoidC(this));
      this.getCommand("sumo").setExecutor(new WarpSumo(this));
      this.getCommand("speedsumo").setExecutor(new CmdsSpeedSumo());
      this.getCommand("evento").setExecutor(new Evento(this));
      this.getCommand("parkour").setExecutor(new Parkour(this));
      this.getCommand("rdmset").setExecutor(new SetarRdm(this));
      this.getCommand("sumoset").setExecutor(new SetSumo(this));
      this.getCommand("s1set").setExecutor(new SetS1(this));
      this.getCommand("s2set").setExecutor(new SetS2(this));
      this.getCommand("fpsset").setExecutor(new SetFps(this));
      this.getCommand("fishset").setExecutor(new SetFish(this));
      this.getCommand("ssset").setExecutor(new SetSS(this));
      this.getCommand("txset").setExecutor(new SetTextura(this));
      this.getCommand("kbset").setExecutor(new SetKnockback(this));
      this.getCommand("potionset").setExecutor(new SetPotion(this));
      this.getCommand("challengeset").setExecutor(new SetLava(this));
      this.getCommand("eventoset").setExecutor(new SetEvento(this));
      this.getCommand("parkourset").setExecutor(new SetParkour(this));
      this.getCommand("mainset").setExecutor(new Setthemain(this));
      this.getCommand("mdrset").setExecutor(new SetMDR(this));
      this.getCommand("mlgset").setExecutor(new SetMLG(this));
      this.getCommand("voidset").setExecutor(new SetVoid(this));
      this.getCommand("spawnset").setExecutor(new SetSpawn(this));
      this.getCommand("loc1set").setExecutor(new SetLoc1(this));
      this.getCommand("loc2set").setExecutor(new SetLoc2(this));
      this.getCommand("1v1set").setExecutor(new Set1v1(this));
      this.getCommand("main").setExecutor(new TheMain(this));
      this.getCommand("arena").setExecutor(new ARENA(this));
      this.getCommand("mdr").setExecutor(new MDR(this));
      this.getCommand("1v1").setExecutor(new Warp1v1(this));
      this.getCommand("speed1v1").setExecutor(new CmdsSpeed());
      this.getCommand("mlg").setExecutor(new MLG(this));
      this.getCommand("potion").setExecutor(new Potion(this));
      this.getCommand("spawn").setExecutor(new Spawn(this));
      this.getCommand("lojakits").setExecutor(new MenuLojaKits(this));
      this.getCommand("rdm").setExecutor(new WarpRdm(this));
      this.getCommand("lojaextras").setExecutor(new MenuLojaExtras(this));
   }

   public void Kits() {
      PluginManager Eventos = Bukkit.getPluginManager();
      Eventos.registerEvents(new Ajnin(), this);
      Eventos.registerEvents(new Anchor(), this);
      Eventos.registerEvents(new Armor(), this);
      Eventos.registerEvents(new Avatar(), this);
      Eventos.registerEvents(new Flash(), this);
      Eventos.registerEvents(new C4(), this);
      Eventos.registerEvents(new Nerfs(), this);
      Eventos.registerEvents(new Alladin(), this);
      Eventos.registerEvents(new Ryu(), this);
      Eventos.registerEvents(new DeshFire(this), this);
      Eventos.registerEvents(new Fisherman(this), this);
      Eventos.registerEvents(new Gladiator(this), this);
      Eventos.registerEvents(new Hulk(), this);
      Eventos.registerEvents(new JellyFish(), this);
      Eventos.registerEvents(new MiniGun(), this);
      Eventos.registerEvents(new Phantom(), this);
      Eventos.registerEvents(new Kangaroo(), this);
      Eventos.registerEvents(new Magma(), this);
      Eventos.registerEvents(new Monk(), this);
      Eventos.registerEvents(new MenuAdm(), this);
      Eventos.registerEvents(new Ninja(this), this);
      Eventos.registerEvents(new Poseidon(), this);
      Eventos.registerEvents(new Resouper(), this);
      Eventos.registerEvents(new Snail(this), this);
      Eventos.registerEvents(new Sonic(this), this);
      Eventos.registerEvents(new Stomper(), this);
      Eventos.registerEvents(new Switcher(), this);
      Eventos.registerEvents(new Swords(), this);
      Eventos.registerEvents(new Grappler(this), this);
      Eventos.registerEvents(new TheForceField(this), this);
      Eventos.registerEvents(new Thor(), this);
      Eventos.registerEvents(new Thresh(this), this);
      Eventos.registerEvents(new QuickDropper(), this);
      Eventos.registerEvents(new Turtle(), this);
      Eventos.registerEvents(new Camel(), this);
      Eventos.registerEvents(new Rain(), this);
      Eventos.registerEvents(new TimeLord(), this);
      Eventos.registerEvents(new Confuser(), this);
      Eventos.registerEvents(new Viking(), this);
      Eventos.registerEvents(new Viper(this), this);
      Eventos.registerEvents(new AntiTower(), this);
      Eventos.registerEvents(new Madman(), this);
      Eventos.registerEvents(new Specialist(), this);
      Eventos.registerEvents(new HotPotato(), this);
   }
}
