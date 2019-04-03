package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/length-of-last-word/
 * @github https://github.com/duyangs
 * @date 2019/4/3
 * @description 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {

    /**
     * 思路
     *
     * 1. 先去掉末尾的‘ ’空格
     * 2. 判断是否还包括 ‘ ’空格，不含空格则直接返回当前长度
     * 3. 从后向前，查找最近的‘ ’空格，根据下标计算长度
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 34.7 MB
     * @param s
     * @return
     */
    private static int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != ' '){
                s = s.substring(0,i+1);
                break;
            }
        }
        if (!s.contains(" ")) return s.length();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - 1 - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" aaaaa "));
    }
}
