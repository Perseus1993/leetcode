/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//解法一 扫描两个链表，最直接最暴力，挨个核对节点地址，不推荐，刚接触题目练练手也行
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

//解法二 hashSet方法 ，把链表1的每个点都放进去，再遍历链表2进行比对
import java.util.HashSet;
import java.util.Set;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<Integer> hs = new HashSet<>();
        ListNode node1 = pHead1;
        while(node1 != null){
            hs.add(node1);
            node1 = node1.next;
        }
        ListNode node2 = pHead2;
        while(node2 != null){
            if(hs.contains(node2)){
                return node2;
            }
            node2 = node2.next;
        }
        return null;
    }
}

//解法三  两个链表最后相重合
/*充分利用题目条件，两个链表公用点的next指向同一个点，因此自从公共节点之后所有的点都是一样的，假如两个链表长度一样很好办，
同位置元素两两对比即可。如果两个链表长度不同，
需要先把长链表先开始遍历，直到两个链表没有遍历元素的个数相等，此时两个链表尾部是重合的，可以开始两两对比。*/
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
//解法四 构造相等的链表，这样最后的部分是会重合的
//让两个链表尾部是重合的巧妙办法，链表1+链表2拼起来，链表2+链表1拼起来，那么这两个打链表的长度是相同的且尾部相同元素位置是意义对应的，此时直接开始对比即可
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while(node1 != node2){
            node1 = node1 == null ? pHead2 : node1.next;
            node2 = node2 == null ? pHead1 : node2.next;
        }
        return node1;
    }
}
