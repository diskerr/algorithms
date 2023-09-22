// HARD라고 하기엔 좀 민망한 난이도.. 시키는 대로 하면 됨.
class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val n = words.size
        var first = 0
        val result = mutableListOf<String>()

        while (first < n) {
            var last = first + 1
            var len = words[first].length
            
            while (last < n) {
                val newLen = words[last].length + 1
                if (len + newLen > maxWidth) break
                len += newLen
                ++last
            }

            val justified = buildString(maxWidth) {
                var remainedSpace = maxWidth - len

                for (i in first until last - 1) {
                    append(words[i])

                    val padding = if (last == n) {
                        0
                    } else {
                        val denom = last - i - 1
                        if (denom < 2) remainedSpace else ceil(remainedSpace.toDouble() / denom).toInt()
                    }
                    
                    for (i in 0..padding) append(" ")

                    remainedSpace -= padding
                }

                append(words[last - 1] + " ".repeat(remainedSpace))
            }

            result.add(justified)
            first = last
        }

        return result
    }
}
