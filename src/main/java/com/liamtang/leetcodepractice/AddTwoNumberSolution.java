package com.liamtang.leetcodepractice;

import com.liamtang.leetcodepractice.ListNode;

public class AddTwoNumberSolution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null;

		// Crappy Solution Start

		// int sum = l1.val + l2.val;
		// int frstVal = sum % 10;
		// int passVal = sum / 10;
		// result = new ListNode(frstVal);
		// int secondVal = 0;
		// int secondPassVal = 0;
		// if (l1.next != null && l2.next != null) {
		// int secondSum = l1.next.val + l2.next.val;
		// secondVal = (secondSum % 10) + passVal;
		// secondPassVal = secondSum / 10;
		//
		// if (10 <= secondVal) {
		// secondVal = secondVal % 10;
		// secondPassVal++;
		// }
		// }
		// result.next = new ListNode(secondVal);
		//
		// int thirdVal = 0;
		// int thirdPassVal = 0;
		// if (l1.next.next != null && l2.next.next != null) {
		// int thirdSum = l1.next.next.val + l2.next.next.val;
		// thirdVal = (thirdSum % 10) + secondPassVal;
		// thirdPassVal = thirdSum / 10;
		//
		// if (10 <= thirdVal) {
		// thirdVal = thirdVal % 10;
		// thirdPassVal++;
		// }
		// }
		// result.next.next = new ListNode(thirdVal);
		//
		// if (thirdPassVal != 0) {
		// result.next.next.next = new ListNode(thirdPassVal);
		// }

		// Crappy Solution End

		// Better Solution Start
		ListNode dummyHeader = new ListNode(0);

		ListNode n1, n2, curr;
		n1 = l1;
		n2 = l2;
		curr = dummyHeader;

		int passVal = 0;
		while (null != n1 || null != n2) {
			int n1Val = (null == n1) ? 0 : n1.val;
			int n2Val = (null == n2) ? 0 : n2.val;
			int sum = n1Val + n2Val + passVal;
			int val = sum % 10;
			passVal = sum / 10;
			curr.next = new ListNode(val);

			curr = curr.next;
			if (null != n1)
				n1 = n1.next;
			if (null != n2)
				n2 = n2.next;
		}

		if (passVal != 0) {
			curr.next = new ListNode(passVal);
		}

		result = dummyHeader.next;
		// Better Solution End

		return result;
	}

}
