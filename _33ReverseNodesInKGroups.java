//Leetocode - 25 - Reverse Nodes in k-Group

//time comp - O(n) - space comp - O(1)
class Solution {
    private int findLen(ListNode curr) {
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    // th = temp head, tt = temp tail
    static ListNode th = null, tt = null;

    private void addFirst(ListNode node) {
        // if node is the first node
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        int len = findLen(head);
        // oh = original head, ot = original tail
        ListNode oh = null, ot = null;
        ListNode curr = head;
        while (len >= k) {
            int currK = k;
            while (currK-- > 0) {
                ListNode forward = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forward;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
            len -= k;
        }
        // remaining ele
        ot.next = curr;
        return oh;
    }
}