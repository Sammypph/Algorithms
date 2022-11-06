package leetcode;

/**
 * Created by oakinrele on Jun, 2020
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode invertTree = root;
        invert(invertTree);
        return invertTree;

    }

    private void invert(TreeNode treeNode)
    {
        if(treeNode == null)
        {
            return;
        }

        else
        {
            TreeNode temp;
            /* recursive calls */
            invert(treeNode.left);
            invert(treeNode.right);

            /* swap the pointers in this node */
            temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
        }

    }
}
