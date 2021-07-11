package firecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oakinrele on Mar, 2021
 */
public class FindKthLargestNodeInABST {
    public TreeNode findKthLargest(TreeNode root, int k) {
    if(root == null){
        return null;
    }
    List<TreeNode> values = new ArrayList<>();
    inorderTraversal(root, values);

        return values.get(values.size() - k);
}


    private void inorderTraversal(TreeNode root, List<TreeNode> values) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, values);
        values.add(root);
        inorderTraversal(root.right, values);
    }

  // InOrderTraversal (LPR)

  /*
  First approach:
  - Go through the Tree
  - Add the values to a List O(n)
  - Sort the list in Desc  O(nlogn)
  - Return value at (k-1)

  Second approach:
  - Go through the Tree using (Inorder approach)
  - Add the values to a List
    {1,2,3,4,5,6}
  - Return value at (list.size - k);

  Third appraoch:
  - Try to solve it in-place
  */
}
