public class Solution {
    int max = 0;
    int tmp = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        tmp += 1;
        if(root.left == null && root.right == null){
            max = tmp > max ? tmp : max;
            tmp -= 1;
        }
        TreeDepth(root.left);
        TreeDepth(root.right);
        return max;
    }
}


public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left) + 1,TreeDepth(root.right) + 1);
    }
}
