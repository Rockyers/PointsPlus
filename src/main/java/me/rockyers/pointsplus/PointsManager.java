package me.rockyers.pointsplus;

import lombok.Getter;

@Getter
public class PointsManager {
    private final PointsPlus plugin;
    public PointsManager(PointsPlus plugin) {
        this.plugin = plugin;
    }
}