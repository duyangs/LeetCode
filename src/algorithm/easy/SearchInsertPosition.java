package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/search-insert-position/
 * @github https://github.com/duyangs
 * @date 2019/4/2
 * @description 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {

    /**
     * 思路
     * 1.判断小于等于首位 则位置为首位下标0
     * 2.判断大于末位 则位置为末位下标（数组长度+1）
     * 3.循环判断 nums[i]<target<=nums[i+1],则位置为i+1
     *
     * 执行用时：1ms
     * 内存消耗：36MB
     * @param nums
     * @param target
     * @return
     */
    private static int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i + 1]) {
                return i + 1;
            }
            if ((target > nums[i]) && (target <= nums[i + 1])) {
                return i + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
