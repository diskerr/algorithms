class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val m = board.size
        val n = board[0].size
     
        val calcRange: (Int, Int) -> IntRange = { v, max -> (if (v > 0) -1 else 0)..(if (v < max - 1) 1 else 0) }
        val finalizeRow: (IntArray) -> Unit = { for (i in 0 until n) it[i] = it[i] shr 1 }

        for (y in 0 until m) {
            val dyRange = calcRange(y, m)

            for (x in 0 until n) {
                val dxRange = calcRange(x, n)
                var liveNeighbors = -board[y][x]

                for (i in dyRange) {
                    for (j in dxRange) {
                        liveNeighbors += (board[y + i][x + j] and 1)
                    }
                }

                if (liveNeighbors == 3) board[y][x] += 2
                else if (liveNeighbors == 2) board[y][x] += board[y][x] shl 1
            }

            if (y > 0) finalizeRow(board[y - 1])
        }

        finalizeRow(board[m - 1])
    }
}
