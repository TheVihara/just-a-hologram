package me.vihara.plugin.justahologram.hologram.line

import me.vihara.justahologram.api.hologram.line.IHologramLine
import me.vihara.justahologram.api.property.map.PropertyMap

class HologramLine(private val properties: PropertyMap) : IHologramLine {
    override fun properties(): PropertyMap? {
        return properties
    }
}