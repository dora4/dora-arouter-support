plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace = "dora.lifecycle.eventbus"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
    //        // Java版ARouter配置
    //        javaCompileOptions {
    //            annotationProcessorOptions {
    //                arguments = [AROUTER_MODULE_NAME: project.getName()]
    //            }
    //        }
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

//这里使用Kotlin的ARouter配置，当然使用Java的也是兼容的
kapt {
    generateStubs = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.alibaba:arouter-api:1.4.1")
    // Java用，不需要
//    annotationProcessor("com.alibaba:arouter-compiler:1.2.2")
    kapt("com.alibaba:arouter-compiler:1.2.2")
    implementation("com.github.dora4:dora:1.0.94")
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "com.github.dora4"
                artifactId = "dora-arouter-support"
                version = "1.0"
            }
        }
    }
}