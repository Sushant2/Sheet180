// Leetcode - 19 - Remove Nth Node From End of List

// Brute Force - 2 traversals
// time comp - O(2*n) - space comp - O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Brute Force - 2 traversal
        // count no. of nodes/length of LL
        // then find len - n-1 in LL & remove
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        ListNode curr = head;
        for (int i = 0; i < (len - n - 1); i++) {
            curr = curr.next;
        }
        if (n == len)
            return head.next;
        else {
            curr.next = curr.next.next;
        }
        return head;
    }
}

// Efficient Optimised Approach - using single traversal
// time comp - O(n) - space comp - O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // using single pass - 2 pointers approach
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;
        // fast pointer will make the gap of n initially
        for (int i = 1; i <= n; i++)
            fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}