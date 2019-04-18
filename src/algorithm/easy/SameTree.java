package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/same-tree/
 * @github https://github.com/duyangs
 * @date 2019/4/18
 * @description 相同的树
 */
public class SameTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 执行用时 : 1 ms, 在Same Tree的Java提交中击败了94.84% 的用户
     * 内存消耗 : 33.5 MB, 在Same Tree的Java提交中击败了93.96% 的用户
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree(TreeNode p,TreeNode q){
        if ((p == null) && (q == null)) {//两边都为空，返回true
            return true;
        }else if (((p == null) && (q != null)) || ((p != null) && (q == null))){//仅一边为空返回false
            return false;
        }
        if (p.val != q.val) return false;//val不相等 返回false
        boolean left = false;//左树默认值 false
        boolean right = false;//右树默认值 false
        if ((p.left != null) && (q.left != null)){//左数不为空，再次调用isSameTree
            left = isSameTree(p.left,q.left);
        }else if ((p.left == null) && (q.left == null)){//左树都为空，返回true
            left = true;
        }else {//有一方为空，返回false
            left = false;
        }

        if ((p.right != null) && (q.right != null)){
            right = isSameTree(p.right,q.right);
        }else if ((p.right == null) && (q.right == null)){
            right = true;
        }else {
            right = false;
        }
        return left && right;//左右两树均为true，则相等
    }

    public static void main(String[] args){

    }
}
