package firecode;

import java.util.Stack;

/**
 * Created by oakinrele on Mar, 2021
 */
public class findMaxInABinaryTree {
    public int findMaxItr(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return root.val;
        }

        return findMaxIteratively(root);
    }


    public int findMaxIteratively(TreeNode root) {
        int max = root.val;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();

            if(tempNode.val >= max ){
                max = tempNode.val;
            }

            if(tempNode.left != null){
                stack.push(tempNode.left);
            }

            if(tempNode.right != null){
                stack.push(tempNode.right);
            }
        }

        return max;
    }

    public int findMaxRecursively(TreeNode node) {
        if(node == null){
            return 0;
        }
        int res = node.val;

        int lres = findMaxRecursively(node.left);
        int rres = findMaxRecursively(node.right);

        if (lres > res)
            res = lres;

        if (rres > res)
            res = rres;

        return res;
    }
}
