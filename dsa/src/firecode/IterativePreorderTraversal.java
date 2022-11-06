package firecode;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class IterativePreorderTraversal {


//PLR
public ArrayList<Integer> preorderItr(TreeNode root) {

    //Algorithm Preorder(tree)
    //1. Visit the root.
    //2. Traverse the left subtree, i.e., call Preorder(left-subtree)
    //3. Traverse the right subtree, i.e., call Preorder(right-subtree)
    // {This is for recursion}

    if(root == null)
    {
        return new ArrayList<>();
    }

    ArrayList<Integer> preOrderTraversal = new ArrayList<>();
    Stack<TreeNode> treeNodeStack = new Stack<>();
    treeNodeStack.push(root);



    while(!treeNodeStack.isEmpty())
    {
        TreeNode tempNode = treeNodeStack.pop(); //1
        preOrderTraversal.add(tempNode.data);

        if(tempNode.right != null)
        {
            treeNodeStack.push(tempNode.right);
        }

        if(tempNode.left != null)
        {
            treeNodeStack.push(tempNode.left);
        }

    }

    return preOrderTraversal;

}

    //LRP
    public ArrayList<Integer> postorderItr(TreeNode root) {
        if(root == null)
        { return new ArrayList<>();}

        ArrayList<Integer> postOrderTraversal = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        while(!treeNodeStack.isEmpty())
        {
            TreeNode tempNode = treeNodeStack.pop(); //1
            postOrderTraversal.add(tempNode.data);

            if(tempNode.left != null)
            {
                treeNodeStack.push(tempNode.left);
            }

            if(tempNode.right != null)
            {
                treeNodeStack.push(tempNode.right);
            }

        }
        Collections.reverse(postOrderTraversal);
        return postOrderTraversal;
    }


    //PLR
    private void preOrderRecursively(TreeNode node)
    { if (node == null)
    { return; }
        System.out.printf("%s ", node.data);
        preOrderRecursively(node.left);
        preOrderRecursively(node.right);
    }

    //LRP
    private void postOrderRecursively(TreeNode node)
    { if (node == null)
    { return; }
        postOrderRecursively(node.left);
        postOrderRecursively(node.right);
        System.out.printf("%s ", node.data);
    }



public class TreeNode
{
    int data;
    TreeNode right;
    TreeNode left;

    TreeNode(int data, TreeNode left , TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

}
