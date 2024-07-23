plugins {
    checkstyle
    alias(libs.plugins.fabric.loom)
}

version = project.property("mod_version")!!
group = project.property("maven_group")!!

repositories {
    maven("https://mvn.devos.one/releases/")
    maven("https://jitpack.io")

    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
    include(implementation(annotationProcessor( // stupidest shit i've ever done
        group = "com.github.bawnorton.mixinsquared",
        name = "mixinsquared-fabric",
        version = libs.versions.mixinsquared.get()
    ))!!)

    modCompileOnly(libs.buildingwands)
    modCompileOnly(libs.cctweaked)
    modCompileOnly(libs.enchantedverticalslabs)
    modCompileOnly(libs.forgeconfigapiport)
    modCompileOnly(libs.fwaystones)
    modCompileOnly(libs.gliders)
    modCompileOnly(libs.portinglib.config)
    modCompileOnly(libs.portinglib.model.loader)

    modCompileOnly(libs.itemcollectors)
    modCompileOnly(libs.supermartijn642core)

    modCompileOnly(libs.appbot)
    modCompileOnly(libs.botania)
    modCompileOnly(libs.emi)
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
