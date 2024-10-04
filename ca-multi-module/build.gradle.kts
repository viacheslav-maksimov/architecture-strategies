plugins {
    java
    `maven-publish`
    `java-library`
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("io.freefair.lombok") version "8.10"
}

group = "com.edu"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

subprojects {
    group = "com.edu.ca-multi-module"

    apply {
        plugin("java")
        plugin("maven-publish")
        plugin("io.freefair.lombok")
    }

    dependencies{
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.3")
        testImplementation("org.assertj:assertj-core:3.26.0")
    }
    repositories {
        mavenCentral()
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = "0.0.1-SNAPSHOT"

                from(components["java"])
            }
        }
    }

}
dependencies {
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("script-runtime"))
}





