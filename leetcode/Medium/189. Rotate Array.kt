// 간단 풀이. 공간 O(k), 시간 O(n) 버전.
// class Solution {
//     fun rotate(nums: IntArray, k: Int): Unit {
//         val n = nums.size
//         val rk = k % n
//         if (rk == 0) return

//         val kNums = nums.slice(n - rk until n)
//         for (i in (n - 1) downTo rk) nums[i] = nums[i - rk]
//         for (i in 0 until rk) nums[i] = kNums[i]
//     }
// }

// in-place 버전 #1 (자체 풀이)
// class Solution {
//     fun rotate(nums: IntArray, k: Int): Unit {
//         val n = nums.size
//         val rk = k % n
//         if (rk == 0) return

//         var touched = 0

//         for (i in 0 until rk) {
//             var a = n - rk + i
//             var value = nums[a]

//             do {
//                 val b = (a + rk) % n
//                 val cur = nums[b]
//                 nums[b] = value
//                 a = b
//                 value = cur
//                 ++touched
//             } while(a != n - rk + i)

//             if (touched == n) break
//         }
//     }
// }

// in-place 버전 #2 (leetcode solutions 참고, 제일 깔끔한 솔루션)
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        val rk = k % n

        if (rk != 0) {
            nums.reverse(n - rk, n)
            nums.reverse(0, n - rk)
            nums.reverse(0, n)
        }
    }
}
