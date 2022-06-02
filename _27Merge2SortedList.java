//Leetcode - 21 - Merge 2 Sorted List

//Naive approach - take extra space - linkedlist
//time comp - O(n1+n2), space comp - O(n1 + n2)
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //using external space - additional linkedlist
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(list1!=null && list2!=null){
            ListNode temp;
            if(list1.val < list2.val){
                temp = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                temp = new ListNode(list2.val);
                list2 = list2.next;
            }
            head.next = temp;
            head = head.next;
        }
        //copy remaining
        if(list1!=null) 
            head.next = list1;
        else
            head.next = list2;
        return dummy.next;
}

//Efficient Method - Without using extra space
//time comp - O(n1+n2) - space - O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //using efficient approach - without extraspace
        //edge case
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        //if remaining 
        if(list1!=null) tail.next = list1;
        else
            tail.next = list2;
        return dummy.next;
    }
}