package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class ARouterAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
    }

    override fun onCreate(application: Application) {
        ARouter.init(application)
    }

    override fun onTerminate(application: Application) {
    }
}