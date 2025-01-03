package me.vihara.justahologram.api.factory;

import me.vihara.justahologram.api.hologram.IHologram;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public interface HologramFactory {
    //IHologram createHologram();
    void addHologram(IHologram IHologram);
    void removeHologram(IHologram IHologram);
    HashSet<IHologram> holograms();
    ConcurrentHashMap<String, IHologram> hologramsByName();
}
