package algorithm.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/valid-parentheses/
 * @github https://github.com/duyangs
 * @date 2019/3/1
 * @description 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    /**
     * 我的实现方法
     * 思路
     * 1.判断为空 返回true
     * 2.判断为偶数 （为奇数的话显然不成立）
     * 3.遍历 取列表首位 遍历当前列表 找对对应括号又半边 则从列表中删除此对数据
     *
     * 未成功
     * 无法判断出表达式的完整性（使用特殊测试用例会失败）
     * 看了官方题解 （官方题解引入栈）觉得自己的思路错误，所以放弃自己的实现方式，仅供参考
     */
//    private static boolean validParentheses(String s) {
//        if ((s == null) || s.isEmpty()) return true;
//        if ((s.length() % 2) != 0) return false;
//        if (checkFirstChar(s.charAt(0))) return false;
//        char[] chars = s.toCharArray();
//        List<Character> list = new ArrayList<>();
//        for (char c : chars) {
//            list.add(c);
//        }
//        return checkList(list);
//    }
//
//    private static boolean checkList(List<Character> list) {
//        char firstC;
//        int i;
//        for (i = 1; i < list.size(); i++) {
//            firstC = list.get(0);
//            if (checkFirstChar(firstC))return false;
//            if (checkSecondChar(firstC,list.get(i))){
//                list.remove(i);
//                list.remove(0);
//                i = 0;
//                continue;
//            }
//            if (i == list.size()-1){
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//
//    private static boolean checkSecondChar(char firstC,char secondC){
//        return (((firstC == '(') && (secondC == ')'))
//                || ((firstC == '[') && (secondC == ']'))
//                || ((firstC == '{') && (secondC == '}')));
//    }
//    private static boolean checkFirstChar(char c) {
//        return ((c == ')') || (c == ']') || (c == '}'));
//    }

    /**
     * 官方方法
     *
     * https://leetcode-cn.com/problems/valid-parentheses/solution/
     * 由于官方提示有示例图和视频，这里不做注释，感兴趣可以直接复制链接
     *
     * @param s 字符串
     * @return 结果
     */
    private static boolean validParentheses(String s) {
        // Hash table that takes care of the mappings.
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean isValid = validParentheses("(())[()]");
        System.out.println(isValid);
    }
}
