//Leetcode - 160 - Intersection of Two Linked Lists

//Brute Force - 2 nested loops - time comp - O(m*n) - space comp - O(1)

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

//Optimised Approach - Using Hashing 
//time comp - O(m+n) - space comp - O(m)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        for (ListNode temp = headB; temp != null; temp = temp.next) {
            if (set.contains(temp))
                return temp;
        }
        return null;
    }
}