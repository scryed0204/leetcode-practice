package com.liamtang.otherpractice.tree.rbt;

public class TreeNode {

	private TreeNode leftchild;
	private TreeNode rightchild;
	private TreeNode parent;
	private String element;
	private int key;
	private short color; // 0: Red, 1: Black; using type:bool is ok

	public TreeNode getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
		if (leftchild != null) leftchild.parent = this;
	}

	public TreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(TreeNode rightchild) {
		this.rightchild = rightchild;
		if (rightchild != null) rightchild.parent = this;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public short getColor() {
		return color;
	}

	public void setColor(short color) {
		this.color = color;
	}

}
