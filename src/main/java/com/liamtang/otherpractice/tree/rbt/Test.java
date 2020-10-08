package com.liamtang.otherpractice.tree.rbt;

import java.security.SecureRandom;

public class Test {
	
	public static void main(String args[]) {
		RedBlackTree rbt = new RedBlackTree();
		
		rbt.add(10, "10");
		rbt.add(20, "20");
		rbt.add(30, "30");
		rbt.add(40, "40");
		rbt.add(50, "50");
		rbt.add(60, "60");
		rbt.add(70, "70");
		rbt.add(80, "80");
		
//		while (rbt.getSize() < 20) {
//			int x = generateRandomNumber();
//			rbt.add(x, x + "");
//		}
//		
		rbt.inorder();
		System.out.println();
//		rbt.levelorder();
		
		rbt.deleteByKey(50);
		rbt.inorder();
	}
	
	public static int generateRandomNumber() {
		SecureRandom rand = new SecureRandom();
		return rand.nextInt(200);		
	}
	

}
