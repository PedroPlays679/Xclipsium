# Xclipsium

**Experimental GPU rendering optimization project for Minecraft Java Edition, initially focused on Samsung Xclipse and AMD RDNA-based GPUs.**

> ⚠️ Xclipsium is currently in early development. It is not yet a performance-enhancing renderer.

## 🎯 About

Xclipsium is an experimental Fabric project focused on researching and developing modern rendering techniques and GPU-specific optimizations for Minecraft Java Edition.

The project initially targets **Samsung Xclipse GPUs**, which use AMD RDNA-based graphics technology, with the long-term goal of exploring compatibility with a broader range of **AMD Radeon and RDNA-based hardware**.

The objective is not to create a renderer limited to one device family, but to investigate techniques that could eventually benefit different GPU architectures while allowing hardware-specific optimizations where appropriate.

## 🧪 Current Status

**Version:** 0.1.0 — Early Development

Current milestone:

* ✅ Minecraft 26.3
* ✅ Fabric Loader 0.19.3
* ✅ Fabric API 0.160.5+26.3
* ✅ Successfully launches on Android
* ✅ Successfully enters and renders a world
* ✅ Tested on Samsung Galaxy A55
* ✅ Tested with Samsung Xclipse 530
* ✅ Vulkan backend confirmed
* 🔧 GPU/device detection inside Xclipsium
* 🔧 Rendering pipeline research
* ⏳ GPU-driven rendering
* ⏳ Xclipse/RDNA-specific optimizations
* ⏳ Future Radeon compatibility

## 🧬 Target Architecture

Xclipsium's initial development is centered around **AMD RDNA-based graphics technology**, beginning with Samsung's Xclipse implementation.

### Initial target

**Samsung Xclipse**

The first development hardware is the **Xclipse 530** found in the Galaxy A55.

### Long-term targets

* AMD Radeon GPUs
* Other AMD RDNA-based hardware
* Additional Xclipse generations
* Potentially other compatible Vulkan devices

The project will distinguish between **general rendering optimizations** and **hardware-specific optimizations**, allowing techniques developed for Xclipse/RDNA to potentially be adapted to desktop Radeon hardware.

## 📱 Current Test Hardware

### Samsung Galaxy A55

* **GPU:** Samsung Xclipse 530
* **Architecture:** AMD RDNA-based
* **Graphics API:** Vulkan
* **Vulkan:** 1.3.279
* **Driver:** Samsung Proprietary 24.0.539
* **Launcher:** Zalith Launcher
* **Minecraft:** 26.3

Initial testing reached approximately **110–125 FPS at 5 render distance chunks** in a clean Minecraft installation.

These numbers are only an initial baseline and should not be considered an Xclipsium performance improvement.

## 🛠️ Development

Xclipsium is currently being developed around:

* Minecraft 26.3
* Fabric Loader
* Fabric API
* Java 25
* Vulkan
* Samsung Xclipse / AMD RDNA-based hardware

The current priority is understanding Minecraft's modern rendering pipeline and identifying opportunities for GPU-level optimization before implementing more aggressive changes.

## 🚧 Roadmap

### V0.1 — Proof of Concept

* [x] Fabric integration
* [x] Minecraft 26.3 compatibility
* [x] Android launch
* [x] World rendering
* [x] Xclipse 530 testing

### V0.2 — GPU Detection

* [ ] Reliable GPU device detection
* [ ] Vulkan capability detection
* [ ] Driver information
* [ ] GPU feature reporting

### V0.3 — Rendering Research

* [ ] Investigate Minecraft's rendering pipeline
* [ ] Identify potential optimization points
* [ ] Begin controlled rendering experiments
* [ ] Investigate GPU-driven rendering techniques

### Future

* [ ] Xclipse-specific optimizations
* [ ] RDNA-specific optimizations
* [ ] GPU-driven rendering
* [ ] Performance benchmarking
* [ ] Radeon compatibility
* [ ] Testing across multiple RDNA generations
* [ ] Cross-platform Vulkan testing

## ⚠️ Disclaimer

Xclipsium is experimental software.

Performance results may vary significantly depending on the device, GPU architecture, driver, Minecraft version, launcher and configuration.

The current versions should not be expected to provide performance improvements.

## 📄 License

License information will be added as the project develops.
