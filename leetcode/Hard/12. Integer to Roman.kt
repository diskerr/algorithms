class Solution {
    private val romanArray = arrayOf(
        1000 to "M",
        900 to "CM",
        500 to "D",    
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    // 재귀 버전
    // fun intToRoman(num: Int): String {
    //     for (i in romanArray) if (num >= i.first) return i.second + intToRoman(num - i.first)
    //     return ""
    // }

    // 반복 버전 (beats 100% of users with Kotlin)
    fun intToRoman(num: Int): String = buildString {
        var n = num
        var i = 0

        while (n > 0) {
            val (value, roman) = romanArray[i]

            if (n >= value) {
                n -= value
                append(roman)
            } else {
                ++i
            }
        }
    }
}
