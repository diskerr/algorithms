class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (y in 0 until n - 1) {
            for (x in y until n - y - 1) {
                var cx = x
                var cy = y
                var tmp = matrix[y][x]

                repeat(4) {
                    cy = cx.also { cx = n - cy - 1}
                    tmp = matrix[cy][cx].also { matrix[cy][cx] = tmp }
                }
            }
        }
    }
}
