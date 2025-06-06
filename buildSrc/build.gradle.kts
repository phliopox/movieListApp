plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`

}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.gradle)
    implementation(libs.kotlin)
    implementation(libs.kotlin.compiler.embeddable)
    implementation(libs.hilt.gradle)
}
