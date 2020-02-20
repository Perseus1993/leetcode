/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//Hahset方法复杂度过大，用不了

//解法一 扫描两个链表
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while(node1 != null){
            while(node2 != null){
                if(node1 == node2){
                    return node1;
                }else{
                    node2 = node2.next;
                }
            }
            node1 = node1.next;
            node2 = pHead2;
        }
        return null;
    }
}

//解法二
import java.util.HashSet;
import java.util.Set;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<Integer> hs = new HashSet<>();
        ListNode node1 = pHead1;
        while(node1 != null){
            hs.add(node1.val);
            node1 = node1.next;
        }
        ListNode node2 = pHead2;
        while(node2 != null){
            if(hs.contains(node2.val)){
                return node2;
            }
            node2 = node2.next;
        }
        return null;
    }
}

//解法三
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = LengthOfList(pHead1);
        int l2 = LengthOfList(pHead2);
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        if(l1 <l2){
            node2 = walk(pHead2, l2 - l1);
        }
        if(l1 > l2){
            node1 = walk(pHead1, l1 - l2);
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public int LengthOfList(ListNode p){
        int length = 1;
        while(p != null){
            length++;
            p = p.next;
        }
        return length;
    }

    public ListNode walk(ListNode node, int n){
        while(n > 0){
            node = node.next;
            n--;
        }
        return node;
    }
}
