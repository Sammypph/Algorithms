package firecode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class findMiddleNode
{

    public static ListNode findMiddle(ListNode head)
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


    public ListNode middleNode(ListNode head) {
        //Get count of items in the LinkedList
        int totalElements = 1;
        ListNode snail = head;
        ListNode heir = head;
        while(heir != null && heir.next != null && heir.next.next != null)
        {
            snail = snail.next;
            heir = heir.next.next;
            totalElements += 2;
        }
        //Get total number of elements in the linkedList
        if(heir.next != null){totalElements +=1;}
        if(totalElements % 2 == 0)
        {
            snail = snail.next;
        }
        return snail;
    }

    static class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }

    public static void main(String [] args)
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        System.out.println(findMiddle(node));
    }
}
