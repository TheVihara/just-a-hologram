package me.vihara.plugin.justahologram.hologram

import me.vihara.justahologram.api.hologram.Hologram
import me.vihara.justahologram.api.hologram.line.HologramLine

data class Hologram(val id: String, val lines: HashSet<HologramLine>) : Hologram {
    var lastTick = 0

    override fun id(): String {
        return id
    }

    override fun lines(): HashSet<HologramLine> {
        return lines
    }
}