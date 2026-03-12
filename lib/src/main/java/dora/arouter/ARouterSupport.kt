package dora.arouter

import android.app.Activity
import android.app.Service
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

fun Activity.open(path :String, build: Postcard.()-> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation()
}

fun Fragment.open(path :String, build: Postcard.()-> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation()
}

fun Service.open(
    path: String,
    build: Postcard.() -> Unit = {}
) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    postcard.navigation(this)
}


fun RecyclerView.Adapter<*>.open(path :String, build: Postcard.()-> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation()
}

fun Activity.openWithFinish(path :String, build: Postcard.()-> Unit = {}) {
    open(path, build)
    finish()
}