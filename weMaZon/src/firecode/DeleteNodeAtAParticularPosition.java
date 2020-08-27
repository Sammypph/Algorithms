package firecode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by oakinrele on Jul, 2020
 */
public class DeleteNodeAtAParticularPosition {

    public ListNode deleteAtMiddle(ListNode head, int position) {
        if (position == 1) {
            return head == null? head : head.next;
        }
        ListNode curr = head;
        ListNode prevNode = curr;
        int count = 0;
        while(curr != null) {
            count++; // 1  // 2 // 3 // prevNode = 2 // currentNode = 3 // currentNode = 4
            if(count == position) {
                //1 -> 2 -> 3 -> 4
                prevNode.next = curr.next;
                curr.next = null;
            }
            else {
                prevNode = curr; // 1 // 2
                curr = curr.next; // 2 // 3
            }
        }
        return head;
    }


    public ListNode deleteAtMiddleSolution2(ListNode head, int position) {

        Set<Integer> ts = new TreeSet<>();

        //String values = new String(ts.toArray().toString());


        if(head == null)
        {
            return head;
        }
        ListNode currentPosition = head;
        ListNode previousPosition = currentPosition;
        int counter = 1;
        boolean isTrue = true;

        while(isTrue)
        {
            if(currentPosition.next == null && counter < position)
            {
                isTrue = false;
            }


            if(position == 1 && currentPosition.next == null)
            {
                head = null;
                break;
            }

            if(position == 1)
            {
                currentPosition = currentPosition.next;
                previousPosition = null;
                head = currentPosition;
                break;
            }

            if(counter == position)
            {
                //1 -> 2 -> 3 -> 4
                currentPosition = null;
                previousPosition.next = previousPosition.next.next;
                break;
            }

            previousPosition = currentPosition;
            currentPosition = currentPosition.next;
            counter++;
        }

        return head;

        // 1 -> 2 -> 3 -> 4
        // 3

        //1->2->3->4
        //4
        // Right answer = 1->2->3
        // My answer = 1->2->3->4
        //1
        //2


        // My answer: 1->3->4
        // Actual answer: 2->3->4


    }








    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; next = null;}
    }
}
