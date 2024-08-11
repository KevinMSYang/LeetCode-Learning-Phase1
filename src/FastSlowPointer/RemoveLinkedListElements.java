//Question:203
//Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

package FastSlowPointer;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
		
		ListNode dummy = new ListNode(0, head);
		ListNode pre = dummy;
		ListNode cur = head;
		
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
				cur = pre.next;
			}
			else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
