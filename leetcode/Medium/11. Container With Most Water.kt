class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.size - 1

        while (l < r) {
            max = max(max, (r - l) * min(height[r], height[l]))
            if (height[r] < height[l]) --r
            else ++l
        }

        return max
    }
}
