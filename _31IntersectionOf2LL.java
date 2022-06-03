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

//Most Optimised Code - using difference of length
//if m is the length of longer list 
//time comp - O(2*m) - space comp - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // most optimised - first method - difference of length
        // first step find length of both the lists
        int len1 = 0;
        int len2 = 0;
        ListNode dummy1 = headA, dummy2 = headB;
        while (dummy1 != null || dummy2 != null) {
            if (dummy1 != null) {
                len1++;
                dummy1 = dummy1.next;
            }
            if (dummy2 != null) {
                len2++;
                dummy2 = dummy2.next;
            }
        }
        // second step - difference of len1, len2
        int diff = 0;
        if (len1 > len2)
            diff = len1 - len2;
        else
            diff = len2 - len1;

        // third step - move longer length LL by differnce achieved
        dummy1 = headA;
        dummy2 = headB;
        if (len1 > len2) {
            while (diff-- > 0)
                dummy1 = dummy1.next;
        } else {
            while (diff-- > 0)
                dummy2 = dummy2.next;
        }

        while (dummy1 != null && dummy2 != null) {
            if (dummy1 == dummy2)
                return dummy1;
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }
        return null;
    }
}