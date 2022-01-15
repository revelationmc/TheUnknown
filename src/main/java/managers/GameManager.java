package managers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import utils.ColourUtils;

public class GameManager {

    private Main m;
    public GameManager(Main m){
        this.m = m;
    }
    
    private HashMap<Player, Integer> level = new HashMap<Player, Integer>();
    private Set<Player> gamePlayers = new HashSet<Player>();

    public void startCount(int time) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(m, () -> {
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColourUtils.colour("&aGame starting in &e" + time)));
                player.playSound(player.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 7, 1);
            });
        }, 0L, (time*20));
    }

    public void start() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false));
            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_WARN, 7, 3);
            player.playSound(player.getLocation(), Sound.ENTITY_OCELOT_AMBIENT, 6, 3);
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 5, 3);
            ColourUtils.titleMaker(player, "&cYou have entered", "&4&lThe &c&lUnknown", 40, 40, 40);
            gamePlayers.add(player);
        });
    }

    public int checkLevel(Player p) {
    	if(level.get(p) == null) {
    		level.put(p, 1);
    	}
    	return level.get(p);
    }
    
    public boolean checkPlayers(Player p) {
    	if(gamePlayers.contains(p)) {
    		return true;
    	}
    	return false;
    }
    
    public Set<Player> getPlayersAsList(Player p){
    	return gamePlayers;
    }

    public void removePlayer(Player p) {
    	if(gamePlayers.contains(p)) {
    		gamePlayers.remove(p);
    	} 
    }
    
}
