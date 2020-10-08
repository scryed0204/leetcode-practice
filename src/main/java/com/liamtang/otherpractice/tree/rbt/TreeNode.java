package com.liamtang.otherpractice.tree.rbt;

public class TreeNode {

	private TreeNode leftchild;
	private TreeNode rightchild;
	private TreeNode parent;
	private String element;
	private Integer key;
	private NodeColor color;
	
	public static TreeNode generateNeel() {
		TreeNode neel = new TreeNode(NodeColor.BLACK);
		return neel;
	}
	
	private TreeNode(NodeColor color) {
		this.color = color;
	}
	
	public TreeNode(String element, int key, NodeColor color) {
		super();
		this.element = element;
		this.key = key;
		this.color = color;
	}
	
	public TreeNode(String element, int key, NodeColor color, TreeNode neel) {
		this(element, key, color);
		setNeel(neel);
	}
	
	public void setNeel(TreeNode neel) {
		if (leftchild == null) leftchild = neel;
		if (rightchild == null) rightchild = neel;
	}

	public TreeNode getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
	}

	public TreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(TreeNode rightchild) {
		this.rightchild = rightchild;
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

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}
	
	public enum NodeColor {
	    RED, BLACK;
	}

}
