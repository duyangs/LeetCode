package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/add-binary/
 * @github https://github.com/duyangs
 * @date 2019/4/8
 * @description 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    private static String addBinary(String a, String b) {
        //定义一个数组 长度为 最长入参+1
        int[] value = new int[((a.length() > b.length()) ? a.length() : b.length()) + 1];
        int aL = a.length() - 1;//a参数 最大下标
        int bL = b.length() - 1;//b参数 最大下标
        int aV = 0;//临时变量 存放 a参数的某一下标元素
        int bV = 0;//临时变量 存放 b参数的某一下标元素
        for (int i = value.length - 1; i > 0; i--) {//循环区间 1<=i<=value.length-1
            if (aL >= 0) {//如果当前 a参数的元素还没取完
                aV = (a.charAt(aL) == '1') ? 1 : 0;//aV存放a[aL]
                aL--;//aL递减
            } else {//如果当前 a参数的元素已取完，aV赋值0
                aV = 0;
            }
            if (bL >= 0) {
                bV = (b.charAt(bL) == '1') ? 1 : 0;
                bL--;
            } else {
                bV = 0;
            }
            int x = aV + bV + value[i];
            value[i] = x % 2;//value[i] 取值为 x除2取余
            value[i - 1] = x / 2;//value[i-1] 取值为 x除2取整
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {//遍历value
            if (value[i] == 0) {
                if (sb.length() != 0) {//如果value[i]等于0，则判断sb长度（如果长度为0，则表示此前都为0，则不添加元素）
                    sb.append(value[i]);
                }
            } else {
                sb.append(value[i]);
            }

        }
        return (sb.toString().isEmpty()) ? "0" : sb.toString();//如果sb长度为空则表示数组value所有元素都为0，则返回“0”
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
