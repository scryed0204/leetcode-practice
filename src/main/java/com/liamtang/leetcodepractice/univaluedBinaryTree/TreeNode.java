package com.liamtang.leetcodepractice.univaluedBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	private TreeNode addRecursive(TreeNode current, int value) {
		if (current == null) {
			return new TreeNode(value);
		}

		if (value < current.val) {
			current.left = addRecursive(current.left, value);
		}

		else if (value > current.val) {
			current.right = addRecursive(current.right, value);		
		} 
		
		else if (value == current.val) {
			return current;			
		}
		
		return current;

	}
	
	public TreeNode add(int value) {
		return addRecursive(this, value);
	}
	
	private String traverseInOrderUtil(TreeNode node, List<String> result) {
		if (node != null) {
			traverseInOrderUtil(node.left, result);
//			System.out.println(" " + node.value);
			result.add(node.val + "");
			traverseInOrderUtil(node.right, result);
			return Arrays.toString(result.toArray());
		}
		
		return "";
	}
	
	private String traverseReverseInOrderUtil(TreeNode node, List<String> result) {
		if (node != null) {
			traverseInOrderUtil(node.right, result);
			result.add(node.val + "");
			traverseInOrderUtil(node.left, result);
//			System.out.println(" " + node.value);
			return Arrays.toString(result.toArray());
		}
		
		return "";
	}
	
	public String traverseReverseInOrder() {
		return traverseReverseInOrderUtil(this, new LinkedList<String>());
	}
	
	/*
	 * Left - Root - Right
	 */
	public String traverseInOrder() {
		return traverseInOrderUtil(this, new LinkedList<String>());
	}
	
	public String treverseLevelOrder() {
		if (this == null) {
			return "";
		}
		
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(this);
		
		List<String> result = new LinkedList<>();
		TreeNode node;
		while(!nodes.isEmpty()) {
			node = nodes.remove();
			
			result.add(node.val + "");
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
		
		return Arrays.toString(result.toArray());
		
	}
}
