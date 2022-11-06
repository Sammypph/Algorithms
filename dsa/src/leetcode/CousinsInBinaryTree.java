package leetcode;

import java.util.Objects;

/**
 * Created by oakinrele on May, 2020
 */
public class CousinsInBinaryTree {
    static boolean isCousin = false;
    TreeNode node;
    public static boolean isCousins(TreeNode root, int x, int y) {
        int heightLeft = findLeftHeight(root,x,root);
        int heightRight = findRightHeight(root,y,root);

         return heightLeft == heightRight;
    }



//    public static int findHeight(TreeNode root,int x, int y, TreeNode parentNode)
//    {
//        int height = 0;
//        int lHeight = 0;
//        int rHeight = 0;
//        TreeNode leftParent;
//        TreeNode rightParent;
//
//        if(root == null)
//        {
//            return -1;
//        }
//
//        if(root.left == null)
//        {
//            return 0;
//        }
//
//        if(root.right == null)
//        {
//            return 0;
//        }
//
//        if(root.val == x || root.val == y )
//        {
//            return height;
//        }
//
//        int leftHeight = findHeight(root.left,x,y,root);
//        int rightHeight = findHeight(root.right,x,y,root);
//
//
//        if(leftHeight > height)
//        {
//            lHeight = leftHeight;
//        }
//
//        if(rightHeight > height)
//        {
//            rHeight = leftHeight;
//        }
//
//
//        return height + 1;
//    }

    public static int solution(TreeNode root,int firstChild, int secondChild, TreeNode parentNode)
    {
        int height = 0;
        if(root == null)
        {
            return -1;
        }

        if(root.val == firstChild)
        {
            System.out.println("Inside Condition firstChild:"+root.val);
            System.out.println("Parent of node:"+parentNode.val);
            return height;
        }

        if(root.val == secondChild )
        {
            System.out.println("Inside Condition secondChild:"+root.val);
            System.out.println("Parent of node:"+parentNode.val);
            return height;
        }

        if(root.left == null && root.right == null)
        {
            return 0;
        }

        int leftHeight = solution(root.left,firstChild,secondChild,root);
        int rightHeight = solution(root.right,firstChild,secondChild,root);


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




    public static int findLeftHeight(TreeNode root,int child,TreeNode parentNode)
    {
        int height = 0;
        if(root == null)
        {
            return -1;
        }

        if(root.left == null && root.right == null)
        {
            return 0;
        }

        if(root.val == child)
        {
            return height;
        }

        int leftHeight = findLeftHeight(root.left,child,root);

        if(leftHeight > height)
        {
            height = leftHeight;
        }
        return height + 1;

    }

    public static int findRightHeight(TreeNode root,int child,TreeNode parentNode)
    {
        int height = 0;
        if(root == null)
        {
            return -1;
        }

        if(root.left == null && root.right == null)
        {
            return 0;
        }

        if(root.val == child)
        {
            return height;
        }

        int rightHeight = findRightHeight(root.right,child,root);

        if(rightHeight > height)
        {
            height = rightHeight;
        }

        return height + 1;

    }

    public static int isCousinsHelper(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }

        if(root.left == null && root.right == null)
        {
            return 0;
        }

        int height = 0;

            int leftHeight = isCousinsHelper(root.left);
            int rightHeight = isCousinsHelper(root.right);

            if(leftHeight >= rightHeight)
            {
                height = leftHeight;
            }

            if(rightHeight >= leftHeight)
            {
                height = rightHeight;
            }

            if(leftHeight == rightHeight)
            {
                isCousin = true;
            }

            return height + 1;

    }



    public static void main(String [] args)
    {

    }





     public class TreeNode
     {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
     }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CousinsInBinaryTree that = (CousinsInBinaryTree) o;
        return Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
