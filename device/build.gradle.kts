plugins {
    id("module.android")
}

android {
    namespace = "com.example.multitest.device"
}

dependencies {
    implementation(projects.design)
    implementation(projects.components)

    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation("androidx.ads:ads-identifier:1.0.0-alpha04")
}
