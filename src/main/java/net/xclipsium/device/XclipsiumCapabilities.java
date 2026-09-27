package net.xclipsium.device;

import com.mojang.renderpearl.api.device.DeviceFeatures;
import com.mojang.renderpearl.api.device.DeviceLimits;

public final class XclipsiumCapabilities {

    private final boolean drawIndirect;
    private final boolean multiDrawIndirect;
    private final boolean shaderDrawParameters;
    private final boolean persistentMapping;

    private final int maxTextureSize;
    private final int maxColorAttachments;
    private final int maxDrawIndirectDrawCount;

    public XclipsiumCapabilities(
            DeviceFeatures features,
            DeviceLimits limits
    ) {
        this.drawIndirect = features.drawIndirect();
        this.multiDrawIndirect = features.multiDrawIndirect();
        this.shaderDrawParameters = features.shaderDrawParameters();
        this.persistentMapping = features.persistentMapping();

        this.maxTextureSize = limits.maxTextureSize();
        this.maxColorAttachments = limits.maxColorAttachments();
        this.maxDrawIndirectDrawCount = limits.maxDrawIndirectDrawCount();
    }

    public boolean supportsGpuDrivenRendering() {
        return drawIndirect
                && multiDrawIndirect
                && shaderDrawParameters;
    }

    public boolean supportsPersistentBuffers() {
        return persistentMapping;
    }

    public boolean supportsLargeIndirectBatches() {
        return maxDrawIndirectDrawCount > 1024;
    }

    public boolean supportsHighResolutionTextures() {
        return maxTextureSize >= 16384;
    }

    public boolean hasMultipleColorAttachments() {
        return maxColorAttachments >= 4;
    }

    public String getSummary() {
        return "GPU Driven: " + supportsGpuDrivenRendering()
                + " | Persistent Buffers: " + supportsPersistentBuffers()
                + " | Large Indirect Batches: " + supportsLargeIndirectBatches()
                + " | High Resolution Textures: " + supportsHighResolutionTextures()
                + " | MRT: " + hasMultipleColorAttachments();
    }
}