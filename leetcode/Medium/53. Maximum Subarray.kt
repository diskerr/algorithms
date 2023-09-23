class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var prev = max

        for (i in 1..nums.lastIndex) {
            prev = if (prev > 0) prev + nums[i] else nums[i]            
            if (max < prev) max = prev
        }

        return max
    }
}
