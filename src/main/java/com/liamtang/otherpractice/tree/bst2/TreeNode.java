package com.liamtang.otherpractice.tree.bst2;

public class TreeNode {

	private TreeNode leftchild;
	private TreeNode rightchild;
	private TreeNode parent;
	private String data; // Element
	private int key;     // Key, used for comparison
	
	public TreeNode(int key, String data){
		this.key = key;
		this.data = data;
	}

	public TreeNode getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
		if (null != leftchild)leftchild.parent = this;
	}

	public TreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(TreeNode rightchild) {
		this.rightchild = rightchild;
		if (null != rightchild) rightchild.parent = this;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
