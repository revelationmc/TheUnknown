package main;

import events.JoinListener;
import io.github.redwallhp.athenagm.AthenaGM;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    AthenaGM athena;

    @Override
    public void onEnable(){
        if(checkAthena()){
            new JoinListener(athena);
        }
    }

    @Override
    public void onDisable(){

    }

    private boolean checkAthena() {
        Plugin plugin = getServer().getPluginManager().getPlugin("AthenaGM");
        if (plugin == null || !(plugin instanceof AthenaGM)) {
            this.setEnabled(false);
            return false;
        } else {
            athena = (AthenaGM) plugin;
            return true;
        }
    }

    public AthenaGM getAthena() {
        return athena;
    }

}
