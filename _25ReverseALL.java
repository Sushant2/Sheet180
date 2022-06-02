//Leetcode - 206 - Reverse A Linked List 

//Pointer Iterative 
// time comp - O(n) - space comp - O(1)

class Solution {
    public ListNode reverseList(ListNode head) {
        // pointer iterative
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
}
