// 어려운 문제는 아닌데, 다른 문제 난이도를 볼 때 이 문제가 Easy인 건 좀..?
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? = makeTree(nums, 0, nums.size)

    private fun makeTree(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left >= right) return null

        val mid = (right + left) / 2

        return TreeNode(nums[mid]).apply {
            this.left = makeTree(nums, left, mid)
            this.right = makeTree(nums, mid + 1, right)
        }
    }
}
