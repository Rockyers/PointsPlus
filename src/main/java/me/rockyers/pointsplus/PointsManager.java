package me.rockyers.pointsplus;

import lombok.Getter;
import me.rockyers.pointsplus.storage.PointsPlusConfig;
import me.rockyers.pointsplus.storage.StorageManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
public class PointsManager {
    private final PointsPlus plugin;
    private final StorageManager storageManager;
    private final PointsPlusConfig config;

    protected PointsManager(@NotNull PointsPlus plugin) {
        this.plugin = plugin;
        storageManager = plugin.getStorageManager();
        config = plugin.getConfigFile();
    }

    public int getPoints(@NotNull Player player) {
        String key = player.getUniqueId().toString();
        return storageManager.getOrSetDefault(key, config.getDefaultScore());
    }

    public PointsManager setPoints(@NotNull Player player, int points) {
        String key = player.getUniqueId().toString();
        storageManager.set(key, points);
        return this;
    }
}