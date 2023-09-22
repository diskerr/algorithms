/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *r = l1;
        
        for (;;) {
            if (l2 != nullptr) {
                l1->val += l2->val;
                l2 = l2->next;
            }

            carry = l1->val / 10;
            l1->val %= 10;

            if (l1->next == nullptr) {
                if (l2 == nullptr) break;
                l1 = l1->next = new ListNode(carry);
            } else {
                l1 = l1->next;
                l1->val += carry;
            }
        }
        
        if (carry > 0) l1->next = new ListNode(carry);
        
        return r;
    }

private:
    int carry = 0, sum = 0;
};
