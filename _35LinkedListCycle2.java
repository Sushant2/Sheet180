//leetcode - 142 - Linked List Cycle 2
//Return the starting node of cycle

//brute force - using hashing
//time comp - O(n) - space comp - O(n)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

//Optimisation using fast,slow & entry pointer 
//time comp - O(n) - space comp - O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null) return null;
        //using slow & fast pointer & entry pointer for finding starting node of loop  
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode entry = head;
                while(entry!=slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}