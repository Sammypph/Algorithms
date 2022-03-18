package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */
public class Node {

    int value;
    Node next;

    public Node()
    {
        value = 0;
        next = null;
    }


    public Node(int value , Node next)
    {
      this.value = value;
      this.next = next;
    }


    public String toString()
    {
        return value + "";
    }
}
