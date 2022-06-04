//Leetcode - 61 - Rotate a Linked List

//Brute Force - 
//time comp - O(k*len) - space - O(1)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        // brute force
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        for (int i = 1; i <= k; i++) {
            ListNode curr = head, prev = null;
            ;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            curr.next = head;
            prev.next = null;
            head = curr;
        }
        return head;
    }
}
