package algorithm.easy;

import java.math.BigInteger;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/sqrtx/
 * @github https://github.com/duyangs
 * @date 2019/4/8
 * @description x的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtX {

    /**
     * 循环 数越大 循环次数越多
     * @param x
     * @return
     */
    private static int mySqrt(int x) {
        int mind = x / 2 + 1;
        double y;
        double y1;
        for (int i = 0; i <= mind; i++) {
            y = i * i;
            y1 = (i + 1d) * (i + 1d);
            if ((y == x) || ((y < x) && (y1 > x))) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 二分法
     * @param x
     * @return
     */
    private static int mySqrt2(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mid <= x / mid)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395599));
    }
}
