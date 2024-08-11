//Question:143
//You are given the head of a singly linked-list. The list can be represented as:
//
//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.

package FastSlowPointer;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        
        while (fast != null && fast.next != null) {
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode p1 = head;
        ListNode p2 = reverseList(slow);
        
        while (p1 != null && p2 != null) {
        	ListNode next1 = p1.next;
        	ListNode next2 = p2.next;
        	
        	p1.next = p2;
        	p2.next = next1 == null ? next2 : next1;
        	
        	p1 = next1;
        	p2 = next2;
        }
    }
    
    private ListNode reverseList(ListNode node) {
    	ListNode prev = null;
    	
    	while (node != null) {
    		ListNode temp = node.next;
    		node.next = prev;
    		prev = node;
    		node = temp;
    	}
    	return prev;
    }
}
