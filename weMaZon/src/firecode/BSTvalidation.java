package firecode;

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



    public static boolean validateBSTSolution(TreeNode root) {
        return validateBSTSolution(root, null, null);
    }

    private static boolean validateBSTSolution(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val < min || max != null && root.val > max) return false;
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }



    static public TreeNode prev;

    public static boolean validateBST2(TreeNode root)
    {
        prev = null;
        return isBST(root);

    }

    public static boolean isBST(TreeNode node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
            {
                return false;
            }

            // allows only distinct values node
            if (prev != null && node.val <= prev.val )
            {
                return false;
            }
            prev = node;
            return isBST(node.right);
        }
        return true;
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
