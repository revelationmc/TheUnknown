package main;

import commands.StartCommand;
import events.JoinListener;
import managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
        Bukkit.getPluginCommand("start").setExecutor(new StartCommand(this, new GameManager(this)));
    }

    @Override
    public void onDisable(){

    }

}
