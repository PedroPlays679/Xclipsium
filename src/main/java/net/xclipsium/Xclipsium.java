package net.xclipsium;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Xclipsium implements ClientModInitializer {
    public static final String MOD_ID = "xclipsium";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static boolean enabled;
    private static boolean gpuDetected;

    @Override
    public void onInitializeClient() {
        enabled = true;

        LOGGER.info("========================================");
        LOGGER.info("Xclipsium 0.2.0 initializing...");
        LOGGER.info("Minecraft 26.3");
        LOGGER.info("GPU detection armed.");
        LOGGER.info("========================================");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (gpuDetected) {
                return;
            }

            try {
                var device = RenderSystem.tryGetDevice();

                if (device != null) {
                    gpuDetected = true;

                    LOGGER.info("========================================");
                    LOGGER.info("Xclipsium: GPU DEVICE DETECTED!");
                    LOGGER.info("Xclipsium: Device = {}", device);
                    LOGGER.info("========================================");
                }
            } catch (Throwable throwable) {
                LOGGER.error("Xclipsium: GPU detection failed.", throwable);
            }
        });
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void disable(Throwable cause) {
        enabled = false;
        LOGGER.error("Xclipsium has been disabled.", cause);
    }
}