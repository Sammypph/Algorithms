package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DeleteCircularLinkedListTailNode {
    public DeleteAtTail.ListNode deleteAtTail(DeleteAtTail.ListNode head) {
        if(head == null)
        {
            return null;
        }

        DeleteAtTail.ListNode presentNode = head;
        while(presentNode.next.next != head)
        {
            presentNode = presentNode.next;
        }
        presentNode.next = null;
        presentNode.next = head;

        return head;
    }


    public DeleteAtTail.ListNode deleteAtTailSecondSolution(DeleteAtTail.ListNode head) {
        DeleteAtTail.ListNode currentNode = head;
        DeleteAtTail.ListNode prevNode = head;
        while(currentNode.next != head) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        prevNode.next = head;
        currentNode.next = null;
        return head;
    }
}
