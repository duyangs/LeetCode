package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @github https://github.com/duyangs
 * @date 2019/3/19
 * @description 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     *  思路：
     *  比较两个链表的首位，取小者放入新的链表
     *
     *  漏洞：仅支持相同位数，从小到大的有序链表 （感兴趣可以完善）
     *
     *  耗时：14ms
     *  内存：38.9mb 内存消耗较多 主要是对象创建的较多（有优化空间）
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的链表
     */
    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if ((l1 == null) && (l2 == null)) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode value;
        if (l1.val > l2.val) {
            value = new ListNode(l2.val);
            value.next = mergeTwoSortedLists(l1, l2.next);
        } else {
            value = new ListNode(l1.val);
            value.next = mergeTwoSortedLists(l1.next, l2);
        }
        return value;
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2);
        l12.next = l13;
        ListNode l11 = new ListNode(1);
        l11.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3);
        l22.next = l23;
        ListNode l21 = new ListNode(1);
        l21.next = l22;

        ListNode value = mergeTwoSortedLists(l11,l21);
        while (value != null){
            System.out.print(value.val);
            if (value.next != null){
                System.out.print("->");
            }
            value = value.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
