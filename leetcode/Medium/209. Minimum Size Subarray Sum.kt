// 참고: 문제 해설에는 O(n^2)도 ACCEPTED 받을 수 있다고 하지만 실제로 저지를 받아보면 자기네들이 제안한 O(n^2) 해법 2가지도 TLE가 나고,
// 또 다른 방법으로 계산을 줄여도 TLE가 난다. 물론 TLE 나는 케이스에 대한 예외 처리(10000 * 현재부분배열크기 < target인 경우) 꼼수로 통과할 수 있긴 하다.
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var left = 0
        var answer = nums.size + 1

        for (right in nums.indices) {
            sum += nums[right]

            while (sum >= target) {
                answer = min(answer, right - left + 1)
                sum -= nums[left++]
            }
        }

        return if (answer <= nums.size) answer else 0
    }
}
