class Solution {
    fun isPalindrome(s: String): Boolean =
        s.filter(Char::isLetterOrDigit).lowercase().let { it == it.reversed() }

    // in-place version
    // fun isPalindrome(s: String): Boolean {
    //     var n = s.length
    //     var l = 0
    //     var r = n - 1

    //     while (l < r) {
    //         while (!s[l].isLetterOrDigit()) if (++l == n) return true
    //         while (!s[r].isLetterOrDigit()) --r

    //         if (s[l] != s[r] && s[l].lowercase() != s[r].lowercase()) return false

    //         ++l
    //         --r
    //     }

    //     return true
    // }
}
