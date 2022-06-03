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
