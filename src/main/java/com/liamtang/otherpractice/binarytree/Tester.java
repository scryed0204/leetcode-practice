package com.liamtang.otherpractice.binarytree;

public class Tester {
	
	public static void main(String args[]) {
		try {
			BinarySearchTree bt = BinarySearchTree.createTestTree();
			
			System.out.println(bt.containsNode(1));
			System.out.println(bt.containsNode(6));
			
			System.out.println(bt.treverseLevelOrder());
			
			bt.delete(1);
			bt.delete(6);
			
			System.out.println(bt.containsNode(1));
			System.out.println(bt.containsNode(6));
			
			System.out.println(bt.treverseLevelOrder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
