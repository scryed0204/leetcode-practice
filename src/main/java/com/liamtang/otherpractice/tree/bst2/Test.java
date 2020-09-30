package com.liamtang.otherpractice.tree.bst2;

public class Test {	
	
	public static void main(String args[]) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(8, "Turtle");
		tree.add(2, "Creme");
		tree.add(1000, "Goku");
		tree.add(513, "Pikolo");
		tree.add(69, "Kinu");
		tree.add(700, "Freeza");
		
		info(tree);
//		
//		
//		info(tree);
//		
//		
//		info(tree);
		
		tree.DeleteBST(8);
		
		info(tree);

	}
	
	public static void info(BinarySearchTree tree) {
		System.out.println("-------------------------------");
		System.out.println("Inorder Traversal:");
		tree.Inorder();
		System.out.println();
		tree.Inorder_by_parent();
		System.out.println();
		System.out.println("Level-order Traversal:");
		tree.Levelorder();
		System.out.println();
		System.out.println(tree.Search(1000).getData());
	}

}
