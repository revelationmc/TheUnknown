package events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        

    }

}
