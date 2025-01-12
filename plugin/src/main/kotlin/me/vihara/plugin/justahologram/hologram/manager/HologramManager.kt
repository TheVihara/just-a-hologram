package me.vihara.plugin.justahologram.hologram.manager

import me.vihara.core.config.ConfigColumn
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
            val positionColumn: ConfigColumn = config.get("location", ConfigColumn::class.java)
            val lineColumn: ConfigColumn = config.get("lines", ConfigColumn::class.java)
            val lines = HashSet<IHologramLine>()
            val properties = PropertyMap()

            properties.set(
                SimpleProperty.of("line_gap", 1.0f),
                config.get("line_gap", Float::class.java)
            )

            for (lineConfig in lineColumn.keyValueMap.keys) {
                println(lineConfig)
            }

            addHologram(Hologram(
                "test",
                IHologram.Position(
                    positionColumn.get("world", String::class.java),
                    positionColumn.get("x", Double::class.java),
                    positionColumn.get("y", Double::class.java),
                    positionColumn.get("z", Double::class.java),
                    positionColumn.get("yaw", Float::class.java),
                    positionColumn.get("pitch", Float::class.java)
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
