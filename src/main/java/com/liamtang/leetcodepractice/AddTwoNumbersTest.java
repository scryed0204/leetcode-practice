package com.liamtang.leetcodepractice;

import com.liamtang.leetcodepractice.AddTwoNumberSolution;

public class AddTwoNumbersTest {
	
	private static void test1() {
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(7);
		head1.printList();

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		head2.next.next.next = new ListNode(3);
		head2.printList();

		ListNode result = new AddTwoNumberSolution().addTwoNumbers(head1, head2);
		result.printList();
	}
	
	private static void text2() {
		ListNode head1 = new ListNode(0);
		head1.next = new ListNode(1);
		head1.printList();

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		head2.next.next.next = new ListNode(3);
		head2.printList();

		ListNode result = new AddTwoNumberSolution().addTwoNumbers(head1, head2);
		result.printList();
	}
	
	public static void main(String args[]) {
		test1();
		text2();
	}

}
