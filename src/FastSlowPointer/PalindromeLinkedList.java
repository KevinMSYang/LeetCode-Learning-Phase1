//Question:234
//Given the head of a singly linked list, return true if it is a 
//palindrome
// or false otherwise.

package FastSlowPointer;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) return true;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	if (fast != null) slow = slow.next;
    	slow = reverseList(slow);
    	
    	while (slow != null) {
    		if (slow.val != head.val) return false;
    		slow = slow.next;
    		head = head.next;
    	}
    	return true;
    }
    
    private ListNode reverseList(ListNode node) {
    	ListNode pre = null;
    	
    	while (node != null) {
    		ListNode temp = node.next;
    		node.next = pre;
    		pre = node;
    		node = temp;
    	}
    	return pre;
    }
}
