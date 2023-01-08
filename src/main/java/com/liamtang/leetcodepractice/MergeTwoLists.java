package com.liamtang.leetcodepractice;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
        {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode primaryNode;
        ListNode adder;
        if (list1.val < list2.val) {
            primaryNode = list1;
            adder = list2;
        } else {
            primaryNode = list2;
            adder = list1;
        }
        ListNode topNode = primaryNode;
        while (adder != null) {
            ListNode tempParent = null;
            while(primaryNode != null && adder.val > primaryNode.val) {
                tempParent = primaryNode;
                primaryNode = primaryNode.next;
            }
            ListNode tempNext2 = adder.next;
            if (null != tempParent) {
                tempParent.next = adder;
                adder.next = primaryNode;
            } else {
                ListNode tempNext = primaryNode.next;
                primaryNode.next = adder;
                adder.next = tempNext;
            }
            adder = tempNext2;
            primaryNode = topNode;
        }

        return topNode;
    }

    public static void main(String args[]) {
//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);
//        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);


        MergeTwoLists test = new MergeTwoLists();
        ListNode result = test.mergeTwoLists(list1, list2);
        result.printList();
    }
}
