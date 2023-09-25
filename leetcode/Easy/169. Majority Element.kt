class Solution {
    fun majorityElement(nums: IntArray): Int {
        var e = nums[0]
        var count = 1

        for (n in 1..nums.lastIndex) {
            if (count == 0) e = nums[n]
            count += if (nums[n] == e) 1 else -1
        }

        return e
    }
}
