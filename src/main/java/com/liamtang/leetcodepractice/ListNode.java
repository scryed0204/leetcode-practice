package com.liamtang.leetcodepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void printList() {
		ListNode head = this;
		List<Integer> list = new ArrayList();
		while (null != head) {
			list.add(head.val);
			// System.out.println(head.val + " ");
			head = head.next;
		}
		System.out.println(Arrays.toString(list.toArray()));
	}
}
