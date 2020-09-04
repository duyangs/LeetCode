package algorithm.easy;

import algorithm.ListNode;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @github https://github.com/duyangs
 * @date 2019/4/9
 * @description 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {


    private static ListNode deleteDuplicates(ListNode head) {
        ListNode value = head;

            while (value != null && value.getNext() != null) {
                if (value.getNext().getVal() == value.getVal()){
                    value.setNext(value.getNext().getNext());
                }else {
                    value = value.getNext();
                }
            }

        return head;
    }

    public static void main(String[] args) {
//        ListNode l15 = new ListNode(3);
//        ListNode l14 = new ListNode(3);
//        l14.next = l15;
        ListNode l13 = new ListNode(2);
        ListNode l12 = new ListNode(1);
//        l13.next = l14;
        l12.setNext(l13);
        ListNode l11 = new ListNode(1);
        l11.setNext(l12);

        ListNode value = deleteDuplicates(l11);
        while (value != null) {
            System.out.print(value.getVal());
            if (value.getNext() != null) {
                System.out.print("->");
            }
            value = value.getNext();
        }
    }
}
