package events;

import main.Main;
import managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main m;
    private GameManager gm;

    public JoinListener(Main m){
        this.m = m;
        gm = new GameManager(m);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(Bukkit.getOnlinePlayers().size() >= 4) {
            gm.startCount(15);
        }
    }

}
