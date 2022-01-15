package managers;

import main.Main;

public class SpectatorManager {

	private Main main;
	private GameManager gm;
	
	public SpectatorManager(Main main) {
		this.main = main;
		this.gm = new GameManager(main);
	}
	
}
