package FireCode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class BSTvalidation {
    public static boolean validateBST(TreeNode root) {
        return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // left subtree must be < root.val && right subtree must be > root.val
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }

}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.right = right;
        this.left = left;
        this.val = val;
    }
}
