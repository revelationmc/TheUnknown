package org.revelation.theunknown.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.revelation.theunknown.main.Main;

public class JoinListener implements Listener {

    private Main m;
    public JoinListener(Main m) {
        this.m = m;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        checkCount();
    }

    private void checkCount() {
        if(Bukkit.getOnlinePlayers().size() == 4){

        } else {
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cGame could not start, requires 4 players."));
        }
    }


}
