package FireCode;

import java.util.List;

/**
 * Created by oakinrele on Jan, 2020
 */
public class findMiddleNode
{

    public ListNode findMiddle(ListNode head)
    {
      if(head == null)
      {
          return head;
      }

        ListNode snail = head;
        ListNode heir = head;

      while(heir != null && heir.next != null && heir.next.next != null)
      {
          snail = snail.next;
          heir = heir.next.next;
      }

      return snail;
    }


    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }
}
