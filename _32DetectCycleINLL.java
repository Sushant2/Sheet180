//Leetcode - 141 - Linked List Cycle

//Brute Force - using hasing
//time comp - O(n) - space comp - O(n)

public class Solution {
    public boolean hasCycle(ListNode head) {
        // brute force - using hashing
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}


//Optimised Approach - using 2 pointers - fast & slow
//time comp - O(n) - space comp - O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        // using efficient method - using 2 pointers - fast & slow
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}