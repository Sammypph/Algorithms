package HackerRank;

import java.util.List;

/**
 * Created by oakinrele on Jan, 2020
 */
public class reverseAListNode {

    public static ListNode reverseWord(ListNode root){
        if(root==null||root.next==null) return root;
        ListNode reverseHead = new ListNode(root.data);
        ListNode node = root;
        ListNode currRev;
        while (node.next != null){
            node = node.next;
            currRev = new ListNode(node.data);
            currRev.next = reverseHead;
            reverseHead = currRev;
        }
        return  reverseHead;
    }


    static class ListNode
    {
        int data;
        ListNode next;

        ListNode(int data)
        {
            this.data = data;
        }
    }



    public static void main(String [] args)
    {
       ListNode root = new ListNode(1);
       root.next = new ListNode(2);
       root.next.next = new ListNode(3);
       root.next.next.next = new ListNode(4);

       reverseWord(root);

    }
}
