# Xclipsium 0.1.0

Experimental Fabric client mod for Minecraft 26.3.

Target:
- Minecraft 26.3
- Fabric Loader 0.19.3
- Sodium 0.9.2
- Fabric API 0.160.5+26.3

## V0.1 goal

This build does NOT replace Sodium's draw backend yet.

It intercepts `SodiumWorldRenderer.renderLayer(...)`, then delegates the exact
rendering work back to Sodium's `RenderSectionManager`/`ChunkRenderer`.

That gives us a safe first milestone:
1. Xclipsium loads.
2. The Sodium renderer entry point is intercepted.
3. Rendering remains Sodium's implementation.
4. Later versions can replace only the draw backend.

The source was aligned against the supplied Sodium 26.3 / 0.9.2 source tree.

## Build

Requires an installed JDK compatible with Minecraft 26.3 (Java 21+) and
network access for Gradle dependencies.

Run:

    ./gradlew build

The jar will be under:

    build/libs/
