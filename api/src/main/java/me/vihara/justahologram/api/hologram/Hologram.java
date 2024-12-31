package me.vihara.justahologram.api.hologram;

import me.vihara.justahologram.api.hologram.line.HologramLine;

import java.util.HashSet;

public interface Hologram {
    String id();
    HashSet<HologramLine> lines();
}
