plugins {
    id("checkstyle")
    alias(libs.plugins.loom)
}

version = "2.0.0"
group = "com.github.amyavi"

repositories {
    maven("https://maven.neoforged.net/releases")
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    neoForge(libs.neoforge)
    modImplementation(libs.mekanism)
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
