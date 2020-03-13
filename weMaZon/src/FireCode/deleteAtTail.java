package FireCode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class deleteAtTail
{
    public ListNode deleteAtTail(ListNode head)
    {
        if(head == null)
        {
            return head;
        }

        if(head.next == null)
        {
            return null;
        }

        ListNode curr = head;
        while(curr != null && curr.next.next != null)
        {
            curr = curr.next;
        }

        curr.next = null;


        return head;


    }


    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; next = null;}
    }
}
