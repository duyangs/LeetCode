package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/implement-strstr/
 * @github https://github.com/duyangs
 * @date 2019/3/26
 * @description 实现strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImplementStrStr {

    /**
     * 思路
     * 1.needle为空返回 0
     * 2.haystack 不包含 needle 返回 -1
     * 3.循环遍历haystack,在haystack中找到needle的首字母，找到之后以所在坐标a为起始位置，对比haystack[a+j]与needle[j].
     * 如果一一对应则找到正确坐标a,跳出整个循环体；如果出现不相符数据，则立即跳出内循环
     * @param haystack
     * @param needle
     * @return
     *
     * 执行用时：7ms
     * 内存消耗：36.7MB
     */
    private static int strStr(String haystack, String needle) {
        if ((needle == null) || (needle.isEmpty())) return 0;
        if (!haystack.contains(needle)) return -1;
        int index = 0;
        labe:
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                    if (j == (needle.length() - 1)) {
                        index = i;
                        break labe;
                    }
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa","bba"));
    }
}
