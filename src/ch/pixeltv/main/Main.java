package ch.pixeltv.main;

import ch.pixeltv.commands.*;
import ch.pixeltv.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Coded by PixelTeleV
 * 17.08.2018
 * Copyright PixelTeleV 2018.
 * Decompiling is strictly forbidden!
 * Coded with Intellij
 */
public class Main extends JavaPlugin {

    public static ArrayList<Player> fly = new ArrayList<>();

    public static String pr = "§8┃ §eSystem§8» §7";
    public static String noperm = pr + "Du hast §ckeinen Zugriff §7auf diesen Befehl!";
    public static String syntax = pr + "§cSyntax: §a";

    public void onEnable() {
        //Enable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aServerSystem");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §aAlpha 1.0");
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aLocal Test Usage");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§a§lPlugin activated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");

        //listeners Vereinfachung
        PluginManager pm = Bukkit.getPluginManager();
        //listeners
        pm.registerEvents(new Unknown(), this);
        pm.registerEvents(new Reload(), this);
        pm.registerEvents(new CmdBlocker(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Quit(), this);


        //commands
        getCommand("fly").setExecutor(new Fly());
        getCommand("gamemode").setExecutor(new GameMode());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("workbench").setExecutor(new WorkBench());
        getCommand("msg").setExecutor(new Msg());
        getCommand("suicide").setExecutor(new Suicide());
        getCommand("skull").setExecutor(new Skull());
        getCommand("invsee").setExecutor(new InvSee());

        //Tpa Befehle (/tpa) - Anfrage ; (/tpaccept) - Annehmen ; (/tpdeny) - Ablehnen
        getCommand("tpa").setExecutor(new Tpa());
        getCommand("tpaccept").setExecutor(new Tpaccept());
        getCommand("tpdeny").setExecutor(new Tpdeny());
    }


    public void onDisable() {
        //Disable Message
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin: §aServerSystem");
        Bukkit.getConsoleSender().sendMessage("§7Author: §aPixelTeleV");
        Bukkit.getConsoleSender().sendMessage("§7Version: §aAlpha 1.0");
        Bukkit.getConsoleSender().sendMessage("§7Licensed for: §aLocal Test Usage");
        Bukkit.getConsoleSender().sendMessage("§4§lCopyright PixelTeleV 2018");
        Bukkit.getConsoleSender().sendMessage("§c§lPlugin deactivated!");
        Bukkit.getConsoleSender().sendMessage("§b§m------------------");
    }

}
