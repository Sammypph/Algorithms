/**
 * Created by oakinrele on Jan, 2020
 */
public class LinkedList {
    static Node head; //Head of the LinkedList

    static class Node
    {
       int val;
       Node next;
       Node(int value)
       {
           val = value;
           next = null;
       }
    }


    public static void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

}