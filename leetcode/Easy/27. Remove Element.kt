class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        // 쉽게 생각하면 배열 순회하면서 value 지우고 그 뒤에거 하나씩 당기면 된다.
        // 단 이러면 n이 배열 원소 갯수일 때 O(n^2)으로 비효율적
        // 좀 더 효율적으로 하는 방법은? 맨 뒤 원소를 가져와 채우면 된다. 이 방법은 배열 순서 유지가 안된다.
        // 하지만 문제에 원래 순서를 지켜야 한다는 제약이 없다.
        var tail = nums.size - 1
        var head = 0

        while (head <= tail) {
            if (nums[head] == value) {
                nums[head] = nums[tail]
                --tail
            } else {
                ++head
            }
        }

        return head
    }
}
