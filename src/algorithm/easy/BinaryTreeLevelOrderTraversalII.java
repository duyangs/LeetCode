package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuYang
 * @LeetCode https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @github https://github.com/duyangs
 * @date 2019/7/17
 * @description 二叉树层次遍历II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversalII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rootList = new ArrayList<>();
        levelOrder2(root,rootList,1);
//        if (root == null) return rootList;
//        List<Integer> roots = new ArrayList<>();
//        roots.add(root.val);
//        rootList = levelOrder(root.left, root.right);
//        rootList.add(roots);
        return rootList;
    }

    /**
     * 分左右子树的递归,对题理解失误，做成了对元素遍历，分左右子树的方式
     *
     * @param left 左子树
     * @param right 右子树
     * @return List<List<Integer>>
     */
    private static List<List<Integer>> levelOrder(TreeNode left, TreeNode right) {
        List<List<Integer>> rootList = new ArrayList<>();
        List<Integer> root = new ArrayList<>();
        List<List<Integer>> leftList = new ArrayList<>();
        List<List<Integer>> rightList = new ArrayList<>();
        if (left != null) {
            leftList = levelOrder(left.left, left.right);
            root.add(left.val);
        }

        if (right != null) {
            rightList = levelOrder(right.left, right.right);
            root.add(right.val);
        }
        if (rightList.size() > 0) rootList.addAll(rightList);
        if (leftList.size() > 0) rootList.addAll(leftList);
        if (root.size() > 0) rootList.add(root);
        return rootList;
    }

    /**
     * 二叉树 层遍历  递归
     * @param root root
     * @param rootList root list
     * @param level 层
     */
    private static void levelOrder2(TreeNode root, List<List<Integer>> rootList, int level) {
        if (root == null) return;
        if (level > rootList.size()) {
            List<Integer> list = new ArrayList<>();
            rootList.add(0, list);
        }
        rootList.get(rootList.size() - level).add(0, root.val);
        levelOrder2(root.right,rootList,level+1);
        levelOrder2(root.left,rootList,level+1);
    }

    public static void main(String[] args) {

    }
}
