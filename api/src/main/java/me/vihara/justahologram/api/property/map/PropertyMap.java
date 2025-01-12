package me.vihara.justahologram.api.property.map;

import me.vihara.justahologram.api.property.Property;

import java.util.concurrent.ConcurrentHashMap;

public class PropertyMap {
    private final ConcurrentHashMap<Property<?>, Object> properties = new ConcurrentHashMap<>();

    public <T> void set(Property<T> property, T value) {
        if (value == null) {
            return;
        }
        properties.put(property, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Property<T> property) {
        return (T) properties.getOrDefault(property, property.defaultValue());
    }
}
