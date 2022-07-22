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