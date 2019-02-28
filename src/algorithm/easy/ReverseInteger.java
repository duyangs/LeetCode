package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/reverse-integer/
 * @github https://github.com/duyangs
 * @date 2019/2/28
 * @description 整数反转
 */
public class ReverseInteger {

    /**
     * 自己的实现方法
     * 内存消耗46MB 执行用时51ms (太渣)
     *
     * @param x 待反正整数
     * @return 结果
     */
    private static int reverseInteger1(int x) {
        String xString = String.valueOf(x);
        if (x == 0) {
            return x;
        }
        StringBuffer buffer = new StringBuffer();
        int startIndex = (x < 0 ? 1 : 0);
        if (startIndex == 1){
            buffer.append("-");
        }
        for (int i = xString.length() - 1; i >= startIndex; i--) {
            buffer.append(xString.charAt(i));
        }
        int value = 0;
        try {
            value = Integer.parseInt(buffer.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 官方题解 （明显聪明很多 暴汗）
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 思路
     *
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     *
     * 算法
     *
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * 我们想重复“弹出” x的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 但是，这种方法很危险，因为当 temp = rev * 10 + pop 时会导致溢出。
     *
     * 幸运的是，事先检查这个语句是否会导致溢出很容易。
     *
     * 为了便于解释，我们假设 rev 是正数。
     *
     * 如果 temp =rev⋅10+pop 导致溢出，那么一定有 rev≥ INTMAX / 10。
     * 如果 rev> INTMAX / 10，那么 temp=rev⋅10+pop 一定会溢出。
     * 如果 rev== INTMAX / 10，那么只要 pop>7，temp=rev⋅10+pop 就会溢出。
     *
     * 当rev 为负时可以应用类似的逻辑。
     *
     * @param x 待反正整数
     * @return 结果
     */
    private static int reverseInteger2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            System.out.println("pop = " + pop + " | x = " + x + " | rev = " + rev);
        }
        return rev;
    }

    public static void main(String[] args) {
        int value = reverseInteger2(123456);
        System.out.println(value);
    }
}
