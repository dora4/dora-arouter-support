dora-arouter-support
![Release](https://jitpack.io/v/dora4/dora-arouter-support.svg)
--------------------------------

#### gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
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
    implementation 'com.github.dora4:dora-arouter-support:1.3'
}
```
