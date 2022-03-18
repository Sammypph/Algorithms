package firecode;

import java.util.Stack;

/**
 * Created by oakinrele on Jul, 2020
 */
public class FindNodeInABinaryTreeIteratively {
    public TreeNode findNode(TreeNode root, int val) {
        if(root == null)
        { return root;}
        if(root.data == val)
        { return root;}

        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode valNode = null;
        treeNodeStack.push(root);
        while(!treeNodeStack.isEmpty())
        {
            TreeNode tempNode = treeNodeStack.pop();
            if(tempNode.data == val)
            {
                valNode = tempNode;
                break;
            }

            if(tempNode.left != null)
            { treeNodeStack.push(tempNode.left); }

            if(tempNode.right != null)
            { treeNodeStack.push(tempNode.right); }

        }

        return valNode;
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
