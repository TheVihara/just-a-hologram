package me.vihara.justahologram.api.hologram;

import me.vihara.justahologram.api.hologram.line.HologramLine;
import me.vihara.justahologram.api.property.map.PropertyMap;

import java.util.HashSet;

public interface Hologram {
    String id();
    Position position();
    HashSet<HologramLine> lines();
    PropertyMap properties();

    class Position {
        public String worldName;
        public double x;
        public double y;
        public double z;
        public float yaw;
        public float pitch;

        public Position(String worldName, double x, double y, double z, float yaw, float pitch) {
            this.worldName = worldName;
            this.x = x;
            this.y = y;
            this.z = z;
            this.yaw = yaw;
            this.pitch = pitch;
        }
    }
}
