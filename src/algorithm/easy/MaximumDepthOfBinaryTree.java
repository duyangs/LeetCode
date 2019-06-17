package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @github https://github.com/duyangs
 * @date 2019/6/17
 * @description 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    /**
     * 分左右子树获取深度
     *
     * @param root   root树
     * @param length 原长度 或理解为已知长度
     * @return 最大长度  深度
     */
    private static int getDepth(TreeNode root, int length) {
        if (root == null) return length;
        length++;
        int lLength = getDepth(root.left, length);
        int rLength = getDepth(root.right, length);
        if (lLength > rLength) {
            return lLength;
        } else {
            return rLength;
        }
    }
}
