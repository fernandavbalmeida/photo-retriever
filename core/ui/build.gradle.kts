plugins {
    id("helloclue.android.library")
    id("helloclue.android.library.compose")
}

android {
    namespace = "com.helloclue.androidassignment.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    api(libs.coil)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.compose.ui.util)

    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.compose.ui.test)
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}