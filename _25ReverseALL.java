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

//Pointer Recursive - time comp - O(n) - space comp - O(1)

class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseLLUtil(head, null);
    }

    private ListNode reverseLLUtil(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode ahead = head.next;
        head.next = newHead;
        return reverseLLUtil(ahead, head);
    }
}