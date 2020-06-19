package com.liamtang.leetcodepractice.symmetricTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {
    	if (null != root) {
    		return isSymmetricUtil(root.right, root.left);
    	}
    	
    	return true;
    }
    
    private boolean isSymmetricUtil(TreeNode right, TreeNode left) {
    	if (null == right && null == left) {
    		return true;
    	}    	
    	
    	if (null == right || null == left) {
    		return false;
    	}    	
    	
    	if (right.val != left.val) {
    		return false;
    	}
    	
    	if (!isSymmetricUtil(right.right, left.left)) {
    		return false; 
    	}
    	
    	if (!isSymmetricUtil(right.left, left.right)) {
    		return false; 
    	}
    	
    	return true;
    }
    
    public static void main(String args[]) {
    	
    	TreeNode root = new TreeNode(1);
    	TreeNode n2_1 = new TreeNode(2);
    	TreeNode n2_2 = new TreeNode(2);
    	
    	root.right = n2_1;
    	root.left = n2_2;
    	
    	Solution101_2 test = new Solution101_2();
    	System.out.println(test.isSymmetric(root));
//    	Integer i1 = 1;
//    	Integer i2 = 1;
//    	Integer i3 = null;
//    	Integer i4 = null;
//    	
//    	System.out.println(i1==i2);
//    	System.out.println(i1==i3);
//    	System.out.println(i3==i4);
//    	System.out.println(1/2);
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.poll();
//    	queue.add(null);
//    	
//    	System.out.println(queue.isEmpty());
    	
//    	System.out.println((int)Math.pow(2, 0));
//    	System.out.println((int)Math.pow(2, 1));
//    	System.out.println((int)Math.pow(2, 2));
//    	System.out.println((int)Math.pow(2, 3));
////    	TreeNode tree = new TreeNode(2);
////    	tree.add(0);
////    	tree.add(3);
////    	tree.add(-4);
////    	tree.add(1);
//    	TreeNode tree = new TreeNode(1);
//    	tree.add(0);
//    	tree.add(4);
//    	tree.add(-2);
////    	tree.add(null);
//    	tree.add(3);
//    	System.out.println(tree.traverseInOrder());
//    	System.out.println(tree.traverseReverseInOrder());
//    	Solution101 test = new Solution101();
//    	TreeNode result = test.invertTree(tree);
//    	System.out.println(result.traverseInOrder());
//    	System.out.println(result.traverseReverseInOrder());
    	
    }
}
