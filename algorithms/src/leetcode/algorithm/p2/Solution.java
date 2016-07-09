package leetcode.algorithm.p2;

/**
 * p2: https://leetcode.com/problems/add-two-numbers/
 *
 * @author xinquan.huangxq
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        // sum of carry
        int carry = 0;
        ListNode l3 = result;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;

            l3.val = sum % 10;
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 != null || l2 != null) {
                ListNode l4 = new ListNode(0);
                l3.next = l4;
                l3 = l4;
            }
        }
        if (carry > 0) {
            ListNode l4 = new ListNode(carry);
            l3.next = l4;
        }
        return result;
    }
}

