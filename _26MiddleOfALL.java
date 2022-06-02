//Leetcode - 876 - Middle of the Linked List

//Naive Approach - 2 Traversal
//time comp - O(n) - space comp - O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        // first traversal - get count of nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        // 2nd traversal - to get (n/2)th node
        ListNode curr = head;
        for (int i = 0; i < (count / 2); i++) {
            curr = curr.next;
        }
        return curr;
    }
}


//Efficient Approach - Using Hare & Tortoise Method
//time comp - O(n) - space comp - O(1)

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // for even - fast!=null && for odd - fast.next!=null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}