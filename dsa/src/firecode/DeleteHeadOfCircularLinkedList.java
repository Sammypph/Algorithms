package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DeleteHeadOfCircularLinkedList {
    public DeleteAtTail.ListNode deleteAtHead(DeleteAtTail.ListNode head) {
        if(head == null)
        {
            return null;
        }
        DeleteAtTail.ListNode newHead = head.next;
        DeleteAtTail.ListNode curr = head;

        while(curr.next != null)
        {
            if(curr.next == head)
            {
                curr.next = head.next;
                head = null;
                break;
            }
        }

        return curr;
    }
}
