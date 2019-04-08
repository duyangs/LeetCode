package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/climbing-stairs/
 * @github https://github.com/duyangs
 * @date 2019/4/8
 * @description 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    /**
     * 方法一：暴力法
     * 算法
     *
     * 在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。而在每一步中我们都会继续调用 climbStairs
     * 这个函数模拟爬 1 阶和 2 阶的情形，并返回两个函数的返回值之和。
     *
     *climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
     *
     * 其中 ii 定义了当前阶数，而 nn 定义了目标阶数。
     *
     * 复杂度分析
     * 时间复杂度：O(2^n)。树形递归的大小为 2^n
     *
     * 空间复杂度：O(n)。递归树的深度可以达到 n 。
     */
    private static int climbStairs1(int n) {
        return climb_Stairs1(0, n);
    }
    private static int climb_Stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs1(i + 1, n) + climb_Stairs1(i + 2, n);
    }


    /**
     * 方法 2：记忆化递归
     * 算法
     *
     * 在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在
     * memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果。
     *
     * 在 memo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 n 。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n) 。树形递归的大小可以达到 n 。
     *
     * 空间复杂度：O(n) 。递归树的深度可以达到 n 。
     * @param n
     * @return
     */
    private static int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs2(0, n, memo);
    }
    private static int climb_Stairs2(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs2(i + 1, n, memo) + climb_Stairs2(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 方法3：动态规划
     * 算法
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效构建，
     * 我们可以使用动态规划来解决这一问题。
     * 第i阶可以由以下两种方法得到：
     * 1.在第（i-1）阶后向上爬一阶。
     * 2.在第（i-2)阶后向上爬2阶。
     * 所以到达第i阶的方法总数就是第（i-1）阶和第（i-2)阶的方法数之和。
     * 令dp[i]表示能到达第i阶的方法数总数。
     * dp[i]=dp[i-1]+dp[i-2]
     *
     * 复杂度分析
     * 时间复杂度：O(n)，单循环到n。
     * 空间复杂度：O(n),dp数组用了n的空间。
     *
     * @param n
     * @return
     */
    private static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 方法 4: 斐波那契数
     * @param n
     * @return
     */
    private static int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 方法 5: Binets 方法
     * @param n
     * @return
     */
    private static int climbStairs5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    private static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 方法 6: 斐波那契公式
     * @param n
     * @return
     */
    private static int climbStairs6(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }



    public static void main(String[] args){
        System.out.println(climbStairs3(5));
    }
}
