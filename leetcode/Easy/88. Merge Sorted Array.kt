// 해법: nums1 뒤에 공간이 있으므로 배열 뒤에서 큰 숫자 부터 골라서 집어넣으면 됨
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var mi = m - 1
        var ni = n - 1
        var index = m + n - 1

        while (ni >= 0) {
            when {
                mi < 0 || nums2[ni] > nums1[mi] -> {
                    nums1[index] = nums2[ni]
                    --ni
                }
                else -> {
                    nums1[index] = nums1[mi]
                    --mi
                }
            }

            --index
        }

        // debug
        println("${nums1.joinToString(",")}")
    }
}
