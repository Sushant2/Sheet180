//Coding ninjas/GFG - Inorder predecessor and successor for a given key in BST

//time comp - O(h)
//space comp - O(1)

class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       Node curr = root;
       //find inorderSuccessor
       while(root!=null){
       if(key >= root.data)
            root = root.right;
        else{
            s.succ = root;
            root = root.left;
        }
       }
       
       root = curr;
       
       //find inorderPredecessor
       while(root!=null){
           if(key <= root.data)
                root = root.left;
            else{
                p.pre = root;
                root = root.right;
            }
       }
           
       }
}