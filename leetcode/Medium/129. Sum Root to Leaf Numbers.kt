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
// 재귀 버전이 코드가 더 간단하긴 한데, 처음에 재귀(DFS)로 풀었다가 반복(BFS)으로 바꿔봄.
class Solution {
    data class StackEntry(val node: TreeNode, val sum: Int)

    fun sumNumbers(root: TreeNode?): Int {
        var sum = 0
        val stack = Stack<StackEntry>()

        root?.let { stack.push(StackEntry(it, 0)) }

        while (!stack.empty()) {
            val entry = stack.pop()
            val curNode = entry.node
            val curSum = entry.sum * 10 + curNode.`val`

            if (curNode.left == null && curNode.right == null) {
                sum += curSum
            } else {
                curNode.left?.let { stack.push(StackEntry(it, curSum)) }
                curNode.right?.let { stack.push(StackEntry(it, curSum)) }
            }
        }

        return sum
    }
}
