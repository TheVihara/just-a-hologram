package me.vihara.plugin.justahologram.hologram.manager

import me.vihara.justahologram.api.factory.HologramFactory
import me.vihara.justahologram.api.hologram.Hologram
import java.util.HashSet
import java.util.concurrent.ConcurrentHashMap

data object HologramManager : HologramFactory {
    private val holograms = ConcurrentHashMap<String, Hologram>()

    init {

    }

    override fun addHologram(hologram: Hologram?) {

    }

    override fun removeHologram(hologram: Hologram?) {

    }

    override fun holograms(): HashSet<Hologram> {
        return holograms.values.toHashSet()
    }

    override fun hologramsByName(): ConcurrentHashMap<String, Hologram> {
        return holograms
    }

}
