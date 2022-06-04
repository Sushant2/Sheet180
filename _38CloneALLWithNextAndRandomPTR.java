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

//Optimised Code - 3 steps
//time comp - O(n) - space comp - O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // step 1 - create deep copy nodes in between of original LL nodes
        Node prev = head;
        Node curr = null;
        while (prev != null) {
            curr = new Node(prev.val);
            curr.next = prev.next;
            prev.next = curr;
            prev = curr.next;
        }
        // step 2 - assign the random pointers, take care of null
        prev = head;
        while (prev != null) {
            prev.next.random = (prev.random != null) ? prev.random.next : null;
            prev = prev.next.next;
        }
        // step 3- remove references & segreagate original & deep copy list
        prev = head;
        Node copyCurr = prev.next;
        Node copyHead = copyCurr;
        while (prev != null) {
            prev.next = prev.next.next;
            if (copyCurr.next == null)
                break;
            copyCurr.next = copyCurr.next.next;
            prev = prev.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}