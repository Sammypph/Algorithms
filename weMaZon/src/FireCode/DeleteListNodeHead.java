package FireCode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DeleteListNodeHead {
    public deleteAtTail.ListNode deleteAtHead(deleteAtTail.ListNode head) {

        if(head == null || head.next == null)
        {
            return null;
        }
        deleteAtTail.ListNode clone = head.next;
        head = null;
        head = clone;
        return head;
    }


    public deleteAtTail.ListNode deleteAtHeadSolution(deleteAtTail.ListNode head) {

        if(head == null || head.next == null)
        {
            return null;
        }
        deleteAtTail.ListNode clone = head;

        while(head != null)
        {
          clone = head.next;
          head = null;
        }

        head = clone;

        return  head;
    }

}
