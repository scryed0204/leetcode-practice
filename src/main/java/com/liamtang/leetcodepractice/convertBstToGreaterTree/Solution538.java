package com.liamtang.leetcodepractice.convertBstToGreaterTree;

public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
    	if (root != null) {
    		
    		TreeNode tempNode = copy(root);    		
    		root = calculateUtil(root, tempNode);
    	}    	
    	
    	return root;        
    }
    
    // root = root + right
    // left = left + (root + right)
    private TreeNode calculateUtil(TreeNode root, TreeNode originTree) {
    	int oriVal = root.val;
    	traversetCalculate(oriVal, originTree, root);
    	if (null != root.right) {
    		calculateUtil(root.right, originTree);    		
    	}
    	if (null != root.left) {
    		calculateUtil(root.left, originTree);    		
    	}
    	
    	return root;
    }
    
    private void traversetCalculate(int val, TreeNode originTree, TreeNode currentNode) {
    	if (originTree.val > val) {
    		currentNode.val += originTree.val;
    	}
    	if (null != originTree.right) {
    		traversetCalculate(val, originTree.right, currentNode);
    	}
    	if (null != originTree.left) {
    		traversetCalculate(val, originTree.left, currentNode);
    	}    	
    }
    
    private TreeNode copy(TreeNode root) {
        if (root == null)
        {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.left= copy(root.left);
        newNode.right= copy(root.right);
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
    	Solution538 test = new Solution538();
    	TreeNode result = test.convertBST(tree);
    	System.out.println(result.traverseInOrder());
    	System.out.println(result.traverseReverseInOrder());
    	
    }
}
