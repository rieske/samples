plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allprojects {
    repositories {
        mavenCentral()
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }
}

dependencies {
    implementation(project("submodule-java"))
    implementation(project("submodule-javalib"))
}

application {
    mainClassName = "lt.rieske.samples.dependencies.Main"
}

tasks.wrapper {
    gradleVersion = "5.6.3"
}
