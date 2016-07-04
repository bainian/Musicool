package cn.guoguoa.kotlinlibrary

import android.database.Cursor
import java.util.*

/**
 * Created by sage on 16-6-28.
 */

inline fun <T, C : MutableCollection<T>> Cursor?.mapTo(result: C, transform: Cursor.() -> T): C {
    return if (this == null) {
        return result
    } else {
        if (moveToFirst()) {
            do {
                result.add(transform())
            } while (moveToNext())
        }
        result
    }
}

inline fun <T> Cursor?.map(transform: Cursor.() -> T): MutableCollection<T> {
    return mapTo(LinkedList<T>(), transform)
}

inline fun <T> Cursor?.mapAndClose(create: Cursor.() -> T): MutableCollection<T> {
    try {
        return map(create)
    } finally {
        this?.close()
    }
}