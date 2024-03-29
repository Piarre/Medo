package fr.piarre.myPlugin;

import fr.piarre.myPlugin.Commands.Mode;
import fr.piarre.myPlugin.Commands.SS;
import fr.piarre.myPlugin.Listeners.BanListener;
import fr.piarre.myPlugin.Listeners.SSListener;
import fr.piarre.myPlugin.Utils.Enums;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {

    private static Main instance;
    public HashMap<Player, Enums.Modes> playersMode = new HashMap<>();
    private SS SS;


    public static Main getInstance() {
        return instance;
    }



    public void onEnable() {
        saveDefaultConfig();

        getConfig().options().copyDefaults(true);
        saveConfig();

        registerCommands();
        registerEvents();
    }

    public void registerCommands() {
        getCommand("ss").setExecutor(new SS(this));
        getCommand("mode").setExecutor(new Mode(this));
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SSListener(), this);
        pm.registerEvents(new BanListener(SS), this);
    }

    public HashMap<Player, Enums.Modes> getPlayersMode() {
        return playersMode;
    }

    public void onDisable() {
        getLogger().info("MyPlugin is disabled");
    }

}
