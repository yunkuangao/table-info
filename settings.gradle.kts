
rootProject.name = "table-info"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {

    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    versionCatalogs {

        create("libs") {

            val kotlinVersion = extra["kotlinVersion"] as String
            val ktorVersion = extra["ktorVersion"] as String
            val kotlinloggingVersion = extra["kotlinloggingVersion"] as String
            val klaxonVersion = extra["klaxonVersion"] as String
            val poitlVersion = extra["poitlVersion"] as String
            val mariadbVersion = extra["mariadbVersion"] as String
            val mysqlVersion = extra["mysqlVersion"] as String
            val slf4jVersion = extra["slf4jVersion"] as String

            // version
            version("kotlin", kotlinVersion)
            version("ktor", ktorVersion)
            version("kotlinlogging", kotlinloggingVersion)
            version("klaxon", klaxonVersion)
            version("poitl", poitlVersion)
            version("mariadb", mariadbVersion)
            version("mysql", mysqlVersion)
            version("slf4j", slf4jVersion)

            // plugin
            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("plugin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")

            // dependency
            library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
            library("kotlin-logging", "io.github.microutils", "kotlin-logging").versionRef("kotlinlogging")
            library("klaxon", "com.beust", "klaxon").versionRef("klaxon")
            library("poi-tl", "com.deepoove", "poi-tl").versionRef("poitl")
            library("mariadb", "org.mariadb.jdbc", "mariadb-java-client").versionRef("mariadb")
            library("mysql", "mysql", "mysql-connector-java").versionRef("mysql")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")
            library("ktor-serialization", "io.ktor", "ktor-serialization-kotlinx-json").versionRef("ktor")
            library("ktor-freemarker", "io.ktor", "ktor-server-freemarker").versionRef("ktor")
            library("ktor-server-content-negotiation", "io.ktor", "ktor-server-content-negotiation").versionRef("ktor")
            library("ktor-status-pages", "io.ktor", "ktor-server-status-pages").versionRef("ktor")
            library("slf4j-api", "org.slf4j", "slf4j-api").versionRef("slf4j")
            library("slf4j-simple", "org.slf4j", "slf4j-simple").versionRef("slf4j")

            // dependency bundle
            bundle(
                "ktor-server",
                listOf(
                    "ktor-server-netty",
                    "ktor-serialization",
                    "ktor-server-content-negotiation",
                    "ktor-status-pages",
                    "ktor-freemarker"
                )
            )

            bundle("logging", listOf("kotlin-logging", "slf4j-api", "slf4j-simple"))
        }
    }
}
