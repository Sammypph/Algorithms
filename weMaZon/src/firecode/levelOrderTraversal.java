package firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Feb, 2020
 */


//Level Order Traversal is also known as Breadth First Search
public class levelOrderTraversal {

    //1) Create an empty queue q
    //2) temp_node = root /*start from root*/
    //3) Loop while temp_node is not NULL
            //a) print temp_node->data.
            //b) Enqueue temp_node’s children (first left then right children) to q
            //c) Dequeue a node from q and assign it’s value to temp_node


    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}


class Node
{
    int data;
    Node right, left;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}


class BinaryTree
{
    Node root;

    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            // poll() removes the present head.
            Node tempNode = queue.poll();
            System.out.println(tempNode.data + " ");

            //Enqueue left child
            if(tempNode.left != null)
            {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if(tempNode.right != null)
            {
                queue.add(tempNode.right);
            }

        }
    }
}
