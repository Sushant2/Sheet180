//Coding Ninjas - Ceil In BST

//time comp - O(h)
//space comp - O(1)

  public  static int findCeil(TreeNode<Integer> root, int key) {

        // Write your code here
        int ceil = -1;
        while(root!=null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(key < root.data){
                ceil = root.data;
                root = root.left;
            }else{
                root = root.right;
            }
        }
    return ceil;
    }
}
