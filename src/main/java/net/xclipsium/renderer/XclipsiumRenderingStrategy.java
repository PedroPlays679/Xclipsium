package net.xclipsium.renderer;

import net.xclipsium.device.XclipsiumCapabilities;

public enum XclipsiumRenderingStrategy {

    GPU_DRIVEN,
    TRADITIONAL;

    public static XclipsiumRenderingStrategy select(
            XclipsiumCapabilities capabilities
    ) {
        if (capabilities.supportsGpuDrivenRendering()
                && capabilities.supportsPersistentBuffers()
                && capabilities.supportsLargeIndirectBatches()) {

            return GPU_DRIVEN;
        }

        return TRADITIONAL;
    }
}