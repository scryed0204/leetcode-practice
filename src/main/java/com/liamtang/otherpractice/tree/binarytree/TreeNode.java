package com.liamtang.otherpractice.tree.binarytree;

public class TreeNode {
	
	private TreeNode leftChild;
	
	private TreeNode rightChild;
	
	private TreeNode parent;
	
	private String val = null;
	
	public TreeNode (String val) {
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

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}
	
}
