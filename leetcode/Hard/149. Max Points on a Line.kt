// O(n^3) 알고리즘. n <= 300이라 충분하고, 실제로 이 크기의 입력에선 유의미한 성능 차이 나지 않는 듯.
// class Solution {
//     fun maxPoints(points: Array<IntArray>): Int {
//         var result = 1
//         for (i in points.indices) {
//             for (j in (i + 1)..points.lastIndex) {
//                 var count = 2
//                 val slope = slope(points[i], points[j])
//                 for (k in (j + 1)..points.lastIndex) {
//                     if (slope(points[j], points[k]) == slope) ++count
//                 }

//                 if (count > result) result = count
//             }
//         }

//         return result
//     }

//     private fun slope(p1: IntArray, p2: IntArray): Double {
//         val dx = p1[0] - p2[0]
//         val dy = p1[1] - p2[1]

//         return if (dx == 0) kotlin.Double.POSITIVE_INFINITY else dy.toDouble() / dx
//     }
// }

// 해시 맵을 이용한 O(n^2) 알고리즘
class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        var result = 1

        for (i in 0 until points.lastIndex) {
            val map = hashMapOf<Double, Int>()

            for (j in (i + 1)..points.lastIndex) {
                val slope = slope(points[i], points[j])
                val count = (map[slope] ?: 1) + 1
                map[slope] = count
                if (result < count) result = count
            }
        }

        return result
    }

    private fun slope(p1: IntArray, p2: IntArray): Double {
        val dx = p1[0] - p2[0]
        val dy = p1[1] - p2[1]

        return when {
            dx == 0 -> kotlin.Double.POSITIVE_INFINITY
            // 부동소수점 표현 방식상 0.0과 -0.0이 따로 있고 이게 hashCode() 가 달라서 해시 맵에 다른 버킷으로 들어간다.
            // 이를 막기 위해 dy == 0인 경우도 따로 처리
            dy == 0 -> 0.0
            else -> dy.toDouble() / dx
        }
    }
}
