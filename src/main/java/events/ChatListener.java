package events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.Main;
import managers.GameManager;
import utils.ColourUtils;

public class ChatListener implements Listener {
	
	private GameManager gm;
	private Main main;
	
	public ChatListener(Main main) {
		this.main = main;
		this.gm = new GameManager(main);
	}
	
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
       
        if(gm.checkLevel(p) < 2) {
        	event.setCancelled(true);
        	p.sendMessage(ColourUtils.colour("&cYou may not speak until you have passed level 1."));
        	p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 5, 1);
        }

    }

}
