import org.gradle.api.JavaVersion

object ApplicationId {
    val id = "com.example.multitest"
}

/*
object Modules {
    val app = ":app"

    val design = ":design"
    val device = ":device"
    val ui = ":ui"

    val presentation = ":presentation"
    val domain = ":domain"
    val data = ":data"
    val remote = ":remote"
    val local = ":local"

    val dataResource = "::data-resource"
    val common = ":common"
    val component = ":component"
}
*/

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