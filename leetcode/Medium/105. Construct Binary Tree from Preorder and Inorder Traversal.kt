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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode =
        buildTreeImpl(preorder, 0, preorder.lastIndex, inorder, 0, inorder.lastIndex)!!
  
    private fun buildTreeImpl(preorder: IntArray, pl: Int, pr: Int, inorder: IntArray, il: Int, ir: Int): TreeNode? {
        if (pr < pl) return null
    
        return TreeNode(preorder[pl]).apply {
            if (pl < pr) {
                var i = il
                while (inorder[i] != `val`) ++i 
                var leftTreeLen = i - il
                left = buildTreeImpl(preorder, pl + 1, pl + leftTreeLen, inorder, il, il + leftTreeLen - 1)
                right = buildTreeImpl(preorder, pl + leftTreeLen + 1, pr, inorder, il + leftTreeLen + 1, ir)
            }
        }
    }
}
