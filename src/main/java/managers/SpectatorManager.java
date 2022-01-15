package managers;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import utils.ColourUtils;

public class SpectatorManager {

	private Main main;
	private GameManager gm;
	private Set<Player> spectators = new HashSet<Player>();
	public SpectatorManager(Main main) {
		this.main = main;
		this.gm = new GameManager(main);
	}
	
	public void createSpec(Player p) {
		if(gm.checkPlayers(p)) {
			gm.removePlayer(p);
		}
		spectators.add(p);
		ColourUtils.titleMaker(p, "&6You have been &c&lELIMINATED!", "", 40, 40, 40);
		for(Player player : gm.getPlayersAsList(p)) {
			player.hidePlayer(main, p);
		}
		p.setGameMode(GameMode.SPECTATOR);
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColourUtils.colour("&eYou are now a SPECTATOR.")));
		
	}
	
	
	
	
}
