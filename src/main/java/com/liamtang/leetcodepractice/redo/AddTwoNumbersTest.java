package com.liamtang.leetcodepractice.redo;

import com.liamtang.leetcodepractice.redo.ListNode;
import com.liamtang.leetcodepractice.redo.AddTwoNumberSolution;

public class AddTwoNumbersTest {
	public static void main(String args[]) {
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
		
		head1 = new ListNode(0);
		head1.next = new ListNode(1);
		head1.printList();

		head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		head2.next.next.next = new ListNode(3);
		head2.printList();

		result = new AddTwoNumberSolution().addTwoNumbers(head1, head2);
		result.printList();
	}

}
