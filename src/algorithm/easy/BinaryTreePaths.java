package algorithm.easy;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuYang
 * @LeetCode https://leetcode-cn.com/problems/binary-tree-paths/
 * @github https://github.com/duyangs
 * @date 2019/7/17
 * @description 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {

        return binaryTreeChild2(null,root);
    }

    /**
     * 方法1 会返回当前节点及其子节点
     * @param root 当前节点
     * @return 当前节点及其子节点
     */
    private static List<String> binaryTreeChild(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> leftList = binaryTreeChild(root.getLeft());//获取左子树
        List<String> rightList = binaryTreeChild(root.getRight());//获取右子树
        for (String s : leftList) {
            String path = root.getVal() + "->" + s;
            list.add(path);
        }
        for (String s : rightList) {
            String path = root.getVal() + "->" + s;
            list.add(path);
        }
        if (list.isEmpty()) {
            list.add(String.valueOf(root.getVal()));
        }
        return list;
    }

    /**
     * 方法2 返回当前节点父节点及其子节点
     * @param parent 父节点
     * @param root 当前节点
     * @return 当前节点父节点到其子节点的所有路径
     */
    private static List<String> binaryTreeChild2(String parent, TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> leftList = binaryTreeChild2(String.valueOf(root.getVal()), root.getLeft());//获取左子树
        List<String> rightList = binaryTreeChild2(String.valueOf(root.getVal()), root.getRight());//获取右子树
        String x = "";
        if (parent != null) {
            x = parent + "->";
            for (String s : leftList) {
                String path = x + s;
                list.add(path);
            }
            for (String s : rightList) {
                String path = x + s;
                list.add(path);
            }
        } else {
            list.addAll(leftList);
            list.addAll(rightList);
        }
        if (list.isEmpty()) {
            list.add(x + root.getVal());
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        node2.setRight(node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node1.setLeft(node2);
        node1.setRight(node3);
        List<String> result = binaryTreePaths(node1);
        System.out.println(result.toString());
    }

}
