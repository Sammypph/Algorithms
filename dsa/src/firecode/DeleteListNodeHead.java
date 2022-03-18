package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DeleteListNodeHead {
    public DeleteAtTail.ListNode deleteAtHead(DeleteAtTail.ListNode head) {

        if(head == null || head.next == null)
        {
            return null;
        }
        DeleteAtTail.ListNode clone = head.next;
        head = null;
        head = clone;
        return head;
    }


    public DeleteAtTail.ListNode deleteAtHeadSolution(DeleteAtTail.ListNode head) {

        if(head == null || head.next == null)
        {
            return null;
        }
        DeleteAtTail.ListNode clone = head;

        while(head != null)
        {
          clone = head.next;
          head = null;
        }

        head = clone;

        return  head;
    }

}
