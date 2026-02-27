package dora.lifecycle.application

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.launcher.ARouter
import dora.lifecycle.arouter.R

class ARouterAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
    }

    override fun onCreate(application: Application) {
        try {
            ARouter.init(application)
        } catch (e: Exception) {
            Toast.makeText(application,
                ContextCompat.getString(application,
                    R.string.page_routing_compatibility_issue_detected_please_reinstall_the_app_at_your_convenience_to_resolve_this_issue), Toast.LENGTH_LONG).show()
        }
    }

    override fun onTerminate(application: Application) {
    }
}