package org.revelation.theunknown.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class ColourUtils {

    public static String colour(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void titleMaker(Player p, String s, String s2, int in, int stay, int out){
        p.sendTitle(colour(s), colour(s2), in, stay, out);
    }

}
