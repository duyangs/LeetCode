package algorithm.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/plus-one/
 * @github https://github.com/duyangs
 * @date 2019/4/3
 * @description 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    /**
     * 思路
     * 1. 从末位向首位，依次判断是否可有效加一（加1后小于10，否则需要进位），如果可以有效加一则加一并退出循环，否则本位置0；
     * 2. 判断首位是否为0，为0则表示，需要进位1，并增加数组长度1；
     * 3. 新建数组（长度加1）首位置1，然后循环赋值
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 37.2 MB
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if ((digits[i] + 1) < 10) {
                digits[i] += 1;
                break;
            }else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i=1;i<res.length;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] v = plusOne(new int[]{9, 9, 9, 9});
        for (int i : v) {
            System.out.print(i + ",");
        }

    }
}
