plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace = "dora.lifecycle.arouter"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.github.dora4:dora:1.1.46")
    api("com.alibaba:arouter-api:1.5.2")
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "com.github.dora4"
                artifactId = "dora-arouter-support"
                version = "1.7"
            }
        }
    }
}