//Question:876
//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.

package FastSlowPointer;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
}
