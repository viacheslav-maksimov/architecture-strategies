plugins {
    id("application")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}
application {
    mainClass = "com.edu.application.Application"
}

dependencies {
    implementation(project(":usecase"))
    implementation(project(":infrastructure"))
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.hibernate:hibernate-validator:8.0.1.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


