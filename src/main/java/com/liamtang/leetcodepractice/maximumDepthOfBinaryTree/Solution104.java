package com.liamtang.leetcodepractice.maximumDepthOfBinaryTree;


public class Solution104 {
	
    public int maxDepth(TreeNode root) {
    	
    	if (null == root) {
    		return 0;
    	}
    	
    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));            
    }
    
    public static void main (String args[]) {
    	// [1,null,3,2]
       	TreeNode root = new TreeNode(1);
    	TreeNode n2_1 = null;
    	TreeNode n2_2 = new TreeNode(3);
    	TreeNode n3_1 = new TreeNode(2);
    	TreeNode n4_1 = new TreeNode(4);
    	
    	root.left = n2_1;
    	root.right = n2_2;
    	root.right.left = n3_1;
    	root.right.left.right = n4_1;
    	
    	Solution104 test = new Solution104();
    	System.out.println(test.maxDepth(root));
    }
}
