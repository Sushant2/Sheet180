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


//Optimised Code - time comp - O(len) + O(len - (len%k)) - space cpmp - O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // optimised approach
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        ListNode newEnd = head;
        // link last node to first node
        curr.next = head;
        // when k is more than length of list
        k = k % len;
        for (int i = 1; i < len - k; i++) {
            newEnd = newEnd.next;
        }
        head = newEnd.next;
        newEnd.next = null;
        return head;
    }
}
