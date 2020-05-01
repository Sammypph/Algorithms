package FireCode;

import apple.laf.JRSUIUtils;

/**
 * Created by oakinrele on Feb, 2020
 */
public class InOrderTraversal {
    public void inOrder(TreeNode1 root)
    {
        if(root == null)
        {
            return;
        }

        //inOrder Traversal
        if(root.left != null )
        {
          inOrder(root.left);
        }
        //Print items here.
        if(root.right != null)
        {
            inOrder(root.right);
        }
    }


    //LPR
    public void inOrderRecursively(TreeNode1 root)
    {
        if(root == null)
        { return;}

        inOrderRecursively(root.left);
        System.out.print(root.data + " ");
        inOrderRecursively(root.right);
    }
}






class TreeNode1
{
    int data;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int data, TreeNode1 left, TreeNode1 right)
    {
        this.data = data;
        this.left = left;
        this.right = right;

    }
}
