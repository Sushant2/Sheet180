//GFG - Kth largest element in BST

//Better approach - 
//time comp - O(h)
//space comp - O(h)

class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int ans;
    private int reverseInorder(Node root, int K){
        if(root==null)
            return K;
        
        int nk=reverseInorder(root.right,K);
        nk--;
        
        if(nk==0){
            ans=root.data;
            return -1;
        }
        else if(nk<0)
            return -1;
        
        return reverseInorder(root.left,nk);
    }
    public int kthLargest(Node root,int K)
    {
        //Your code here
        reverseInorder(root,K);
        return ans;
    }
}

//Using Reverse Morris Inorder Traversal

//time comp - O(h)
//space comp - O(1)

class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        // using morris traversal

        Node curr = root;
        int ans = 0;

        while (curr != null) {
            if (curr.right == null) {
                k--;
                if (k == 0)
                    ans = curr.data;
                curr = curr.left;
            } else {
                Node ios = curr.right;
                while (ios.left != null && ios.left != curr) {
                    ios = ios.left;
                }
                if (ios.left == null) {
                    ios.left = curr;
                    curr = curr.right;
                } else {
                    ios.left = null;
                    k--;
                    if (k == 0)
                        ans = curr.data;
                    curr = curr.left;
                }
            }
        }
        return ans;
    }
}