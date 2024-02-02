package me.rockyers.pointsplus.api;

import lombok.Getter;
import lombok.Setter;
import me.rockyers.pointsplus.PointsManager;
import me.rockyers.pointsplus.PointsPlus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class PointsPlusAPI {
    private final PointsPlus pointsPlugin;
    private final PointsManager pointsManager;
    private PointsPlusAPI(PointsPlus plugin, PointsManager manager) {
        pointsPlugin = plugin;
        pointsManager = manager;
    }

    @Contract("_ -> new")
    public static @NotNull PointsPlusAPI createInstance(PointsManager manager) {
        return new PointsPlusAPI(manager.getPlugin(), manager);
    }
}
