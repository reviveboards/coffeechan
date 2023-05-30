plugins {
    id("java")
    application
    id("nu.studer.jooq") version "8.0" apply false
    id("io.freefair.sass-java") version "8.0.1" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2"
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

tasks.getByName("run") {
    dependsOn("compileSass")
}

tasks.withType<Jar> {
    dependsOn("compileSass")
    manifest {
        attributes["Main-Class"] = "moe.crx.Starter"
    }
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependsOn("compileSass")
    manifest {
        attributes["Main-Class"] = "moe.crx.Starter"
    }
    mergeServiceFiles {
        setPath("META-INF/services/org.flywaydb.core.extensibility.Plugin")
    }
}

allprojects {
    group = "moe.crx"
    version = "1.0-SNAPSHOT"

    apply {
        plugin("java")
        plugin("nu.studer.jooq")
        plugin("io.freefair.sass-java")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

        implementation("org.jetbrains:annotations:24.0.1")

        implementation("org.projectlombok:lombok:1.18.26")
        compileOnly("org.projectlombok:lombok:1.18.26")
        annotationProcessor("org.projectlombok:lombok:1.18.26")

        implementation("org.flywaydb:flyway-core:9.16.0")
        implementation("org.postgresql:postgresql:42.5.4")
        implementation("com.zaxxer:HikariCP:5.0.1")

        implementation("org.jooq:jooq:3.18.0")
        implementation("org.jooq:jooq-codegen:3.18.0")
        implementation("org.jooq:jooq-meta:3.18.4")

        implementation("com.google.inject:guice:5.1.0")

        implementation("org.eclipse.jetty:jetty-server:11.0.14")
        implementation("org.eclipse.jetty:jetty-servlet:11.0.14")

        implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")

        implementation("org.glassfish.jaxb:jaxb-runtime:4.0.2")
        implementation("org.glassfish.jersey.containers:jersey-container-servlet:3.1.1")
        implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.1")
        implementation("org.glassfish.jersey.media:jersey-media-json-jackson:3.1.1")
        implementation("org.glassfish.jersey.media:jersey-media-multipart:3.1.1")

        implementation("org.jsoup:jsoup:1.15.4")
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}