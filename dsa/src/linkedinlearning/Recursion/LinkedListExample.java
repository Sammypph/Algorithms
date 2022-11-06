package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */
public class LinkedListExample {

    static Node head;

    public static void main(String [] args)
    {
      Node node1 = new Node(1,null);
      Node node2 = new Node(2,null);
      Node node3 = new Node(3,null);
      node1.next = node2;
      node2.next = node3;
      node3.next = null;


        printList(node1);
        System.out.println();
        printListInReverseOrder(node1);


    }




    public static void printList(Node root)
    {
        if(root !=null)
        {
            //Prints the Items inOrder
            System.out.println(root.toString());
            printList(root.next);
        }
    }



    public static  void printListInReverseOrder(Node root)
    {

        if(root != null)
        {
            //Prints in reverseOrder
            printListInReverseOrder(root.next);
            System.out.println(root.toString());
        }

    }
}

