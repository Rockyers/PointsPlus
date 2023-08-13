package me.rockyers.pointsplus.api;

import me.rockyers.pointsplus.PointsManager;
import me.rockyers.pointsplus.PointsPlus;

public class PointsPlusAPI {
    private final PointsPlus pointsPlugin;
    private final PointsManager pointsManager;
    private PointsPlusAPI(PointsPlus plugin, PointsManager manager) {
        pointsPlugin = plugin;
        pointsManager = manager;
    }

    public static PointsPlusAPI createInstance(PointsManager manager) {
        return new PointsPlusAPI(manager.getPlugin(), manager);
    }
}
