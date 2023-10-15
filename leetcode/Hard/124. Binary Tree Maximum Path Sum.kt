/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int = solve(root).let { max(maxSum, it) }

    private fun solve(root: TreeNode?): Int = root?.let {
        val leftSum = max(0, solve(it.left))
        val rightSum = max(0, solve(it.right))

        maxSum = max(maxSum, leftSum + rightSum + it.`val`)
        max(leftSum, rightSum) + it.`val`
    } ?: 0
}
