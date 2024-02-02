package me.rockyers.pointsplus.utils;

import org.bukkit.ChatColor;

import java.util.Arrays;

public class Chat {
    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String[] color(String... strings) {
        return Arrays.stream(strings).map(s -> ChatColor.translateAlternateColorCodes('&', s)).toArray(String[]::new);
    }
}
