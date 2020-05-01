package FireCode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DeleteCircularLinkedListTailNode {
    public deleteAtTail.ListNode deleteAtTail(deleteAtTail.ListNode head) {
        if(head == null)
        {
            return null;
        }

        deleteAtTail.ListNode presentNode = head;
        while(presentNode.next.next != head)
        {
            presentNode = presentNode.next;
        }
        presentNode.next = null;
        presentNode.next = head;

        return head;
    }


    public deleteAtTail.ListNode deleteAtTailSecondSolution(deleteAtTail.ListNode head) {
        deleteAtTail.ListNode currentNode = head;
        deleteAtTail.ListNode prevNode = head;
        while(currentNode.next != head) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        prevNode.next = head;
        currentNode.next = null;
        return head;
    }
}
