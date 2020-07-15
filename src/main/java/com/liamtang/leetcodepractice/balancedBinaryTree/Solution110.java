package com.liamtang.leetcodepractice.balancedBinaryTree;

public class Solution110 {
	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		if (Math.abs(left - right) > 1) {
			return false;
		}

		return (isBalanced(root.left) && isBalanced(root.right));
	}

    public int maxDepth(TreeNode root) {
    	
    	if (null == root) {
    		return 0;
    	}
    	
    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));            
    }
    
//    public int minDepth(TreeNode root) {
//    	
//    	if (null == root) {
//    		return 0;
//    	}
//    	
//    	return 1 + Math.min(maxDepth(root.left), maxDepth(root.right));            
//    }

	public static void main(String args[]) {
		// [1,null,3,2]
		TreeNode root = new TreeNode(1);
		TreeNode n2_1 = null;
		TreeNode n2_2 = new TreeNode(3);
		TreeNode n3_1 = new TreeNode(2);

		root.left = n2_1;
		root.right = n2_2;
		root.right.left = n3_1;

		Solution110 test = new Solution110();
		System.out.println(test.isBalanced(root));

	}
}
