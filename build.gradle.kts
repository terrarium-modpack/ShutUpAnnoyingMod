plugins {
    id("checkstyle")
    alias(libs.plugins.loom)
}

version = "2.0.4"
group = "com.github.amyavi"

repositories {
    maven("https://maven.neoforged.net/releases")
    maven("https://maven.bawnorton.com/releases")
    
    maven("https://maven.blamejared.com")
    exclusiveContent {
        forRepository { maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven") }
        filter { includeGroup("software.bernie.geckolib") }
    }
    exclusiveContent {
        forRepository { maven("https://maven.jamalam.tech/releases") }
        filter { includeGroup("io.github.jamalam360") }
    }
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    neoForge(libs.neoforge)
    compileOnly(libs.mixinextras.common)
    annotationProcessor(libs.mixinextras.common)
    implementation(libs.mixinextras.neoforge)
    include(libs.mixinextras.neoforge)

    modImplementation(libs.jei)
    modImplementation(libs.mekanism)
    modImplementation(libs.geckolib)
    modImplementation(libs.jamlib)
    modImplementation(libs.carryon)
    modImplementation(libs.sophisticatedcore)
}

tasks.processResources {
    val properties = mapOf(
        "version" to version,
        "java_version" to libs.versions.java.get(),
        "loader_version" to libs.versions.neoforge.get()
    )

    inputs.properties(properties)
    filesMatching(listOf("META-INF/neoforge.mods.toml", "shutupannoyingmod.mixins.json")) {
        expand(properties)
    }
}

java {
    val javaVersion = JavaVersion.toVersion(libs.versions.java.get())
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}
