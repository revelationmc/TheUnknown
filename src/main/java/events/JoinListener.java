package events;

import io.github.redwallhp.athenagm.AthenaGM;
import io.github.redwallhp.athenagm.matches.Match;
import io.github.redwallhp.athenagm.matches.MatchStartCountdown;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Match match;
    public JoinListener(AthenaGM plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        checkCount();
    }

    private void checkCount() {
        if(Bukkit.getOnlinePlayers().size() == 4){
            match.startCountdown();
        } else {
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cGame could not start, requires 4 players."));
        }
    }


}
