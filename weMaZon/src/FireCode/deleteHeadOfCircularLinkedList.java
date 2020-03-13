package FireCode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class deleteHeadOfCircularLinkedList {
    public deleteAtTail.ListNode deleteAtHead(deleteAtTail.ListNode head) {
        if(head == null)
        {
            return null;
        }
        deleteAtTail.ListNode newHead = head.next;
        deleteAtTail.ListNode curr = head;

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
