package com.liamtang.leetcodepractice.redo;

public class AddTwoNumber_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode tempNode = result;
		
		int sum = 0;
		int val1 = 0;
		int val2 = 0;
		boolean adv = false;
		while (null != l1 || null != l2) {
			ListNode newNode = new ListNode(0);
			tempNode.next = newNode;
			tempNode = tempNode.next;
			val1 = (null != l1) ? l1.val : 0;
			val2 = (null != l2) ? l2.val : 0;
			sum = val1 + val2;
			if (adv) sum ++;
			if (sum >= 10) {
				sum %= 10;
				adv = true;
			} else {
				adv = false;
			}
			tempNode.val = sum;
			
			l1 = (null != l1) ? l1.next : null;
			l2 = (null != l2) ? l2.next : null;		
		}
		
		if (adv) {
			ListNode newNode = new ListNode(1);
			tempNode.next = newNode;
		}
		
		return result.next;		
	}

}
