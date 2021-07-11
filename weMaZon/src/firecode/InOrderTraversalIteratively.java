package firecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by oakinrele on Mar, 2021
 */
public class InOrderTraversalIteratively {
    public ArrayList<Integer> inorderItr(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> values = new ArrayList<>();

        InOrderTraversal(root,values);

        return values;
    }


    private void InOrderTraversal(TreeNode root, ArrayList<Integer> values){

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;

        while(!nodes.isEmpty() || curr != null){
            if(curr != null){
                nodes.push(curr);
                curr = curr.left;
            }

            else{
                curr = nodes.pop();
                values.add(curr.val);
                curr = curr.right;
            }

        }
    }
}
