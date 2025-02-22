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
    maven("https://mvn.devos.one/snapshots/")
    maven("https://maven.bawnorton.com/releases/")

    // Estrogen
    maven("https://maven.is-immensely.gay/releases/")
    maven("https://maven.teamresourceful.com/repository/maven-public/")
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
    modCompileOnly(libs.portinglib.config) { isTransitive = false }

    modCompileOnly(libs.create) { isTransitive = false } // :(
    modCompileOnly(libs.estrogen) { isTransitive = false }
    modCompileOnly(libs.resourcefulcosmetics) { isTransitive = false }

    modCompileOnly(libs.itemcollectors)
    modCompileOnly(libs.supermartijn642core)

    modCompileOnly(libs.appbot)
    modCompileOnly(libs.botania)
    modCompileOnly(libs.emi)

    compileOnly(libs.blahaj) // do not remap or fabric-loom blows up
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
