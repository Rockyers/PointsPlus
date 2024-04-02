package me.rockyers.pointsplus.storage;

import de.leonhard.storage.Json;
import lombok.Getter;
import me.rockyers.pointsplus.PointsPlus;

@Getter
public class StorageManager {
    private final PointsPlus plugin;
    private final Json saveFile;

    public StorageManager(PointsPlus plugin) {
        this.plugin = plugin;
        saveFile = new Json("points.json", plugin.getPath());
    }

    public Object get(String key) {
        return saveFile.get(key);
    }

    public <T> T getOrSetDefault(String key, T def) {
        return saveFile.getOrSetDefault(key, def);
    }

    public void set(String key, Object value) {
        saveFile.set(key, value);
    }
}
