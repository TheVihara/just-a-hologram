package me.vihara.plugin.justahologram.hologram.manager

import me.vihara.core.config.yaml.YamlConfigFile
import me.vihara.core.config.yaml.YamlConfigFolder
import me.vihara.justahologram.api.factory.HologramFactory
import me.vihara.justahologram.api.hologram.IHologram
import me.vihara.justahologram.api.hologram.line.IHologramLine
import me.vihara.justahologram.api.property.impl.SimpleProperty
import me.vihara.justahologram.api.property.map.PropertyMap
import me.vihara.plugin.justahologram.hologram.Hologram
import java.util.HashSet
import java.util.concurrent.ConcurrentHashMap

data object HologramManager : HologramFactory {
    private val holograms = ConcurrentHashMap<String, IHologram>()
    private val storage = YamlConfigFolder("holograms")

    init {
        for (file in storage.wrappedFiles) {
            file as YamlConfigFile

            val config = file.config
            val positionColumn = config.getConfigColumn("location")
            val lineColumn = config.getConfigColumn("lines")
            val lines = HashSet<IHologramLine>()
            val properties = PropertyMap()

            properties.set<Float>(
                SimpleProperty.of<Float>("line_gap", 1.0f),
                config.get<Float>("line_gap", Float::class.java)
            )

            for (lineConfig in lineColumn.getKeys(false)) {

            }

            addHologram(Hologram(
                "test",
                IHologram.Position(
                    positionColumn.get<String>("world", String::class.java),
                    positionColumn.get<Double>("x", Double::class.java),
                    positionColumn.get<Double>("y", Double::class.java),
                    positionColumn.get<Double>("z", Double::class.java),
                    positionColumn.get<Float>("yaw", Float::class.java),
                    positionColumn.get<Float>("pitch", Float::class.java)
                ),
                lines,
                properties
            ))
        }
    }

    override fun addHologram(IHologram: IHologram?) {

    }

    override fun removeHologram(IHologram: IHologram?) {

    }

    override fun holograms(): HashSet<IHologram> {
        return holograms.values.toHashSet()
    }

    override fun hologramsByName(): ConcurrentHashMap<String, IHologram> {
        return holograms
    }

}
