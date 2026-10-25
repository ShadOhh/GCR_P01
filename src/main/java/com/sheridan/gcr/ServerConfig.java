package com.sheridan.gcr;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * World server config ({@code gcr-server.toml}). NeoForge syncs it to each connected client,
 * so the value read here during play is the server's, not the player's copy.
 */
public final class ServerConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLE_CROSSHAIR = BUILDER
            .comment(
                    "Master switch for the barrel crosshair while holding a gun.",
                    "false hides it for every player, even when their client config is true.",
                    "true lets each player follow showCrosshair in config/gcr-client.toml."
            )
            .define("enableCrosshair", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    private ServerConfig() {}

    /**
     * Server authority for the crosshair. False when this config is not loaded yet,
     * so the mark stays hidden until the connected server's value is known.
     */
    public static boolean allowsCrosshair() {
        return SPEC.isLoaded() && ENABLE_CROSSHAIR.get();
    }
}
