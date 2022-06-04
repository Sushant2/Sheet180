//leetcode - 138 - Copy List with random pointer

//Brute force - using hashing
//time comp - O(n) + O(n) 
//space comp - O(n)
class Solution {
    public Node copyRandomList(Node head) {
        // keep a hashmap of original node & it's clonedNode
        HashMap<Node, Node> map = new HashMap<>();
        // make deep copies of each node from original LL
        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            // initially jsut assign val & don't assign any pointer
            // you can think, why node.next can't be assigned, answer is, it's still not
            // created
            map.put(curr, copyNode);
            curr = curr.next;
        }
        // now map is prepared with each node having is cloned copy with null as it's
        // next and random
        // now point next & random pointer for those deep copies from hashMap
        curr = head;
        while (curr != null) {
            // map.get(curr) is clonedNode
            map.get(curr).next = (curr.next != null) ? map.get(curr.next) : null;
            map.get(curr).random = (curr.random != null) ? map.get(curr.random) : null;
            curr = curr.next;
        }
        return map.get(head);
    }
}