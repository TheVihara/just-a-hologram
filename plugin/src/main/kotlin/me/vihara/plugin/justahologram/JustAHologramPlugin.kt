package me.vihara.plugin.justahologram

import me.vihara.justahologram.api.JustAHologramPluginApi
import me.vihara.justahologram.api.factory.HologramFactory
import me.vihara.plugin.justahologram.hologram.manager.HologramManager

class JustAHologramPlugin : JustAHologramPluginApi {
    val hologramFactory: HologramFactory = HologramManager

    override fun hologramFactory(): HologramFactory {
        return hologramFactory
    }
}