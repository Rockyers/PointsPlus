package me.rockyers.pointsplus.storage;

import pl.mikigal.config.Config;
import pl.mikigal.config.annotation.ConfigName;

@ConfigName("config.yml")
public interface PointsPlusConfig extends Config {
    default int getDefaultScore() {
        return 0;
    }

    public void setDefaultScore(int defaultScore);
}
