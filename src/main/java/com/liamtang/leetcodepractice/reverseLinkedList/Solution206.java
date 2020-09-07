package com.liamtang.leetcodepractice.reverseLinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author kouic
 *
 */
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
