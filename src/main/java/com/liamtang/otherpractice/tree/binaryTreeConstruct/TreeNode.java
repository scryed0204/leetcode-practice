package com.liamtang.otherpractice.tree.binaryTreeConstruct;

public class TreeNode {
	
	private TreeNode leftChild;
	
	private TreeNode rightChild;
	
	private TreeNode parent;
	
	private char val;
	
	public TreeNode (char val) {
		this.val = val;
	}
	
	public void setLeftChild(TreeNode child) {
		this.leftChild = child;
		child.parent = this;
	}
	
	public void setRightChild(TreeNode child) {
		this.rightChild = child;
		child.parent = this;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public char getVal() {
		return val;
	}

	public void setVal(char val) {
		this.val = val;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}
	
}
