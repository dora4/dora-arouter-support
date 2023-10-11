dora-arouter-support
![Release](https://jitpack.io/v/dora4/dora-arouter-support.svg)
--------------------------------

#### gradle依赖配置

```kotlin
// 添加以下代码到项目根目录下的build.gradle.kts
allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}
// 添加以下代码到app模块的build.gradle.kts
plugins {
    id("kotlin-kapt")
}
kapt {
    generateStubs = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}
dependencies {
    implementation("com.github.dora4:dora:1.1.37")
    implementation("com.github.dora4:dora-arouter-support:1.6")
    kapt("com.alibaba:arouter-compiler:1.5.2")
}
```
