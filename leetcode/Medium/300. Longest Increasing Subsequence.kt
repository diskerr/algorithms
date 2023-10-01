// 처음 accept 받은 O(N^2) 솔루션
// class Solution {
//     fun lengthOfLIS(nums: IntArray): Int {
//         val n = nums.size
//         val d = IntArray(n) { 1 }
//         var l = 1

//         for (i in 1 until n) {
//             for (j in 0 until i) {
//                 if (nums[j] < nums[i]) {
//                     d[i] = max(d[j] + 1, d[i])
//                     l = max(l, d[i])
//                 }
//             }
//         }

//         return l
//     }
// }

// LeetCode 최적 솔루션을 참고한 O(log N) 버전.
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val d = IntArray(n) { 1 }
        var l = 1

        for (i in 1 until n) {
            val p = if (nums[l - 1] < nums[i]) l++ else lowerBound(nums, 0, l, nums[i])
            nums[p] = nums[i]
        }

        return l
    }

    private fun lowerBound(arr: IntArray, l: Int = 0, r: Int = arr.size, value: Int): Int {
        var left = l
        var right = r
        
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < value) left = mid + 1 else right = mid
        }
        
        return left
    }
}
