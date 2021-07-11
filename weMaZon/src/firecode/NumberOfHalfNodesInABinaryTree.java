package firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Mar, 2021
 */
public class NumberOfHalfNodesInABinaryTree {
    public int numberOfHalfNodes(TreeNode root) {
        int halfNodes = 0;
        if(root == null){
            return halfNodes;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();

            if(tempNode.left != null && tempNode.right == null ||
                    tempNode.right != null && tempNode.left == null ){
                halfNodes++;
            }

            if (tempNode.left != null)
            queue.offer(tempNode.left);

            if (tempNode.right != null)
            queue.offer(tempNode.right);

        }
        return halfNodes;

    }
}
