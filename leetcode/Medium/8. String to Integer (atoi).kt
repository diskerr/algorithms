class Solution {
    val regex = """^ *([+-]?)0*(\d+)""".toRegex()
    
    fun myAtoi(s: String): Int =
        regex.find(s)?.groupValues?.let {
            (it.get(1) + it.get(2))
                .take(12)
                .toLong()
                .coerceIn(Int.MIN_VALUE.toLong(), Int.MAX_VALUE.toLong())
                .toInt()
        } ?: 0
}
