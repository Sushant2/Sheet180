// Leetcode - 237 - Delete a node in LinkedList

//Code - time comp - O(1) - Space comp - O(1)
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}