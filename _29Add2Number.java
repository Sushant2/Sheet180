//Leetcode - 2 - Add two number
//time comp - O(max(n1, n2)) - space comp - O(max(n1, n2))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int d1 = (l1 == null) ? 0 : l1.val;
            int d2 = (l2 == null) ? 0 : l2.val;
            ListNode temp = new ListNode((d1 + d2 + carry) % 10);
            carry = (d1 + d2 + carry) / 10;
            head.next = temp;
            head = temp;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }
}