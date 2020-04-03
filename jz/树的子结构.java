/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//解法1
//分为两步：第一是找到和root2节点相等的点，第二步再判断这个相等的点下面的点都符合要求。注释掉的部分是错误的思路（假设和子结构根节点相同的点有多个的情况下出错）

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 ==null) {
            return false;
        }
        //if(root1.val == root2.val){
           // return Judge(root1,root2);
        //}else{
         //   return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        //}
        return Judge(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean Judge(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return Judge(root1.left, root2.left) && Judge(root1.right, root2.right);
        }
        return false;
    }
}
