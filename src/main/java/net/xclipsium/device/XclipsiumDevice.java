package net.xclipsium.device;

public final class XclipsiumDevice {

    private final String deviceName;
    private final String vendor;
    private final String driver;
    private final String vulkanVersion;

    public XclipsiumDevice(
            String deviceName,
            String vendor,
            String driver,
            String vulkanVersion
    ) {
        this.deviceName = deviceName;
        this.vendor = vendor;
        this.driver = driver;
        this.vulkanVersion = vulkanVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDriver() {
        return driver;
    }

    public String getVulkanVersion() {
        return vulkanVersion;
    }

    public String getSummary() {
        return "Device: " + deviceName
                + " | Vendor: " + vendor
                + " | Driver: " + driver
                + " | Vulkan: " + vulkanVersion;
    }
}