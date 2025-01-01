package me.vihara.justahologram.api.property.impl;

import me.vihara.justahologram.api.property.Property;

public class SimpleProperty<T> implements Property<T> {
    private final String name;
    private final T defaultValue;

    private SimpleProperty(String name, T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public static <T> Property<T> of(String name, T defaultValue) {
        return new SimpleProperty<>(name, defaultValue);
    }

    @Override
    public T defaultValue() {
        return defaultValue;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Property{name='" + name + "', defaultValue=" + defaultValue + '}';
    }
}
