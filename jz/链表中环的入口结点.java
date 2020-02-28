/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

//解法1 过河拆桥法
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;
        ListNode pre = pHead;
        ListNode check = pHead.next;
        while(pre != null){
            if(check == null){
                return pre;
            }
            pre.next = null;
            pre = check;
            check = check.next;

        }
        return null;
    }
}

//解法2

import java.util.HashSet;
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = pHead;

        while(tmp != null){
            //false表示增加失败
            if(!set.add(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return tmp;
    }
}

//解法3
import java.util.HashSet;
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        if(slow == null || fast == null) return null;
        while(slow != fast){
            fast = fast.next.next;
            slow = slow.next;
        }
        int count = 1;
        ListNode tmp = slow.next;
        while(tmp != slow){
            count++;
            tmp = tmp.next;
        }
        ListNode slow2 = pHead;
        ListNode fast2 = pHead;
        while(count > 0){
            count--;
            fast2 = fast2.next;
        }
        while(fast2 != slow2){
            fast2 = fast2.next;
            slow2 = slow2.next;
        }
        return fast2;
    }
}
//解法4
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead;
        ListNode fast = pHead;
        if(fast==null||fast.next==null) return null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }

        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
