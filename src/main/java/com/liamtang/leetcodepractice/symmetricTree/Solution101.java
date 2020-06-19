package com.liamtang.leetcodepractice.symmetricTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	queue.add(root);
    	int currentLevelIdx = 0;
    	int currentLevelNodeCnt = 1;
    	int currentNodeCnt = 0;
    	TreeNode node;
//    	List<Integer> tempList = new ArrayList<Integer>(); 
    	List<Integer> tempListForCompare = new ArrayList<Integer>(); 
    	List<Integer> tempListForCompare2 = new ArrayList<Integer>(); 
    	while (!queue.isEmpty()) {    		
    		node = queue.remove();	
    		
    		if (node != null && node.left != null) {
    			queue.add(node.left);
    		} else {
    			queue.add(null);
    		}	
    		
    		if (node != null && node.right != null) {
    			queue.add(node.right);
    		} else {
    			queue.add(null);
    		}   
    		
    		if (currentLevelIdx == 0) {
    			currentLevelIdx ++;
    			currentLevelNodeCnt = (int)Math.pow(2, currentLevelIdx);
    			continue;
    		}
    		currentNodeCnt ++;
    		if (currentNodeCnt <= currentLevelNodeCnt/2) {
    			tempListForCompare.add(null != node ? node.val : null);
    		} else {
    			tempListForCompare2.add(null != node ? node.val : null);
    		}
    		if (currentNodeCnt == currentLevelNodeCnt) {
    			
    			Collections.reverse(tempListForCompare2);
    			int nullCnt = 0;
    			Integer nodeVal1;
    			Integer nodeVal2;    			
    			if (tempListForCompare.size() > 0) {
    				for (int i = 0; i< tempListForCompare.size(); i++) {
    					nodeVal1 = tempListForCompare.get(i);
    					nodeVal2 = tempListForCompare2.get(i);
    					if (null == nodeVal1) nullCnt++;
    					if (null == nodeVal2) nullCnt++;
    					
    					if (nodeVal1 != nodeVal2) {
    						return false;
    					}
    				} 
    			}
    			if (nullCnt == currentLevelNodeCnt) {
    				break;
    			}
    			
    			currentNodeCnt = 0;
    			currentLevelIdx ++;
    			currentLevelNodeCnt = (int)Math.pow(2, currentLevelIdx);
    			tempListForCompare = new ArrayList<Integer>(); 
    			tempListForCompare2 = new ArrayList<Integer>(); 
    		}
    	}
    	
    	return true;
    }
	
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
    	
    	TreeNode root = new TreeNode(1);
    	TreeNode n2_1 = new TreeNode(2);
    	TreeNode n2_2 = new TreeNode(2);
    	
    	root.right = n2_1;
    	root.left = n2_2;
    	
    	Solution101 test = new Solution101();
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
    	
//    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
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
