class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var head = 1
        
        for (i in 2 until nums.size) {
            if (nums[head] != nums[i] || nums[head - 1] != nums[i]) nums[++head] = nums[i]
        }

        return head + 1
    }
}
