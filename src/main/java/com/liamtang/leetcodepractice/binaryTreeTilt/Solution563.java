package com.liamtang.leetcodepractice.binaryTreeTilt;

public class Solution563 {
	int result = 0;
	public int findTilt(TreeNode root) {		
		searchSum(root);		
		return result;
	}
	
	private int searchSum(TreeNode root) {
		
		if (null == root) {
			return 0;			
		}
		
		int right = (null != root.right)? searchSum(root.right) : 0;
		int left = (null != root.left)? searchSum(root.left) : 0;
		result += Math.abs(right - left);
		int sum = 0;
		sum = root.val;
		sum += right;			
		sum += left;			
		return sum;
	}
	
//	private void filtTiltUtil(TreeNode root) {
//		int right = (null != root.right)? searchSum(root.right) : 0;
//		int left = (null != root.left)? searchSum(root.left) : 0;
//		result += Math.abs(right - left);
//		
//		if (null != root.right) {
//			filtTiltUtil(root.right);
//		}
//
//		if (null != root.left) {
//			filtTiltUtil(root.left);
//		}
//		
//	}
	
	public static void main(String args[]) {
		
	}
}
