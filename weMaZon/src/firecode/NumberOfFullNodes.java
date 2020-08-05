package firecode;

import java.util.Stack;

/**
 * Created by oakinrele on Jul, 2020
 */
public class NumberOfFullNodes {
    int fullNodes = 0;

    public int numberOfFullNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode tempNode = nodeStack.pop();

            if (tempNode.left != null && tempNode.right != null) {
                fullNodes++;
            }

            if (tempNode.left != null) {
                nodeStack.push(tempNode.left);
            }

            if (tempNode.right != null) {
                nodeStack.push(tempNode.right);
            }
        }

        return fullNodes;
    }
}
