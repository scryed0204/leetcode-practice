package com.liamtang.leetcodepractice.linkedListCycle2;

public class Solution142 {

	public ListNode detectCycle(ListNode head) {



        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;



	}

	public static void main(String args[]) {
		
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
		n5.next = n6;
		
		
//		ListNode n0 = new ListNode(3);
//		ListNode n1 = new ListNode(2);
//		ListNode n2 = new ListNode(0);
//		ListNode n3 = new ListNode(-4);
//
//		n0.next = n1;
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n1;

		Solution142 s = new Solution142();
		ListNode result = s.detectCycle(n0);
		System.out.println(result);

	}

}
