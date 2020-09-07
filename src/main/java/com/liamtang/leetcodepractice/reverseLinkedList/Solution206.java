package com.liamtang.leetcodepractice.reverseLinkedList;

public class Solution206 {
	
	public ListNode reverseList(ListNode head) {
		ListNode result = null;
		ListNode tempNext;
		
		while (head != null) {
			tempNext = result;
			result = head;
			head = head.next;
			result.next = tempNext;			
		}
		
		return result;		
	}
}
