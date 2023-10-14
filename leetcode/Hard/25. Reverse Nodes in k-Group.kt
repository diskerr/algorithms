/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k == 1) return head

        return solve(head!!, k)
    }

    private fun solve(head: ListNode, k: Int): ListNode {
        var cur = head
        var n = 1

        while (cur.next != null && n < k) {
            ++n
            cur = cur.next
        }

        if (n < k) return head

        var prev = head
        cur = head.next!!
    
        for (i in 1 until k) {
            val next = cur.next
            
            cur.next = prev
            prev = cur
            
            if (next != null) {
                cur = next
            } else {
                // end of the list
                head.next = null
                return prev
            }
        }

        head.next = solve(cur, k)

        return prev
    }
}
