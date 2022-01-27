package commands;

import main.Main;
import managers.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.ColourUtils;

public class StartCommand implements CommandExecutor {

    private Main m;
    private GameManager gm;
    public StartCommand(Main m, GameManager gm){
        this.m = m;
        this.gm = gm;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ColourUtils.colour("&4&lADMIN &8| &aAn administrator command was executed."));
        gm.startGame();
        return true;
    }
}
