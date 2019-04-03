package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/maximum-subarray/
 * @github https://github.com/duyangs
 * @date 2019/4/3
 * @description 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaximumSubArray {


    private static int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int nowSub = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nowSub > 0) {
                nowSub += nums[i];
            } else {
                nowSub = nums[i];
            }
            if (nowSub > maxSub) {
                maxSub = nowSub;
            }
        }
        return maxSub;
    }

    /**
     * 二分法
     * @param nums
     * @return
     */
    private static int maxSubArray2(int[] nums){
        return divide(nums,0,nums.length-1);
    }

    private static int divide(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (left == right - 1) {
            return Math.max(Math.max(nums[left], nums[right]), nums[left] + nums[right]);
        }
        int mid = (left + right) >> 1;
        int lSum = divide(nums, left, mid - 1);
        int rSum = divide(nums, mid + 1, right);

        int max = nums[mid];
        int sum = max;
        for (int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
        }

        sum = max;
        for (int j = mid + 1; j <= right; j++) {
            sum += nums[j];
            max = Math.max(max, sum);
        }

        return Math.max(Math.max(lSum, rSum), max);
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
