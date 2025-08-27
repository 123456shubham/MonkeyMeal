import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
//    id("com.google.devtools.ksp")
//    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "2.1.10"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName.set("composeApp")
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(projects.shared)

            implementation(compose.components.uiToolingPreview) // ✅ Required for @Preview

            implementation(libs.mvvm.core)
            implementation(libs.mvvm.compose)
            implementation(libs.androidx.navigation.compose)

            implementation("com.russhwolf:multiplatform-settings:1.2.0")


            implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-rc05") // core navigator
            implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.0.0-rc05") // optional
            implementation("cafe.adriel.voyager:voyager-tab-navigator:1.0.0-rc05") // optional



            // coil dependency for loading SVG and GIF
//            implementation("io.coil-kt:coil-compose:2.6.0") // Latest version
//            implementation("io.coil-kt:coil-gif:2.4.0")

            val room_version = "2.6.1"

//            implementation("androidx.room:room-runtime:$room_version")

            // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
            // See Add the KSP plugin to your project
//            ksp("androidx.room:room-compiler:$room_version")

//            implementation("androidx.room:room-ktx:$room_version")

            // dragger-hilt dependency
//            implementation("com.google.dagger:hilt-android:2.51.1")
//            ksp("com.google.dagger:hilt-android-compiler:2.51.1")
//            implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

            // navigation dependency

//            implementation("androidx.navigation:navigation-compose:2.8.7")

            // serialization dependency
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

            // retrofit
//            implementation("com.squareup.retrofit2:retrofit:2.9.0")
//            implementation("com.squareup.retrofit2:converter-gson:2.9.0")

            //coil
//            implementation ("io.coil-kt:coil-compose:2.4.0")
//            implementation ("com.google.accompanist:accompanist-coil:0.10.0")

            // viewModel
//            implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

            //navigation
//            implementation("androidx.navigation:navigation-compose:2.7.7")

            // checker
//            debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
//            releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

//            implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0") // or latest

//            implementation ("androidx.compose.foundation:foundation:1.5.4") // or newer


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

android {
    namespace = "org.example.food"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.example.food"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "org.example.food.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.food"
            packageVersion = "1.0.0"
        }
    }
}
