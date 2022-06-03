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