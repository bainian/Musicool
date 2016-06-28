package cn.guoguoa.kotlinlibrary

import android.app.Activity
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast

/**
 * Created by sage on 16-6-28.
 */


fun Activity.toast(text: CharSequence, duartion: Int = Toast.LENGTH_SHORT): Unit = Toast.makeText(this, text, duartion).show()

//inline fun <reified T : Any> Activity.startActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null, action: String?) {
//    startActivityForResult(Intent(), requestCode, options,action)
//}

//inline fun Activity.runOnUiThread(action: () -> Unit): Unit {
//    runOnUiThread (Runnable{action})
//}

/*inline修饰符是优化函数的方法，该函数的参数包含其它函数。当函数包含lambda表达式时，其转换等同于对象包含了函数的实现代码。然而，如果用inline，lambda表达式将在被调用时由它的代码来替换。如果lambda表达式返回一个值，就要用crossinline。更多资料请阅读Kotlin参考资料。*/
inline fun OnItemClickListener(crossinline action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Unit): AdapterView.OnItemClickListener {
    return object : AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            action(p0, p1, p2, p3)
        }
    }
}

inline fun OnItemLongClickListener(crossinline action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Boolean): AdapterView.OnItemLongClickListener {
    return object : AdapterView.OnItemLongClickListener {
        override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean = action(p0, p1, p2, p3)
    }
}

inline fun AdapterView<out Adapter?>.setOnItemLongClickListener(crossinline action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Boolean) {
    setOnItemLongClickListener(OnItemLongClickListener(action))
}

inline fun AdapterView<out Adapter?>.setOnItemClickListener(crossinline action: (AdapterView<out Adapter?>?, View?, Int, Long) -> Unit) {
    setOnItemClickListener(OnItemClickListener(action))
}