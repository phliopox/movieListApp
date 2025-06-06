// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        jcenter()
    }
    dependencies {
        classpath(libs.kotlin)
        classpath(libs.hilt.gradle)
        classpath(libs.androidx.navigation.args.gradle)

    }
}*/

plugins {
    //alias(libs.plugins.android.application) apply false
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.jvm") apply false
    id("org.jetbrains.kotlin.android") apply false
    id("com.google.dagger.hilt.android") apply false
    alias(libs.plugins.androidx.navigation.safeargs) apply false
/*alias(libs.plugins.kotlin.android) apply false
    // alias(libs.plugins.kotlin.compose) apply false
     alias(libs.plugins.jetbrains.kotlin.jvm) apply false
     alias(libs.plugins.hilt.android) apply false*/


}
