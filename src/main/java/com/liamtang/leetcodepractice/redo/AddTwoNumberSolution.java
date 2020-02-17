package com.liamtang.leetcodepractice.redo;

import com.liamtang.leetcodepractice.redo.ListNode;

public class AddTwoNumberSolution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode result = new ListNode(0);		
		ListNode tempHeader = result;
		ListNode current = null;
		
		int sum, p, q, carry = 0, curr = 0;
		
		while (null != l1 || null != l2) {
			p = (null != l1) ? l1.val : 0; // default value is 0 for class member
			q = (null != l2) ? l2.val : 0; // default value is 0 for class member
			sum = p + q + carry;
			
			carry = sum / 10;
			curr = sum % 10;		
			
			current = new ListNode(curr);
			tempHeader.next = current;
			
			l1 = (null != l1) ? l1.next : null;
			l2 = (null != l2) ? l2.next : null;
			tempHeader = current;
		}
		
		if (0 != carry) {
			tempHeader.next = new ListNode(carry);
		}
		
		return result.next;
	}

}
