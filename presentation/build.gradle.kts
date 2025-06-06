plugins {
   id("module.android")
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