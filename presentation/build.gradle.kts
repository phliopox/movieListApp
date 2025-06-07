plugins {
    id("module.android")
    id("kotlin-parcelize")

}

android {
    namespace = "com.example.multitest.presentation"
}

dependencies {
    implementation(projects.common)
    implementation(projects.domain)
    implementation(projects.components)
    implementation(projects.dataResource)

    implementation(libs.androidx.viewmodel)
}