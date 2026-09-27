# Xclipsium

**Experimental GPU rendering optimization project for Minecraft Java Edition, initially focused on Samsung Xclipse and AMD RDNA-based GPUs.**

> ⚠️ Xclipsium is currently in early development. It is a research project and is not yet a performance-enhancing renderer.

## 🎯 About

Xclipsium is an experimental Fabric project focused on researching and developing modern rendering techniques and GPU-specific optimizations for Minecraft Java Edition.

The project initially targets **Samsung Xclipse GPUs**, which use AMD RDNA-based graphics technology, with the long-term goal of exploring compatibility with a broader range of **AMD Radeon and RDNA-based hardware**.

The objective is not to create a renderer limited to one device family, but to investigate techniques that could eventually benefit different GPU architectures while allowing hardware-specific optimizations where appropriate.

## 🧪 Current Status

**Version:** 0.3.0 — GPU Intelligence Layer

Current milestone:

* ✅ Minecraft 26.3
* ✅ Fabric Loader 0.19.5
* ✅ Fabric API 0.161.0+26.3
* ✅ Java 25
* ✅ Successfully launches on Android
* ✅ Successfully enters and renders a world
* ✅ Tested on Samsung Galaxy A55
* ✅ Samsung Xclipse 530 detected
* ✅ Vulkan backend detected
* ✅ Vulkan driver information detected
* ✅ GPU/device information detected
* ✅ GPU features detected
* ✅ GPU hardware limits detected
* ✅ Xclipsium capability system
* ✅ Automatic rendering strategy selection
* 🔧 Rendering pipeline integration
* ⏳ GPU-driven rendering implementation
* ⏳ Xclipse/RDNA-specific optimizations
* ⏳ Future Radeon compatibility

## 🧬 Architecture

Xclipsium currently follows a capability-based architecture:

```text
GPU
 ↓
Device Information
 ↓
Features + Limits
 ↓
Xclipsium Capabilities
 ↓
Rendering Strategy
 ↓
Future Rendering Integration
```

The goal is to avoid making assumptions based only on the GPU name. Xclipsium evaluates the capabilities exposed by the graphics device and uses them to determine which rendering strategy is appropriate.

### Current rendering strategies

Xclipsium currently supports two internal strategy states:

* **GPU_DRIVEN** — selected when the required GPU capabilities are available.
* **TRADITIONAL** — fallback strategy for devices that do not meet the requirements.

The current GPU-driven strategy is a **capability decision only**. It does not yet replace Minecraft's rendering pipeline.

## 🔬 GPU Intelligence Layer

Version 0.3.0 introduces the first complete GPU intelligence layer.

Xclipsium reads information provided by Minecraft's modern RenderPearl device API, including:

### Device information

* GPU name
* Vendor
* Driver information
* Graphics backend

### GPU features

* Draw Indirect
* Multi Draw Indirect
* Shader Draw Parameters
* Persistent Mapping
* Non-Zero First Instance
* Multi Draw Direct support
* Wireframe Fill Mode

### GPU limits

* Maximum anisotropy
* Maximum texture size
* Maximum memory allocation size
* Maximum color attachments
* Maximum indirect draw count
* Uniform buffer alignment

These values are converted into higher-level **Xclipsium Capabilities**, which are then used to select a rendering strategy.

## 🧬 Target Architecture

Xclipsium's initial development is centered around **AMD RDNA-based graphics technology**, beginning with Samsung's Xclipse implementation.

### Initial target

**Samsung Xclipse**

The primary development hardware is the **Xclipse 530** found in the Galaxy A55.

### Long-term targets

* AMD Radeon GPUs
* Other AMD RDNA-based hardware
* Additional Xclipse generations
* Other compatible Vulkan devices

The project distinguishes between **general rendering optimizations** and **hardware-specific optimizations**, allowing techniques developed for Xclipse/RDNA to potentially be adapted to desktop Radeon hardware.

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
* Fabric Loader 0.19.5
* Fabric API 0.161.0+26.3
* Java 25
* Vulkan
* Samsung Xclipse / AMD RDNA-based hardware

The current priority is understanding Minecraft's modern rendering pipeline and identifying opportunities for GPU-level optimization before implementing more aggressive rendering changes.

## 🚧 Roadmap

### V0.1 — Proof of Concept

* [x] Fabric integration
* [x] Minecraft 26.3 compatibility
* [x] Android launch
* [x] World rendering
* [x] Xclipse 530 testing

### V0.2 — GPU Detection

* [x] GPU device detection
* [x] Vulkan backend detection
* [x] Driver information
* [x] GPU identification
* [x] Basic GPU information logging

### V0.3 — GPU Intelligence Layer

* [x] GPU feature detection
* [x] GPU hardware limit detection
* [x] Xclipsium capability system
* [x] GPU-driven rendering capability evaluation
* [x] Persistent buffer capability evaluation
* [x] Indirect draw capability evaluation
* [x] Rendering strategy selection
* [x] Traditional rendering fallback

### V0.4 — Rendering Integration

* [ ] Integrate Xclipsium into the rendering path
* [ ] Connect rendering strategy to Minecraft/Sodium rendering
* [ ] Begin controlled rendering experiments
* [ ] Introduce the first Xclipsium rendering changes
* [ ] Validate stability and correctness

### Future

* [ ] GPU-driven rendering
* [ ] Xclipse-specific optimizations
* [ ] RDNA-specific optimizations
* [ ] Performance benchmarking
* [ ] Radeon compatibility
* [ ] Testing across multiple RDNA generations
* [ ] Cross-platform Vulkan testing

## ⚠️ Disclaimer

Xclipsium is experimental software.

Performance results may vary significantly depending on the device, GPU architecture, driver, Minecraft version, launcher and configuration.

Current versions should not be expected to provide performance improvements.
