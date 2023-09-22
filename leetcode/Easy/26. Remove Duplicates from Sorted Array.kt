class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var head = 0
        
        for (pos in 1 until nums.size) {
            if (nums[pos] != nums[head]) nums[++head] = nums[pos]
        }

        return head + 1
    }
}
