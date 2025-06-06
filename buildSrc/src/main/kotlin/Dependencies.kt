import org.gradle.api.JavaVersion

object ApplicationId {
    val id = "com.example.multitest"
}

object Modules {
    val app = ":app"

    val ui = ":ui"
    val domain = ":domain"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0.0"
}

object Config {
    const val compileSdk = 35
    const val targetSdk = 34
    const val minSdk = 21

    const val jvmTarget ="17"
    val javaVersion = JavaVersion.VERSION_17
}