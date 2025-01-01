package me.vihara.justahologram.api.property;

public interface Property<T> {
    T defaultValue();
    String name();
}