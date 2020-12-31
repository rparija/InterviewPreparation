package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.BinarySearchTree.TreeNode;

public class BinarySearchTree {

	static Queue<Integer> queue;
	public BinarySearchTree(TreeNode root) {
		 queue = new LinkedList<>();
        queue=binarySerachTreeIterator(root,queue);
        }
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	static TreeNode root;

	class TreeNode {
		TreeNode right;
		TreeNode left;
		int val;
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root != null && root.val == val) {
			return root;
		}
		TreeNode node = root;
		while (node != null && node.val != val) {
			if (node.val >= val) {
				node = node.left;
				if (node != null && node.val == val) {
					return node;
				}
			} else {
				node = node.right;
				if (node != null && node.val == val) {
					return node;
				}
			}
		}
		return null;
	}

	public static TreeNode insertNode(TreeNode root, int val) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode newnode = bst.new TreeNode();
		newnode.val = val;
		newnode.left = null;
		newnode.right = null;
		if (root == null) {

			root = newnode;
			return root;
		} else {
			TreeNode oldNode = root;
			while (oldNode != null) {
				if (oldNode.val > val) {
					if (oldNode.left == null) {
						oldNode.left = newnode;
						break;
					}
					oldNode = oldNode.left;
				} else {
					if (oldNode.right == null) {
						oldNode.right = newnode;
						break;
					}
					oldNode = oldNode.right;

				}
			}

			return root;
		}

	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		} else {
			TreeNode node = root;
			while (node != null
					&& ((node.right != null && node.right.val != key) && (node.left != null && node.left.val != key))) {
				if (node.val > key) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			if (node != null
					&& ((node.right != null && node.right.val == key) || (node.left != null && node.left.val == key))) {
				if (node.right.val == key) {
					TreeNode temp = node.right;
					if (temp.right == null && temp.left == null) {
						temp = node;
						temp.right = null;
					} else if (temp.right != null) {
						node.right = temp.right;
					} else if (temp.left != null) {
						node.right = temp.left;
					} else {

						TreeNode minNode = findMinimumInNode(temp, key);
						if (minNode.val == key) {
							node.right = null;
						} else {
							deleteNodeFromBST(node, minNode.val);
							node.right.val = minNode.val;
						}
					}
				} else if (node.left.val == key) {
					TreeNode temp = node.right;
					if (temp.right == null && temp.left == null) {
						temp.right = null;
					} else if (temp.right != null) {
						node.left = temp.right;
					} else if (temp.left != null) {
						node.left = temp.left;
					} else {
						TreeNode minNode = findMinimumInNode(temp, key);
						if (minNode.val == key) {
							node.left = null;
						} else {

							deleteNodeFromBST(node, minNode.val);
							node.left.val = minNode.val;
						}
					}
				}
			}
			return node;
		}
	}

	public static void deleteNodeFromBST(TreeNode node, int key) {

		while (node != null
				&& ((node.right != null && node.right.val != key) && (node.left != null && node.left.val != key))) {
			if (node.val > key) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		if (node.left.val == key) {
			TreeNode temp = node.left;
			node.left = temp.right;
		}

	}

	public static TreeNode findMinimumInNode(TreeNode temp, int key) {
		int minVal = temp.val;
		while (temp.left != null) {
			if (temp.left.val < minVal) {
				minVal = temp.left.val;
				temp = temp.left;
			}
		}
		return temp;
	}

	public static TreeNode deleteUsingRecursion(TreeNode root, int key) {
		if (root == null) {
			return root;
		} else {
			if (root.val > key) {
				root.left = deleteUsingRecursion(root.left, key);
			} else if (root.val < key) {
				root.right = deleteUsingRecursion(root.right, key);
			} else {
				if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				}
				root.val = minNode(root.right);
				root.right = deleteUsingRecursion(root.right, root.val);

			}
		}
		return root;
	}

	public static int minNode(TreeNode root) {
		return root.left == null ? root.val : minNode(root.left);
	}

	public static void printpreOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.val + ",");
			printpreOrder(root.left);
			printpreOrder(root.right);
		}
	}
	
	public static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			printInOrder(root.left);
			System.out.print(root.val + ",");
			printInOrder(root.right);
		}
	}

	public static void printpostOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			printInOrder(root.left);
			printInOrder(root.right);
			System.out.print(root.val + ",");

		}
	}

	public static void printLevelOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			
			Queue<TreeNode> queue= new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty())
			{
				TreeNode node=queue.peek();
				System.out.print(node.val+",");
				if(node.left!=null)
				{
					queue.add(node.left);
				}
				if(node.right!=null)
				{
					queue.add(node.right);
				}
				queue.poll();
			}

		}
	}
	public static int height(TreeNode root)
	{
		if(root==null)
		{
			return -1;
		}
		int leftNodeHeight=height(root.left);
		int rightNodeHeight=height(root.right);
		return java.lang.Math.max(leftNodeHeight,rightNodeHeight)+1;
	}

	
	 public Queue <Integer> binarySerachTreeIterator(TreeNode root,Queue <Integer> queue )
		{
			if(root==null)
			{
				return null;
			}
			binarySerachTreeIterator(root.left,queue);
			queue.add(root.val);
			binarySerachTreeIterator(root.right,queue);
	        return queue;
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
	 
	 public static void isBinarySearchTree(TreeNode root)
	 {
		 int findMax=findMaxUsingRecursion(root.left);
		 int findMin=findMinUsingRecursion(root.right);
		 if(findMax<root.val && root.val<findMin)
		 {
			 System.out.println("BinarySearchTree.isBinarySearchTree()");
		 }
	 }
	public static void main(String[] args) {
		TreeNode root = insertNode(null, 5);
		insertNode(root, 3);
		insertNode(root, 6);
		insertNode(root, 2);
		insertNode(root, 4);
		insertNode(root, 7);
		// findMinimumInNode(root, 3);
		//deleteUsingRecursion(root, 3);
		printInOrder(root);
		System.out.println();
		printpreOrder(root);
		System.out.println();
		printpostOrder(root);
		System.out.println();
		printLevelOrder(root);
		System.out.println("height of root is"+height(root));
		BinarySearchTree bst= new BinarySearchTree(root);
		System.out.println(bst.binarySerachTreeIterator(root, queue));
		isBinarySearchTree(root);
		}
}
//