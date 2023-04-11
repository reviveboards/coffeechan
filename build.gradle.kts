plugins {
    id("java")
    application
    id("nu.studer.jooq") version "8.0" apply false
}

group = "moe.crx"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":core"))
    implementation(project(":database"))
    implementation(project(":handlers"))
}

application {
    mainClass.set("moe.crx.Starter")
}

allprojects {
    group = "moe.crx"
    version = "1.0-SNAPSHOT"

    apply {
        plugin("java")
        plugin("nu.studer.jooq")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

        implementation("org.jetbrains:annotations:23.0.0")

        implementation("org.projectlombok:lombok:1.18.24")
        compileOnly("org.projectlombok:lombok:1.18.24")
        annotationProcessor("org.projectlombok:lombok:1.18.24")

        implementation("org.flywaydb:flyway-core:9.8.3")
        implementation("org.postgresql:postgresql:42.5.1")
        implementation("com.zaxxer:HikariCP:5.0.1")

        implementation("org.jooq:jooq:3.17.5")
        implementation("org.jooq:jooq-codegen:3.17.5")
        implementation("org.jooq:jooq-meta:3.17.5")

        implementation("com.google.inject:guice:5.1.0")

        implementation("org.eclipse.jetty:jetty-server:11.0.12")
        implementation("org.eclipse.jetty:jetty-servlet:11.0.12")

        implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")

        implementation("org.glassfish.jaxb:jaxb-runtime:4.0.1")
        implementation("org.glassfish.jersey.containers:jersey-container-servlet:3.1.0")
        implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.0")
        implementation("org.glassfish.jersey.media:jersey-media-json-jackson:3.1.0")
        implementation("org.glassfish.jersey.media:jersey-media-multipart:3.1.0")

        implementation("org.jsoup:jsoup:1.15.4")
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}