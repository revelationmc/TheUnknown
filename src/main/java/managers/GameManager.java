package managers;

import main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import utils.ColourUtils;

public class GameManager {

    private Main m;
    public GameManager(Main m){
        this.m = m;
    }

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
        });
    }

    public void checkLevel(Player p) {

    }

}
