package com.github.tumusx.build_manager


import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

fun getLocalProperty(key: String, project: Project): String {
    val localPropertiesFile = project.rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        val localProperties = Properties()
        localProperties.load(FileInputStream(localPropertiesFile))
        return localProperties.getProperty(key)
    } else {
        return System.getenv(key)
    }
}

class Properties : Plugin<Project> {

    override fun apply(target: Project) {
    }
}
