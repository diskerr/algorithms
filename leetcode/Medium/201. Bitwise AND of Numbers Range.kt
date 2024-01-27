// https://leetcode.com/problems/bitwise-and-of-numbers-range/solutions/4090679/java-2-line-solution-and-kotlin-1-line-solution-no-iteration-and-no-floating-point-math/
class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int =
        (32 - (left xor right).countLeadingZeroBits()).let { left shr it shl it }
}
