// 기본적으로 53번 문제처럼 kadane's algorithm을 쓰되, circular array 이므로 
// (nums 전체 합 - 카데인으로 구한 최소합 부분 수열)도 정답이 될 수 있다. 둘 중 더 큰거 고르면 됨.
// 단 후자의 경우 배열이 모두 음수이면 전체 수열이 빠지는데 문제 조건에서 1개 이상의 원소는 반드시
// 포함해야 한다고 했으므로 이 부분만 따로 처리.
class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        val n = nums.size
        var max = nums[0]
        var min = max
        var sum = max
        var prevMax = max
        var prevMin = max

        var i = 0
        while (++i < n) {
            val cur = nums[i]
            sum += cur

            prevMax = if (prevMax > 0) prevMax + cur else cur
            if (max < prevMax) max = prevMax

            prevMin = if (prevMin < 0) prevMin + cur else cur
            if (min > prevMin) min = prevMin
        }
   
        return if (max < 0) max else max(max, sum - min)
    }
}
