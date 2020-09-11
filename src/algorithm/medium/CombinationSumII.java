package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author DuYang
 * @LeetCode https://leetcode-cn.com/problems/combination-sum-ii/
 * @github https://github.com/duyangs
 * @date 2020/9/10
 * @description 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return fun2(candidates, target);
    }

    /**
     *
     * @param candidates 数组
     * @param target 目标值
     * @return 结果组合
     *
     * 思路：依次遍历获取可能的结果，递归，最后去重 ，耗时，耗内存
     */
    private static List<List<Integer>> fun1(int[] candidates, int target) {
        return childSum(0, target, candidates);
    }

    /**
     * @param index      起始下标
     * @param t          目标值
     * @param candidates 数组
     * @return 组合
     */
    private static List<List<Integer>> childSum(int index, int t, int[] candidates) {
        List<List<Integer>> list = new ArrayList<>();
        for (int j = index; j < candidates.length; j++) {
            int b = candidates[j];
            if (b == t) {
                list.add(List.of(b));
                continue;
            } else if (b > t) {
                continue;
            } else {
                List<List<Integer>> childList = childSum(j + 1, t - b, candidates);
                for (List<Integer> l : childList) {
                    List<Integer> cl = new ArrayList<>();
                    cl.add(b);
                    cl.addAll(l);
                    list.add(cl);
                }
            }
        }

        return deduplication(list);
    }

    private static List<List<Integer>> deduplication(List<List<Integer>> list){
        List<List<Integer>> newList = new ArrayList<>();
        for (List<Integer> l : list){
            if (notContain(newList,new ArrayList<>(l))){
                newList.add(l);
            }
        }
        return newList;
    }

    private static Boolean notContain(List<List<Integer>> list,List<Integer> l){
        Collections.sort(l);
        for (List<Integer> pL : list){
            if (equals(new ArrayList<>(pL),l)){
                return false;
            }
        }
        return true;
    }

    private static Boolean equals(List<Integer> l1,List<Integer> l2){
        if (l1.size() != l2.size()){//可能重复
            return false;
        }
        Collections.sort(l1);
        for (int i=0;i<l1.size();i++){
            if (!l1.get(i).equals(l2.get(i))){
                return false;
            }
        }
        return true;
    }

    private static List<int[]> freq = new ArrayList<int[]>();
    private static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private static List<Integer> sequence = new ArrayList<Integer>();

    /**
     * 官方提供的 递归+回溯的优化算法
     * @param candidates
     * @param target
     * @return
     */
    private static List<List<Integer>> fun2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    private static void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] i = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> l = combinationSum2(i, 8);
        System.out.println(l);
    }

}
