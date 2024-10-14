plugins {
    checkstyle
    alias(libs.plugins.fabric.loom)
}

version = project.property("version")!!
group = project.property("group")!!

repositories {
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }

    maven("https://mvn.devos.one/releases/")
    maven("https://maven.bawnorton.com/releases/")
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

    modCompileOnly(libs.cctweaked)
    modCompileOnly(libs.createdeco)
    modCompileOnly(libs.forgeconfigapiport)
    modCompileOnly(libs.fwaystones)
    modCompileOnly(libs.modonomicon)
    modCompileOnly(libs.portinglib.config) { isTransitive = false }
    modCompileOnly(libs.portinglib.model.loader) { isTransitive = false }

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
