class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val d = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

        for (i in 0..m) d[i][0] = i
        for (i in 0..n) d[0][i] = i

        for (i in 1..m) {
            for (j in 1..n) {
                d[i][j] = min(
                    d[i - 1][j - 1] + if (word1[i - 1] == word2[j - 1]) 0 else 1,
                    d[i - 1][j] + 1, 
                    d[i][j - 1] + 1 
                )
            }
        }

        return d[m][n]
    }

    private fun min(a: Int, b: Int, c: Int): Int = min(min(a, b), c)
}
