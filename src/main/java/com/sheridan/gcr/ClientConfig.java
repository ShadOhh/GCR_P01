package com.sheridan.gcr;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Physical-client config ({@code config/gcr-client.toml}). Never synced.
 * Read only after {@link ServerConfig#allowsCrosshair()} is true.
 */
public final class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue SHOW_CROSSHAIR = BUILDER
            .comment(
                    "Shows the barrel crosshair while holding a gun.",
                    "Ignored when the server sets enableCrosshair to false in gcr-server.toml."
            )
            .define("showCrosshair", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    private ClientConfig() {}

    /** Client preference. Defaults to shown if the client file is not loaded yet. */
    public static boolean showCrosshair() {
        return !SPEC.isLoaded() || SHOW_CROSSHAIR.get();
    }
}
