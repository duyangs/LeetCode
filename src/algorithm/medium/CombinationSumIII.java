package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuYang
 * @LeetCode https://leetcode-cn.com/problems/combination-sum-iii/
 * @github https://github.com/duyangs
 * @date 2020/9/11
 * @description 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumIII {

    private static List<List<Integer>> ans = new ArrayList<>();

    private static List<List<Integer>> combinationSum3(int k, int n) {
        int maxIndex = Math.min(n, 9);
        dfs(k, n, 1,maxIndex,new ArrayList<Integer>());
        return ans;
    }

    /**
     * 思路 递归
     * 找到1个数 然后在后续的数中找与这个数和为目标数的 数组
     *
     * @param k
     * @param n
     * @param minIndex
     * @param maxIndex
     * @param list
     */
    private static void dfs(int k, int n, int minIndex,int maxIndex,List<Integer> list) {

        for (int i = minIndex; i <= maxIndex; i++) {
            if (i < n) {//当前数小于局部目标数，递归，查找后续数组成员
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.addAll(list);
                l.add(i);
                dfs(k-1,n-i,i+1,maxIndex,l);
            } else if (i > n) { //当前数大于局部目标数 则返回
                return;
            } else {//当前数等于局部目标数
                if (k == 1){//同时所差数为1，即满足要求数组长度
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.addAll(list);
                    l.add(i);
                    ans.add(l);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> l = combinationSum3(3, 9);
        System.out.println(l);
    }
}
