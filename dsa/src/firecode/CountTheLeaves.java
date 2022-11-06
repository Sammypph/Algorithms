package firecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by oakinrele on Jul, 2020
 */


public class CountTheLeaves {
    int leaves = 0;
    public int numberOfLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }

        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode valNode = null;
        treeNodeStack.push(root);

        while(!treeNodeStack.isEmpty())
        {
            TreeNode tempNode = treeNodeStack.pop();
            if(tempNode.left == null && tempNode.right == null)
            {
                leaves++;
            }

            if(tempNode.right != null)
            {
                treeNodeStack.push(tempNode.right);
            }

            if(tempNode.left != null)
            {
                treeNodeStack.push(tempNode.left);
            }
        }
        return leaves;

    }

    public int numberOfLeavesBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int leafCount = 0;
        while(!queue.isEmpty()) {
            boolean noLeft = true;
            boolean noRight = true;

            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                noLeft = false;
            }

            if (node.right != null) {
                queue.add(node.right);
                noRight = false;
            }

            if (noLeft && noRight) {
                leafCount++;
            }
        }

        return leafCount;
    }



    public int numberOfLeavesRecursively(TreeNode root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else
            return numberOfLeaves(root.left) + numberOfLeaves(root.right);
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
