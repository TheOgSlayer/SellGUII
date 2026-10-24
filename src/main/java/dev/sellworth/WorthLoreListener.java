package dev.sellworth;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Kept only because the built-in hover hook (NativeWorth) calls it as a last-resort fallback.
 * The ProtocolLib fallback is not part of this build.
 */
public final class WorthLoreListener {

    private WorthLoreListener() { }

    public static void register(JavaPlugin plugin, PriceManager prices) {
        plugin.getLogger().warning("The ProtocolLib fallback for hover worth is not included in this build.");
    }
}
