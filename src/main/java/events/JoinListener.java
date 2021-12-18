package events;

import main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main m;

    public JoinListener(Main m){
        this.m = m;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

    }

}
