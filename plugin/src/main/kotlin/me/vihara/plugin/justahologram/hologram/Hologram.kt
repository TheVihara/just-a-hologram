package me.vihara.plugin.justahologram.hologram

import me.vihara.justahologram.api.hologram.Hologram
import me.vihara.justahologram.api.hologram.line.HologramLine
import me.vihara.justahologram.api.property.map.PropertyMap

data class Hologram(val id: String, val lines: HashSet<HologramLine>, val properties: PropertyMap) : Hologram {
    var lastTick = 0

    override fun id(): String {
        return id
    }

    override fun lines(): HashSet<HologramLine> {
        return lines
    }

    override fun properties(): PropertyMap {
        return properties
    }
}