package dora.arouter

import android.app.Activity
import android.widget.Adapter
import androidx.fragment.app.Fragment
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

fun Adapter.open(path :String, build: Postcard.()-> Unit = {}) {
    val postcard = ARouter.getInstance().build(path)
    postcard.build()
    postcard.navigation()
}

fun Activity.openWithFinish(path :String, build: Postcard.()-> Unit = {}) {
    open(path, build)
    finish()
}