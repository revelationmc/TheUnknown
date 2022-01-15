package managers;

import org.bukkit.entity.Player;

import main.Main;

public class SpectatorManager {

	private Main main;
	private GameManager gm;
	
	public SpectatorManager(Main main) {
		this.main = main;
		this.gm = new GameManager(main);
	}
	
	public void checkIfSpec(Player p) {
		
	}
	
}
