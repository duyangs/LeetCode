package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @github https://github.com/duyangs
 * @date 2019/3/25
 * @description 删除排序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 方法：双指针法
     * 算法
     *
     * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 j 是慢指针，而 i 是快指针。
     * 只要 nums[i]=nums[j]，我们就增加 i 以跳过重复项。
     *
     * 当我们遇到 nums[i]̸=nums[j] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[i]）的值复制到 nums[j+1]。
     *  然后递增 j，接着我们将再次重复相同的过程，直到 i 到达数组的末尾为止。
     *
     *  复杂度分析
     *
     * 时间复杂度：O(n)， 假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
     *
     * 空间复杂度：O(1)。
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,2,3,3,3,4,4,4,4}));
    }
}
