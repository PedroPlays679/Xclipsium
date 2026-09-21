plugins {
    id("net.fabricmc.fabric-loom") version "1.17.21"
}

group = "net.xclipsium"
version = "0.2.0"

repositories {
    maven("https://maven.fabricmc.net/")
    maven("https://api.modrinth.com/maven")
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:26.3")

    implementation("net.fabricmc:fabric-loader:0.19.5")
    compileOnly("net.fabricmc.fabric-api:fabric-api:0.161.0+26.3")

}

loom {
    runs {
        named("client") {
            client()
            runDir("run")
        }
    }

    mixin {
        useLegacyMixinAp = false
    }
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    jar {
        archiveBaseName.set("xclipsium")
    }
}