package me.rockyers.pointsplus;

import de.leonhard.storage.Json;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
public class PointsManager {
    private final PointsPlus plugin;
    private final Json saveFile;
    protected PointsManager(@NotNull PointsPlus plugin) {
        this.plugin = plugin;
        saveFile = new Json("points.json", plugin.getPath());
    }

    public int getPoints(@NotNull Player player) {
        String key = player.getUniqueId().toString();
        // TODO: Add real default from config
        return saveFile.getOrSetDefault(key, 0);
    }

    public PointsManager setPoints(@NotNull Player player, int points) {
        String key = player.getUniqueId().toString();
        saveFile.set(key, points);
        return this;
    }
}