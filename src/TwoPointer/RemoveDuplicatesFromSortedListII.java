//Question: 82
//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

package TwoPointer;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode pre = dummy;
		
		while (head != null) {
			while (head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			if (pre.next == head) {
				pre = pre.next;
			}
			else {
				pre.next = head.next;
			}
			head = head.next;
		}
		return dummy.next;
	}
	
	
//    public ListNode deleteDuplicates(ListNode head) {
//    	ListNode dummy = new ListNode(0, head);
//ListNode pre = dummy;
//
//while (head != null) {
//	while (head.next != null && head.val == head.next.val) {
//		head = head.next;
//	}
//	if (pre.next == head) {
//		pre = pre.next;
//	}
//	else {
//		pre.next = head.next;
//	}
//	head = head.next;
//}
//return dummy.next;
//}
}
