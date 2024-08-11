//Question:19
//Given the head of a linked list, remove the nth node from the end of the list and return its head.

package FastSlowPointer;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		
		ListNode dummy = new ListNode(0, head);
		ListNode pre = null;
		ListNode slow = dummy;
		ListNode fast = dummy;
		
		while (fast != null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		pre.next = slow.next;
		
		return dummy.next;
	}
}
