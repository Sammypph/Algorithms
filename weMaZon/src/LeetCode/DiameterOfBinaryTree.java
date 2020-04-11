package LeetCode;

/**
 * Created by oakinrele on Apr, 2020
 */
public class DiameterOfBinaryTree {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        int height = findHeight(root);
        return diameter;

    }

    public int findHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight , rightHeight);
    }
}


class TreeNode
{ int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
