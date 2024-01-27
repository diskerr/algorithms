class Solution {
    fun candy(R: IntArray): Int {
        val N = R.size - 1
        var C = IntArray(N + 1)

        C[0] = 1
        
        for (i in 1..N) {
            C[i] = if (R[i - 1] < R[i]) C[i - 1] + 1 else 1
        }

        var sum = C[N]
        for (i in N - 1 downTo 0) {
            if (R[i] > R[i + 1] && C[i] <= C[i + 1]) C[i] = C[i + 1] + 1
            sum += C[i]
        }

        return sum
    }
}
