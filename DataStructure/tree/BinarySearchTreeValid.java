package tree;

import tree.BinarySearchTree.TreeNode;

public class BinarySearchTreeValid {

    public static boolean isValidBST(TreeNode root) {
        
        
         if(root==null || (root!=null && (root.left==null && root.right==null)))
         {
             return true;
         }
        if(height(root)==1 && root.left==null)
         {
             if(root.val<root.right.val)
             {
                 return true;
             }else
             {
                 return false;
             }
         }
        if(height(root)==1 && root.right==null)
         {
             if(root.val>root.left.val)
             {
                 return true;
             }else
             {
                 return false;
             }
         }
		 int findMax=findMaxUsingRecursion(root.left);
		 int findMin=findMinUsingRecursion(root.right);
		 if(findMax<root.val && root.val<findMin)
		 {
			 return true;
		 }
	 return false;
    }
  
    public static int height(TreeNode root)
    {
        if(root==null)
        {
            return -1;
        }
        int maxLeft=height(root.left);
        int maxRight=height(root.right);
        return java.lang.Math.max(maxLeft,maxRight)+1;
    }
     public static int findMinUsingRecursion(TreeNode root)
	 {
		 if(root==null)
		 {
			 return -1;
		 }else
		 {
			 findMinUsingRecursion(root.left);
			 return root.val;
		 }
	 }
	 
	 public static int findMaxUsingRecursion(TreeNode root)
	 {
		 if(root==null)
		 {
			 return -1;
		 }else
		 {
			 findMinUsingRecursion(root.right);
			 return root.val;
		 }
	 }
	 
	 public static void main(String[] args) {
		 BinarySearchTree bst= new BinarySearchTree();
		 TreeNode root = bst.insertNode(null, 10);
		 bst.insertNode(root, 5);
		 bst.insertNode(root, 15);
		 bst.insertNode(root, 6);
		 bst.insertNode(root, 20);
		 System.out.println(isValidBST(root));
	}
}
