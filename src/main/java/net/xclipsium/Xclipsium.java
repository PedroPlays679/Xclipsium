package net.xclipsium;

import net.xclipsium.renderer.XclipsiumRenderingStrategy;
import com.mojang.renderpearl.api.device.DeviceLimits;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.device.DeviceInfo;
import com.mojang.renderpearl.api.device.DeviceFeatures;
import com.mojang.renderpearl.frontend.FrontendGpuDevice;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.xclipsium.device.XclipsiumDevice;
import net.xclipsium.device.XclipsiumCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Xclipsium implements ClientModInitializer {

    public static final String MOD_ID = "xclipsium";
    public static final String VERSION = "0.3.0";

    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);

    private static boolean enabled;
    private static boolean gpuDetected;
    private static XclipsiumDevice device;
    private static XclipsiumCapabilities capabilities;
    private static XclipsiumRenderingStrategy renderingStrategy;

    @Override
    public void onInitializeClient() {
        enabled = true;

        logHeader();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (gpuDetected) {
                return;
            }

            detectGpu();
        });
    }

    private static void logHeader() {
        LOGGER.info("========================================");
        LOGGER.info("Xclipsium {}", VERSION);
        LOGGER.info("========================================");
        LOGGER.info("Minecraft: 26.3");
        LOGGER.info("GPU detection: ARMED");
        LOGGER.info("========================================");
    }

    private static void detectGpu() {
        try {
            var renderDevice = RenderSystem.tryGetDevice();

            if (renderDevice == null) {
                return;
            }

            if (!(renderDevice instanceof FrontendGpuDevice frontendDevice)) {
                LOGGER.warn(
                        "Xclipsium: Unsupported RenderDevice type: {}",
                        renderDevice.getClass().getName()
                );
                return;
            }

            DeviceInfo deviceInfo = frontendDevice.getDeviceInfo();
            DeviceFeatures features = deviceInfo.features();
            DeviceLimits limits = deviceInfo.limits();

            gpuDetected = true;

            device = new XclipsiumDevice(
                    deviceInfo.name(),
                    deviceInfo.vendorName(),
                    deviceInfo.driverInfo(),
                    deviceInfo.backendName()
            );

            capabilities = new XclipsiumCapabilities(
                    features,
                    limits
            );

            renderingStrategy =
                    XclipsiumRenderingStrategy.select(capabilities);

            LOGGER.info("Rendering Strategy: {}", renderingStrategy);

            LOGGER.info("");
            LOGGER.info("----------- GPU INFORMATION ------------");
            LOGGER.info("{}", device.getSummary());
            LOGGER.info("----------------------------------------");

            LOGGER.info("----------- GPU FEATURES ---------------");
            LOGGER.info("Draw Indirect: {}", features.drawIndirect());
            LOGGER.info("Multi Draw Indirect: {}", features.multiDrawIndirect());
            LOGGER.info("Multi Draw Direct Interleaved: {}", features.multiDrawDirectInterleaved());
            LOGGER.info("Multi Draw Direct Separate: {}", features.multiDrawDirectSeparate());
            LOGGER.info("Shader Draw Parameters: {}", features.shaderDrawParameters());
            LOGGER.info("Non-Zero First Instance: {}", features.nonZeroFirstInstance());
            LOGGER.info("Persistent Mapping: {}", features.persistentMapping());
            LOGGER.info("Wireframe Fill Mode: {}", features.wireframeFillMode());
            LOGGER.info("----------------------------------------");

            LOGGER.info("----------- GPU LIMITS -----------------");
            LOGGER.info("Max Anisotropy: {}", limits.maxAnisotropy());
            LOGGER.info("Min Uniform Offset Alignment: {}", limits.minUniformOffsetAlignment());
            LOGGER.info("Max Texture Size: {}", limits.maxTextureSize());
            LOGGER.info("Max Memory Allocation Size: {} bytes",
                    limits.maxMemoryAllocationSize());
            LOGGER.info("Max Multi Draw Direct Interleaved Draw Count: {}",
                    limits.maxMultiDrawDirectInterleavedDrawCount());
            LOGGER.info("Max Color Attachments: {}", limits.maxColorAttachments());
            LOGGER.info("Max Draw Indirect Draw Count: {}",
                    limits.maxDrawIndirectDrawCount());
            LOGGER.info("----------------------------------------");

            LOGGER.info("----------- XCLIPSIUM CAPABILITIES -----");
            LOGGER.info("{}", capabilities.getSummary());
            LOGGER.info("----------------------------------------");

            LOGGER.info("GPU detection complete.");

        } catch (Throwable throwable) {
            LOGGER.error("GPU detection failed.", throwable);
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void disable(Throwable cause) {
        enabled = false;

        LOGGER.error("========================================");
        LOGGER.error("Xclipsium has been disabled.");
        LOGGER.error("========================================", cause);
    }
}