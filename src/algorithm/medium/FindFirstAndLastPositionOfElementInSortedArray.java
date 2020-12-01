package algorithm.medium;

import java.util.Arrays;

/**
 * @author DuYang
 * @LeetCode https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * @github https://github.com/duyangs
 * @date 2020/12/1
 * @description 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 使用二分查找发 分别找左右边界
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length == 0) return result;
        result[0] = findBorder(nums, nums.length, target,true);
        result[1] = findBorder(nums, nums.length, target,false);
        return result;
    }

    public static int findBorder(int[] a, int len, int key, boolean findLeft) {
        if (len < 1)
            return -1;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (findLeft) {//找左侧边界
                if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key)) {
                    return mid;
                } else if (a[mid] >= key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//找右侧边界
                if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key)) {
                    return mid;
                } else if (a[mid] <= key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 5);
        System.out.println(Arrays.toString(result));
    }

}
