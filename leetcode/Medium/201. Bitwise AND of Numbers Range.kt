class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int =
        (32 - (left xor right).countLeadingZeroBits()).let { left shr it shl it }
}
