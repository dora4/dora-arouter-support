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
    // 扩展包必须在有主框架dora的情况下使用
    implementation("com.github.dora4:dora:1.3.14")
    implementation("com.github.dora4:dora-arouter-support:1.8")
    kapt("com.alibaba:arouter-compiler:1.5.2")
}
```
#### Dora SDK生命周期注入配置
添加以下代码到AndroidManifest.xml
```xml
<application>
        <meta-data
            android:name="dora.lifecycle.config.ARouterGlobalConfig"
            android:value="GlobalConfig" />
</application>
```
