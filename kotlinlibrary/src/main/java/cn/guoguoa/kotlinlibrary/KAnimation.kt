package cn.guoguoa.kotlinlibrary

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

/**
 * Created by sage on 16-6-29.
 */

inline fun Context.loadAnimation(id: Int): Animation = AnimationUtils.loadAnimation(applicationContext, id)