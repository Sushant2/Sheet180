//Leetcode - 21 - Merge 2 Sorted List

//Naive approach - take extra space - linkedlist
//time comp - O(m+n), space comp - O(m+n)
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