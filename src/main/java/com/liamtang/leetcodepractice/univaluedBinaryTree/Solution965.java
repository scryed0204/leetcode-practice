package com.liamtang.leetcodepractice.univaluedBinaryTree;

public class Solution965 {
	private int val;
	
    public boolean isUnivalTree(TreeNode root) {
		if (null == root) {
			return false;			
		}
		
		val = root.val;

        return !traverse(root);
    }
	
	private boolean traverse(TreeNode root) {
		
		if (null == root) {
			return false;			
		}
		
		if (root.val != val) {
			return true;
		} 
		
		if (traverse(root.right)) {
			return true;
		}
		
		if (traverse(root.left)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
	}
}
