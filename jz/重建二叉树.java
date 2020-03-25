//解法1
//前序遍历是先输出根节点的，因此前序遍历第一个元素iu是中序遍历左右子树的分界线
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
