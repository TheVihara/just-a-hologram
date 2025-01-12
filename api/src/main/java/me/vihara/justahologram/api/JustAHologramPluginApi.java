package me.vihara.justahologram.api;

import me.vihara.justahologram.api.factory.HologramFactory;

public interface JustAHologramPluginApi {

    /**
     * Gets the HologramFactory instance.
     *
     * @return the hologram factory.
     */
    HologramFactory hologramFactory();

    /**
     * Holds the singleton instance of the JustAHologramPluginApi.
     */
    final class Holder {
        private static JustAHologramPluginApi instance;

        private Holder() {
        }

        public static void setInstance(JustAHologramPluginApi apiInstance) {
            if (instance != null) {
                throw new IllegalStateException("Instance already set");
            }
            instance = apiInstance;
        }

        public static JustAHologramPluginApi getInstance() {
            if (instance == null) {
                throw new IllegalStateException("Instance not initialized");
            }
            return instance;
        }
    }

    /**
     * Sets the singleton instance of the API.
     *
     * @param apiInstance the instance to set.
     */
    static void setInstance(JustAHologramPluginApi apiInstance) {
        Holder.setInstance(apiInstance);
    }

    /**
     * Retrieves the singleton instance of the API.
     *
     * @return the singleton instance.
     */
    static JustAHologramPluginApi getInstance() {
        return Holder.getInstance();
    }
}
