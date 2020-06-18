package com.liamtang.leetcodepractice.convertBstToGreaterTree;

public class Solution538_1 {
	int sum = 0;    		
    public TreeNode convertBST(TreeNode root) {
    	if (root != null) {
    		convertBST(root.right);
    		sum += root.val;
    		root.val = sum;
    		convertBST(root.left);
    	}
    	
        return root;
    }
    
    public static void main(String args[]) {
//    	TreeNode tree = new TreeNode(2);
//    	tree.add(0);
//    	tree.add(3);
//    	tree.add(-4);
//    	tree.add(1);
    	TreeNode tree = new TreeNode(1);
    	tree.add(0);
    	tree.add(4);
    	tree.add(-2);
//    	tree.add(null);
    	tree.add(3);
    	System.out.println(tree.treverseLevelOrder());
//    	System.out.println(tree.traverseReverseInOrder());
    	Solution538_1 test = new Solution538_1();
    	TreeNode result = test.convertBST(tree);
    	System.out.println(result.treverseLevelOrder());
//    	System.out.println(result.traverseReverseInOrder());
    	
    }
}
