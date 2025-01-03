package me.vihara.plugin.justahologram.hologram

import me.vihara.justahologram.api.hologram.IHologram
import me.vihara.justahologram.api.hologram.line.IHologramLine
import me.vihara.justahologram.api.property.map.PropertyMap

data class Hologram(val id: String, val position: IHologram.Position, val lines: HashSet<IHologramLine>, val properties: PropertyMap) :
    IHologram {
    var lastTick = 0

    override fun id(): String {
        return id
    }

    override fun position(): IHologram.Position {
        return position
    }

    override fun lines(): HashSet<IHologramLine> {
        return lines
    }

    override fun properties(): PropertyMap {
        return properties
    }
}