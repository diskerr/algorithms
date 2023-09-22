// 쉬운 문제긴 한데, String으로 바꾸지 않고, 좀 더 계산량을 줄인 버전 (leetcode solutions에 올라온 아이디어 참고함)
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false

        var tmp = x;
        var reversed = 0

        while (tmp > reversed) {
            reversed = reversed * 10 + tmp % 10
            tmp = tmp / 10
        }

        return tmp == reversed || tmp == reversed / 10
    }
}
