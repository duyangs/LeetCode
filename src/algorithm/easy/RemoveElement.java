package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/remove-element/
 * @github https://github.com/duyangs
 * @date 2019/3/26
 * @description 移除元素
 */
public class RemoveElement {

    /**
     * 思路
     * 1.正序遍历寻找等于val的元素a (a(nums[i])的取值范围nums[0]<nums[i]<nums.length)
     * 2.倒序遍历寻找不等于val的元素b （b(nums[j])的取值范围 nums[i]<nums[j]<nums.length）
     * 3.值交换a=b,b=a
     * i
     * 当正序遍历下标为i的数组不等于val或成功交换则新数组长度+1
     * @param nums 数组nums
     * @param val 值val
     * @return 移除所有数组等于val的元素，返回移除后数组的新长度
     *
     * 执行用时 6ms
     * 内存消耗 37.3MB
     */
    private static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                for (int j=nums.length-1;j>i;j--){
                    if (nums[j] != val){
                        nums[i] = nums[j];
                        nums[j] = val;
                        length++;
                        break;
                    }
                }
            }else {
                length++;
            }
        }
        return length;
    }


    /**
     * 方法一：双指针 (官方题解) 耗时和空间 和我自己实现的差不多
     * 思路
     *
     * 既然问题要求我们就地删除给定值的所有元素，我们就必须用 O(1) 的额外空间来处理它。如何解决？我们可以保留两个指针 i 和 j，
     * 其中 i 是慢指针，j 是快指针。
     *
     * 算法
     *
     * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j]̸=val，我们就复制 nums[j] 到 nums[i] 并同时递增两个索引。
     * 重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
     *
     * 该解法与 删除排序数组中的重复项 的解法十分相似。
     *
     * **复杂度分析**
     * 时间复杂度：O(n)， 假设数组总共有 n 个元素，i 和 j至少遍历 2n 步。
     *
     * 空间复杂度：O(1)。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

}
