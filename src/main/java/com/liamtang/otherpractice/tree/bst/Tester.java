package com.liamtang.otherpractice.tree.bst;

public class Tester {
	
	public static void main(String args[]) {
		try {
//			BinarySearchTree bt = BinarySearchTree.createTestTree();
			BinarySearchTree bt = BinarySearchTree.createRandomTree(10, 100);
			
			System.out.println(bt.containsNode(1));
			System.out.println(bt.containsNode(6));
			
			System.out.println(bt.treverseLevelOrder());
			System.out.println(bt.traverseInOrder());
			System.out.println(bt.traversePreOrder());
			
//			bt.delete(1);
//			bt.delete(6);
//			
//			System.out.println(bt.containsNode(1));
//			System.out.println(bt.containsNode(6));
//			
//			System.out.println(bt.treverseLevelOrder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
