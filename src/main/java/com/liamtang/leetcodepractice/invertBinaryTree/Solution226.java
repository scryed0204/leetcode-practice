package com.liamtang.leetcodepractice.invertBinaryTree;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newNode = new TreeNode(root.val);
		
		newNode.left = invertTree(root.right);
		newNode.right = invertTree(root.left);

		return newNode;    
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
    	System.out.println(tree.traverseInOrder());
    	System.out.println(tree.traverseReverseInOrder());
    	Solution226 test = new Solution226();
    	TreeNode result = test.invertTree(tree);
    	System.out.println(result.traverseInOrder());
    	System.out.println(result.traverseReverseInOrder());
    	
    }
}
