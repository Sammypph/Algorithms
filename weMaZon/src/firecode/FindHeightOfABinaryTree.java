package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class FindHeightOfABinaryTree {
    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public int findHeight(IterativePreorderTraversal.TreeNode root) {

        if(root == null)
        {
            return -1;
        }

        if(root.left == null && root.right == null)
        {
            return 0;
        }

        int height = 0;
        int leftHeight;
        int rightHeight;

            leftHeight = findHeight(root.left);
            rightHeight = findHeight(root.right);


            if(leftHeight >= rightHeight)
            {
                height = leftHeight;
            }

            if(rightHeight >= leftHeight)
            {
                height = rightHeight;
            }

        return height + 1;
    }


    public static void main(String [] args)
    {

    }
}
