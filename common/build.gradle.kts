plugins {
    id("module.android")
}

android{
    namespace = "com.example.multitest.common"
}

dependencies {
    implementation(projects.components)
    implementation(libs.gson)
}