//Leetcode - 234 - Palindome A LL

//Brute Force - using extra DS to store the list & iterate to check palindrome
//time comp - O(n) - space comp - O(n)

class Solution {
    public boolean isPalindrome(ListNode head) {
        // brute force
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        // iterate on the array, & check palindrome
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - i - 1))
                return false;
        }
        return true;
    }
}

// Optimal Approach -
// steps - find middle, reverse right half, compare first & second half
// time comp - O(n) - space comp - O(1)

class Solution {
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null; // to get the mid in case of even no. of nodes
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // in case of even size of LL
        if (fast == null)
            return prev;
        return slow;
    }

    private ListNode reverse(ListNode node) {
        // uisng pointer iterative
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // find middle of LL
        ListNode mid = getMiddle(head);
        // to get the right half reversed of LL
        ListNode second = reverse(mid.next);
        while (head != null && second != null) {
            if (head.val != second.val)
                return false;
            head = head.next;
            second = second.next;
        }
        return true;
    }
}