package me.vihara.justahologram.api.factory;

import me.vihara.justahologram.api.hologram.Hologram;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public interface HologramFactory {
    //Hologram createHologram();
    void addHologram(Hologram hologram);
    void removeHologram(Hologram hologram);
    HashSet<Hologram> holograms();
    ConcurrentHashMap<String, Hologram> hologramsByName();
}
