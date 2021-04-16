import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Q06ReversePrint {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 方法一：
     * 创建对应长度的数组，遍历链表倒序插入
     */
    public int[] reversePrint1(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        int[] result = new int[length];
        node = head;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = node.val;
            node = node.next;
        }
        return result;
    }

    /**
     * 方法二：
     * 使用栈
     */
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack= new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;

    }
}
