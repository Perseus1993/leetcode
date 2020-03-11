//解法1
//循环中判断并去掉重复元素 while里面用if判断，while套while很复杂容易晕
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }

        }
        return head.next;

    }
}

//解法2
//在hashset中存储重复的val（不要用hashmap存（node，node数量）！因为node的val相同不代表node相同）
//最后注意下set存入是add 不要和map的put搞混
import java.util.HashSet;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        HashSet<Integer> set = new HashSet<>();
        ListNode tmp = pHead;
        while(tmp != null){
            if(tmp.next != null && tmp.val == tmp.next.val)
            set.add(tmp.val);
            tmp = tmp.next;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next= pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while(cur != null){
            if(set.contains(cur.val)){
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;

    }
}
//解法3 递归
//比较难想，递归跳出条件：next是null，或者是第一个不与前面值重复的节点
import java.util.HashSet;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        if(pHead.val == pHead.next.val){
            ListNode possibleNode = pHead.next;
            while(possibleNode != null && possibleNode.val == pHead.val){
                possibleNode = possibleNode.next;
            }
            return deleteDuplication(possibleNode);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }
}
