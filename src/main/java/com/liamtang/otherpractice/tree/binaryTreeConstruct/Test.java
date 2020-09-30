package com.liamtang.otherpractice.tree.binaryTreeConstruct;

public class Test {
	
	public static void main(String args[]) {
//	    // TreeNode instantiation
//	    TreeNode nodeA = new TreeNode("A"); TreeNode nodeB = new TreeNode("B"); 
//	    TreeNode nodeC = new TreeNode("C"); TreeNode nodeD = new TreeNode("D"); 
//	    TreeNode nodeE = new TreeNode("E"); TreeNode nodeF = new TreeNode("F"); 
//	    TreeNode nodeG = new TreeNode("G"); TreeNode nodeH = new TreeNode("H"); 
//	    TreeNode nodeI = new TreeNode("I");
//
//	    // construct the Binary Tree
//	    nodeA.setLeftChild(nodeB); nodeA.setRightChild(nodeC);
//	    nodeB.setLeftChild(nodeD); nodeB.setRightChild(nodeE);
//	    nodeE.setLeftChild(nodeG); nodeE.setRightChild(nodeH);
//	    nodeC.setLeftChild(nodeF); nodeF.setRightChild(nodeI);
		
	    
	    BinaryTree tree = new BinaryTree("ABCDEFxxxGHxI");
	    tree.Levelorder();
	    System.out.println();
	    tree.Inorder_by_parent();
	    
	    tree.InsertLevelorder('K');
	    System.out.println();
	    tree.Levelorder();
	    System.out.println();
	    tree.Inorder_by_parent();
//	    System.out.println();
//	    tree.Inorder();
//	    System.out.println();
//	    tree.Inorder_Reverse();
//	    System.out.println();
//	    System.out.println();
//	    tree.Postorder(tree.getRoot());
//	    System.out.println();
//	    tree.Preorder(tree.getRoot());
	}

}
