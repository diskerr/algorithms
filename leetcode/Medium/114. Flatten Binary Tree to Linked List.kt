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
    fun flatten(root: TreeNode?): Unit {
        if (root == null) return

        flattenImpl(root)
    }

    private fun flattenImpl(node: TreeNode): TreeNode {
        return when {
            node.left == null && node.right == null -> node
            node.left == null -> flattenImpl(node.right)
            else -> {
                val leftLeaf = flattenImpl(node.left)
                val rightLeaf = node.right?.let { flattenImpl(it) }
                leftLeaf.right = node.right
                node.right = node.left
                node.left = null
                rightLeaf ?: leftLeaf
            }
        }
    }
}
