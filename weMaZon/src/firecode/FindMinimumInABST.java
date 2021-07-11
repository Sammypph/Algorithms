package firecode;

/**
 * Created by oakinrele on Mar, 2021
 */
public class FindMinimumInABST {
    public TreeNode findMin(TreeNode root) {
        //Since bst always has the smallest value on the left and biggest on the right
        //Keep going to the left side till the left node is null then return the node before that

        if(root == null){
            return null;
        }

        if(root.left == null){
            return root;
        }

        TreeNode min = null;

        while(root.left != null){
            root = root.left;
            min = root;
        }
        return min;
    }

    private TreeNode findMinRecursively(TreeNode root) {
        //Since bst always has the smallest value on the left and biggest on the right
        //Keep going to the left side till the left node is null then return the node before that

        if(root == null){ return null; }

        if(root.left == null){ return root; }

        return findMinRecursively(root.left);
    }

}
