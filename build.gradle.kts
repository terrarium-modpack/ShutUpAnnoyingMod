plugins {
    checkstyle
    alias(libs.plugins.fabric.loom)
}

version = project.property("mod_version")!!
group = project.property("maven_group")!!

repositories {
    maven("https://mvn.devos.one/releases/")
    maven("https://jitpack.io")
    maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/")

    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    include(implementation(annotationProcessor( // stupidest shit i've ever done
        group = "com.github.bawnorton.mixinsquared",
        name = "mixinsquared-fabric",
        version = libs.versions.mixinsquared.get()
    ))!!)

    modImplementation(libs.buildingwands)
    modImplementation(libs.forgeconfigapiport)
    modImplementation(libs.portinglib.config)
    modImplementation(libs.portinglib.model.loader)
}

tasks.processResources {
    val properties = mapOf(
        "version" to version,
        "java_version" to libs.versions.java.get(),
        "loader_version" to libs.versions.fabric.loader.get()
    )

    inputs.properties(properties)
    filesMatching(listOf("fabric.mod.json", "shutupannoyingmod.mixins.json")) {
        expand(properties)
    }
}

java {
    val javaVersion = JavaVersion.toVersion(libs.versions.java.get())
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}
