package com.liamtang.leetcodepractice.sameTree;

public class Solution100 {
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	
    	if (null == p && null == q) {
    		return true;
    	}
    	
    	if (null == p || null == q) {
    		return false;
    	}
    	
    	return (p.val == q.val) && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);        
    }

}
