package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/count-and-say/
 * @github https://github.com/duyangs
 * @date 2019/4/2
 * @description 报数
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

    /**
     * 递归 +  双指针
     *
     * @param n
     * @return
     */
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }
        String lastResult = countAndSay(n - 1);
        System.out.println("lastResult:" + lastResult);
        StringBuilder result = new StringBuilder();
        int count = 1;
        int j = 0;
        for (int i = 1; i < lastResult.length(); i++) {
            if (lastResult.charAt(j) == lastResult.charAt(i)) {
                count++;
            } else {
                result.append(count).append(lastResult.charAt(j));
                count = 1;
                j = i;
            }
            if (i == lastResult.length() - 1) {
                result.append(count).append(lastResult.charAt(i));
            }
        }

        return result.toString();

    }

    private static String countAndSay2(int n) {
        if (n == 1) return "1";
        StringBuilder str = new StringBuilder();
        str.append("1");
        char temp;
        int count;
        StringBuilder sb;
        //到n 只需遍历n-1 次即可
        for (int i = 1; i < n; i++) {
            temp = str.charAt(0);
            count = 0;
            sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                //当字符不相等时 或者遍历完字符时
                if (str.charAt(j) == temp) {
                    count++;
                } else {
                    sb.append(count).append(temp);
                    //计数归零
                    temp = str.charAt(j);
                    count = 1;
                }
            }
            //最后遍历到字符串结尾的结果添加到字符串中
            sb.append(count).append(temp);
            str = sb;
            System.out.println("str:" + str.toString());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay2(2));
    }
}
