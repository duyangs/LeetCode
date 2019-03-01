package algorithm.easy;

import java.util.LinkedHashMap;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/roman-to-integer/
 * @github https://github.com/duyangs
 * @date 2019/2/28
 * @description 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的
 * 数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {

    /**
     * 我的实现方式
     * 思路：遍历然后按对应的值累加，只有在遇到 IV = 4,IX = 9,XL = 40,XC = 90,CD = 400,CM = 900 的固定组合则减去固定值2，20，200
     * @param roman 罗马数字字符
     * @return 结果
     */
    private static int romanToInt(String roman){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int length = roman.length();
        int value = 0;
        for (int i = 0;i<length;i++){
            char c = roman.charAt(i);
            value += map.get(roman.charAt(i));
            if (i > 0){
                char c2 = roman.charAt(i-1);
                if (((c == 'V')||(c == 'X')) && (c2 == 'I')) {
                    value -= 2;
                    continue;
                }
                if (((c == 'L')||(c == 'C')) && (c2 == 'X')) {
                    value -= 20;
                    continue;
                }
                if (((c == 'D')||(c == 'M')) && (c2 == 'C')) {
                    value -= 200;
                    continue;
                }
            }
        }
        return value;
    }

    //当前LeetCode还没有官方题解，真想学习一波

    public static void main(String[] args){
        int value = romanToInt("MCMXCIV");
        System.out.println(value);
    }
}
