package practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import practice.Tree;

public class TreePractice {

	static Tree root;

	static TreePractice tp = new TreePractice();

	public static void insertIterativeStyle(int data) {
		if (root == null) {
			Tree tree = new Tree();
			tree.data = data;
			tree.left = null;
			tree.right = null;
			root = tree;
		} else {

			Tree oldNode = root;
			Tree tree = new Tree();
			tree.data = data;
			tree.left = null;
			tree.right = null;
			while (oldNode != null) {
				if (oldNode.data < data) {
					if (oldNode.right == null) {
						oldNode.right = tree;
						break;
					}
					oldNode = oldNode.right;
				} else {
					if (oldNode.left == null) {
						oldNode.left = tree;
						break;
					}
					oldNode = oldNode.left;
				}

			}
		}
	}

	public static boolean search(int data) {
		if (root == null) {
			System.out.println(data + " is not present in the tree");
			return false;
		} else if (root.data == data) {
			System.out.println(data + " is present in the tree");
			return true;
		} else {
			Tree oldNode = root;
			while (oldNode != null) {
				if (oldNode.data > data) {
					if (oldNode.data == data) {
						System.out.println(data + " is present in the tree");
						return true;
					}
					oldNode = oldNode.left;
				} else {
					if (oldNode.data == data) {
						System.out.println(data + " is present in the tree");
						return true;
					}
					oldNode = oldNode.right;
				}
			}
		}
		System.out.println(data + " is not present in the tree");

		return false;
	}

	public static void insertTreeNode(Tree tree, int data) {
		if (tree.data < data) {
			if (tree.right != null) {
				insertTreeNode(tree.right, data);
			} else {
				Tree newTreeNode = new Tree();
				newTreeNode.data = data;
				newTreeNode.left = null;
				newTreeNode.right = null;
				tree.right = newTreeNode;
			}
		} else {
			if (tree.left != null) {
				insertTreeNode(tree.left, data);
			} else {
				Tree newTreeNode = new Tree();
				newTreeNode.data = data;
				newTreeNode.left = null;
				newTreeNode.right = null;
				tree.left = newTreeNode;
			}
		}
	}

	public static void insert(int data) {
		if (root == null) {
			Tree tree = new Tree();
			tree.data = data;
			tree.left = null;
			tree.right = null;
			root = tree;
		} else {
			insertTreeNode(root, data);
		}
	}

	public static void delete(int data) {
		Tree oldNode = root;

		if (oldNode.left == null && oldNode.right == null && oldNode.data == data) {
			oldNode = null;
		}
		while (oldNode != null) {
			if (oldNode.data > data) {
				if (oldNode.left != null) {
					if(oldNode.left.data==data)
					{
						int replaceNodedata=findHighestInLeft(oldNode.left);
						oldNode.left.data=replaceNodedata;
					}
				} else if(oldNode.right !=null)
				{
					if(oldNode.right.data==data)
					{
						int replaceNodedata=findHighestInLeft(oldNode.right);
						oldNode.right.data=replaceNodedata;
					}
				}
				oldNode=oldNode.left;
			}else
			{
				if (oldNode.right != null) {
					oldNode=oldNode.right;
				}	
			}
		}
	}

	public static Tree deleteUsingRecursion(Tree node, int data)
	{
		if(node==null)
		{
			return null;
		}else if(node.right==null && node.left==null && node.data==data)
		{
			node=null;
		}else
		{
			if(node.data>data)
			{
				node.left=deleteUsingRecursion(node.left,data);
			}
			else if(node.data<data)
			{
				node.right=deleteUsingRecursion(node.right,data);
			}else
			{
				if(node.left==null)
				{
					Tree temp=node.right;
					node.right=null;
					node.data=temp.data;
					
				}else if(node.right==null)
				{
					Tree temp=node.left;
					node.left=null;
					node.data=temp.data;
					
				}else
				{
					Tree lowNode=findLowestInRight(node.right);
					Tree temp=node;
					node.data=lowNode.data;
					node.right=deleteUsingRecursion(lowNode, lowNode.data);
				}
			}
		}
		return node;
	}
	public static Tree findLowestInRight(Tree node)
	{
		if(node.left==null)
		{
			return node;
		}
		if(node!=null)
		{
			node=findLowestInRight(node.left);
		}
		return node;
	}
	public static int findHighestInLeft(Tree node) {
		Tree prev=node;
		while(node.left!=null)
		{ 
			prev=node;
			node=node.left;
		}
		int data=prev.left.data;
		prev.left=null;
		return data;
	}

	public static void print(Tree rootNode) {
		if (rootNode == null) {
			return;
		}
		System.out.print(rootNode.data + "-> ");
		print(rootNode.left);
		print(rootNode.right);
	}

	public static void printIterativeStyleLevelOrder(Tree rootNode) {
		Queue<Tree> queue = new LinkedList<>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			System.out.print(queue.peek().data + "-> ");
			Tree node = queue.peek();
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			
			queue.poll();
		}
		System.out.println();
	}

	public static void printIterativePreorder(Tree rootNode) {
		Stack<Tree> stack = new Stack<>();
		stack.push(rootNode);

		while (!stack.isEmpty()) {
			Tree node = stack.pop();
			System.out.print(node.data + "-> ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}

	public static void printIterativeInorder(Tree rootNode) {
		Stack<Tree> stack = new Stack<>();
		stack.push(rootNode);
		Tree node = stack.peek();

		while (!stack.isEmpty()) {

			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			node = stack.pop();
			System.out.print(node.data + "-> ");

		}
	}

	public static void printIterativePostorder(Tree rootNode) {
		Stack<Tree> stack = new Stack<>();
		Stack<Tree> stack1 = new Stack<>();
		stack.push(rootNode);
		Tree node = stack.peek();

		while (!stack.isEmpty()) {
			node = stack.pop();
			stack1.push(node);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}

		}
		while (!stack1.isEmpty()) {

			System.out.print(stack1.pop().data + "-> ");
		}
		System.out.println();
	}
	
	public static void spriralPrintingUsingStack(Tree rootNode)
	{
		Stack<Tree> s1= new Stack<Tree>();
		Stack<Tree> s2= new Stack<Tree>();
		s1.push(rootNode);
		while (!s1.isEmpty())
		{
			System.out.print(s1.peek().data+ "-> ");
			Tree node=s1.pop();
			if(node.left!=null)
			s2.push(node.left);
			if(node.right!=null)
			s2.push(node.right);
			
			while(!s2.isEmpty())
			{
				System.out.print(s2.peek().data+ "-> ");
				Tree node1=s2.pop();
				if(node1.right!=null)
				s1.push(node1.right);
				if(node1.left!=null)
				s1.push(node1.left);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * insert(20); insert(10); insert(30); insert(25); print(root);
		 */
		insertIterativeStyle(20);
		insertIterativeStyle(10);
		insertIterativeStyle(30);
		insertIterativeStyle(25);
		insertIterativeStyle(35);
		insertIterativeStyle(5);
		insertIterativeStyle(12);
		System.out.println("LevelOrder:");
		printIterativeStyleLevelOrder(root);
		System.out.println("PreOrder:");
		printIterativePreorder(root);
		System.out.println("InOrder:");
		printIterativeInorder(root);
		System.out.println("PostOrder:");
		printIterativePostorder(root);
		search(35);
		search(45);
		search(25);
		//delete(10);
		//deleteUsingRecursion(root, 30);
		printIterativePostorder(root);
		System.out.println("SpiralPrint:");
		spriralPrintingUsingStack(root);
	}
}
