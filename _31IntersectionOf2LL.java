//Leetcode - 160 - Intersection of Two Linked Lists

//Brute Force - 2 nested loops - time comp - O(n^2) - space comp - O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // brute force - 2 nested loops
        for (ListNode curr = headA; curr != null; curr = curr.next) {
            for (ListNode temp = headB; temp != null; temp = temp.next) {
                if (curr == temp)
                    return curr;
            }
        }
        return null;
    }
}