package com.liamtang.otherpractice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree {

	Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		}

		else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	public static BinarySearchTree createRandomTree(int size, int bound) {
		BinarySearchTree bt = new BinarySearchTree();

		Random rd = new Random();

		for (int i = 0; i < size; i++) {
			bt.add(rd.nextInt(bound));
		}

		return bt;
	}
	
	public static BinarySearchTree createTestTree() {
		BinarySearchTree bt = new BinarySearchTree();
		
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
		
		return bt;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (null == current) {
			return false;
		}

		if (current.value > value) {
			return containsNodeRecursive(current.right, value);
		} else if (current.value < value) {
			return containsNodeRecursive(current.left, value);
		} else {
			return true;
		}

	}
	
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
		if (null == current) {
			return null;
		}
		
		if (value == current.value) {
			if (null == current.left && null == current.right) {
				return null;
			}
			
			if (null == current.left) {
				return current.right;
			}
			
			if (null == current.right) {
				return current.left;
			}
			
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
		}
		
		if (value > current.value) {
			current.right = deleteRecursive(current.right, value);
		}
		
		return current;
	}
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left); 
	}
	
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public String treverseLevelOrder() {
		if (root == null) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		Node node;
		
		while(!nodes.isEmpty()) {
			node = nodes.remove();
			
			result.append(" " + node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
		
		return result.toString();
		
	}

	private class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

}
