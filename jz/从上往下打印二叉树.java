import java.util.ArrayList;
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
public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        list.add(root);
        while(list.size() != 0){
            if(list.get(0).left != null){
                list.add(list.get(0).left);
            }
            if(list.get(0).right != null){
                list.add(list.get(0).right);
            }
            res.add(list.remove(0).val);
        }
        return res;
    }
}
