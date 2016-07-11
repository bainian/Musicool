package cn.guoguoa.kotlinlibrary

import android.accounts.AccountManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager

/**
 * Created by sage on 16-6-29.
 */
val Context.displayWidth: Int
    get() = resources.displayMetrics.widthPixels

val Context.displayHeight: Int
    get() = resources.displayMetrics.heightPixels

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)

val Context.accessibilityManager: AccessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

val Context.accountManager: AccountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager


