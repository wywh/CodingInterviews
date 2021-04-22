/**
 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 返回删除后的链表的头节点。

 注意：此题对比原题有改动

 示例 1:
 输入: head = [4,5,1,9], val = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 示例 2:
 输入: head = [4,5,1,9], val = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class Q18DeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

    // 单节点
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode res = head; //用来保存头指针
        while(head!=null){
            if(res.val == val){ //如果要删除的目标节点为第一个节点，直接返回头结点的下一个节点即可
                return head.next;
            }
            if(head.next.val == val){ //如果当前节点的下一个节点的值为要删除的节点的值
                head.next = head.next.next;//让当前节点的下一个节点指向节点的下一个节点的下一个节点
                break;  //即删除目标节点，直接退出循环
            }
            head = head.next; //以上条件都不满足的情况下，遍历下个节点。
        }
        return res;  //在头结点不是目标节点的情况下，返回删除目标节点后的头结点
    }

}
