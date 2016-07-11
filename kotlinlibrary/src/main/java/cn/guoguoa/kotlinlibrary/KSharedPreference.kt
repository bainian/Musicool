package cn.guoguoa.kotlinlibrary

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by sage on 16-6-30.
 */

class KSharedPreference<T>(val context: Context, val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    val prefs by lazy { context.getSharedPreferences(KConstant.DB_NAME, Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    fun <U> findPreference(name: String, default: U): U = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }
        res as U
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw java.lang.IllegalArgumentException("this type can be saved into preference")
        }.apply()
    }

}
