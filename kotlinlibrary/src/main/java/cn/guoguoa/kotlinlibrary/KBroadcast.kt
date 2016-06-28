package cn.guoguoa.kotlinlibrary

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by sage on 16-6-28.
 */


inline fun BroadcastReceiver(crossinline init: (Context?, Intent?) -> Unit): BroadcastReceiver {
    return object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            init(p0, p1)
        }
    }
}
