import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;java
    public TreeNode(int val) {
        this.val = val
    }
}
*/
public class Solution {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    ArrayList<ArrayList<Integer> > res =  new ArrayList<ArrayList<Integer> >();


    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        if(pRoot == null){
            return res;
        }
        q.offer(pRoot);

        while(q.peek() != null){
            int size = q.size();
            ArrayList<Integer> numlist = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();
                numlist.add(t.val);
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }

            }
            res.add(numlist);
        }
        return res;
    }
}
