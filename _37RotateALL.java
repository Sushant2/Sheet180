//Leetcode - 61 - Rotate a Linked List

//Brute Force

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        //brute force
        for(int i = 1;i<=k;i++){
            ListNode curr = head, prev = null;;
            while(curr.next!=null){
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

