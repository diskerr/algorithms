// https://www.hackerrank.com/challenges/balanced-brackets
import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
const val OPEN = "({["
const val CLOSE = ")}]"

fun isBalanced(s: String): String {
    if (s.length % 2 == 1) return "NO"
    
    val stack = Stack<Int>()
    
    for (i in s.indices) {
        val c = s[i]
        val oIdx = OPEN.indexOf(c)
        
        when {
            oIdx >= 0 -> stack.push(oIdx)
            stack.isEmpty() || stack.pop() != CLOSE.indexOf(c) -> return "NO"
        }
    }
    
    return if (stack.isEmpty()) "YES" else "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
