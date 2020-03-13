package FireCode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class insertAtTail {

    public ListNode insertAtTail(ListNode head, int data)
    {
        ListNode tail = new ListNode(data);
        ListNode curr = head;

        if(head == null)
        {
            head = tail;
            return head;
        }


        while(curr.next != null)
        {
            curr = curr.next;
        }

        curr.next = tail;

        return head;
    }



    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}
