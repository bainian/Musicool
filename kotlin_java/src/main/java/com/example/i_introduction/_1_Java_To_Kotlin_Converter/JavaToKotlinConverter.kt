package i_introduction._1_Java_To_Kotlin_Converter

import com.example.i_introduction._1_Java_To_Kotlin_Converter.JavaCode1
import util.TODO

fun todoTask1(collection: Collection<Int>): Nothing = TODO(
    """
        Task 1.
        Rewrite JavaCode1.task1 in Kotlin.
        In IntelliJ IDEA, you can just copy-paste the code and agree to automatically convert it to Kotlin,
        but only for this task!
    """,
    references = { JavaCode1().task1(collection) })

//1, 2, 3, 42, 555
fun task1(collection: Collection<Int>): String {
//    todoTask1(collection)
    return JavaCode1().task1(collection)
}

