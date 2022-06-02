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