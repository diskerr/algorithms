// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
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
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val distinctRanks = ranked.distinct()
    val result = Array<Int>(player.size) { 1 }
    
    var i = distinctRanks.lastIndex
    
    for ((index, score) in player.withIndex()) {
        while (i >= 0) {
            when {
                distinctRanks[i] == score -> {
                    result[index] = i + 1
                    break
                }
                distinctRanks[i] > score -> {
                    result[index] = i + 2
                    break
                }
            }
            
            --i
        }
        
        if (i == -1) break
    }
    
    return result
}

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}
