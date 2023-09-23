class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val mn = m * n

        var top = 0
        var bottom = m - 1
        var left = 0
        var right = n - 1
        val result = mutableListOf<Int>()

        while (result.size < mn) {
            for (i in left..right) result.add(matrix[top][i])
            ++top

            for (i in top..bottom) result.add(matrix[i][right])
            --right

            for (i in right downTo left) result.add(matrix[bottom][i])
            --bottom
 
            for (i in bottom downTo top) result.add(matrix[i][left])
            ++left
        }

        return result.take(mn)
    }
}
