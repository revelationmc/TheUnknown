package org.revelation.theunknown.managers;

import io.github.redwallhp.athenagm.AthenaGM;
import io.github.redwallhp.athenagm.matches.Match;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GameManager extends AthenaGM {

    private final Match match;
    private final AthenaGM plugin = new AthenaGM();

    public GameManager(Match match) {
        this.match = match;
    }

    public void startGame() {
        match.start(120);
        match.getAllPlayers().forEach(player -> {
            for(Player p : match.getAllPlayers()) {
                if(!(p == player)) {
                    p.hidePlayer(plugin, player);
                    player.hidePlayer(plugin, player);
                }
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false));
            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_WARN, 7, 3);
            player.playSound(player.getLocation(), Sound.ENTITY_OCELOT_AMBIENT, 6, 3);
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 5, 3);
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cYou have entered"),
                    ChatColor.translateAlternateColorCodes('&', "&4&lThe &c&lUnknown"), 40, 40, 40);
        });
    }

}