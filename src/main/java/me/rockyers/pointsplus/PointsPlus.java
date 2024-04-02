package me.rockyers.pointsplus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.rockyers.pointsplus.api.PointsPlusAPI;
import me.rockyers.pointsplus.storage.PointsPlusConfig;
import me.rockyers.pointsplus.storage.StorageManager;
import me.rockyers.pointsplus.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.mikigal.config.ConfigAPI;
import pl.mikigal.config.style.CommentStyle;
import pl.mikigal.config.style.NameStyle;

@Setter(value = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PROTECTED)
@Accessors(chain = true)
public final class PointsPlus extends JavaPlugin {
    private static final String PREFIX = "&3[Points+] &7- &f";

    private static PointsManager manager;

    private PointsPlusConfig configFile;
    private StorageManager storageManager;

    @Contract(" -> new")
    public static @NotNull PointsPlusAPI getAPI() {
        return PointsPlusAPI.createInstance(manager);
    }

    @Override
    public void onEnable() {
        log("&7------ &3[Points+] &7------",
                   "&7|    &3By: &bRockyers     &7|",
                   "&7|       &ev2.0.0        &7|",
                   "&7-----------------------");
        log();

        log(PREFIX + "Loading config.yml...");
        configFile = ConfigAPI.init(
                PointsPlusConfig.class,
                NameStyle.HYPHEN,
                CommentStyle.ABOVE_CONTENT,
                true,
                this
        );

        log(PREFIX + "Loading Storage Manager...");
        storageManager = new StorageManager(this);

        log(PREFIX + "Loading Points Manager...");
        manager = new PointsManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void log(String... text) {
        Bukkit.getConsoleSender().sendMessage(Chat.color(text));
    }

    private void log() {
        Bukkit.getLogger().info("");
    }

    public @NotNull String getPath() {
        return getDataFolder().getPath();
    }
}