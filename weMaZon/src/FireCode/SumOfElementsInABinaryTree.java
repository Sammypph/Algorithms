package FireCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Feb, 2020
 */
public class SumOfElementsInABinaryTree {
    public int sum(IterativePreorderTraversal.TreeNode root) {
            if(root == null)
            {
                return 0;
            }
            int sum = 0;
            Queue<IterativePreorderTraversal.TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                IterativePreorderTraversal.TreeNode currentNode = queue.poll();
                sum += currentNode.data;

                if(currentNode.left != null)
                {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null)
                {
                    queue.add(currentNode.right);
                }
            }

            return sum;

    }



        public int sumRecursive(IterativePreorderTraversal.TreeNode root) {
            if(root == null) return 0;
            return (root.data + sum(root.left) + sum(root.right));
        }
}
