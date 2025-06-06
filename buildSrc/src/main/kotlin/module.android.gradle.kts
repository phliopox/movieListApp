plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}


android {
    defaultConfig {
        compileSdk = Config.compileSdk
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
            consumerProguardFiles("proguard-rules.pro")
        }
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        //  compose = true
        dataBinding = true
    }
}
val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.getLibrary("hilt.android"))
    kapt(libs.getLibrary("hilt.compiler"))
    implementation(libs.getLibrary("coroutines.android"))

    testImplementation(libs.getLibrary("junit"))
    testImplementation(libs.getLibrary("coroutines.test"))
    testImplementation(libs.getLibrary("mockk.android"))
}