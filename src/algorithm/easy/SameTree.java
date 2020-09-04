package algorithm.easy;

import algorithm.TreeNode;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/same-tree/
 * @github https://github.com/duyangs
 * @date 2019/4/18
 * @description 相同的树
 */
public class SameTree {

    /**
     * 执行用时 : 1 ms, 在Same Tree的Java提交中击败了94.84% 的用户
     * 内存消耗 : 33.5 MB, 在Same Tree的Java提交中击败了93.96% 的用户
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree(TreeNode p, TreeNode q){
        if ((p == null) && (q == null)) {//两边都为空，返回true
            return true;
        }else if (((p == null) && (q != null)) || ((p != null) && (q == null))){//仅一边为空返回false
            return false;
        }
        if (p.getVal() != q.getVal()) return false;//val不相等 返回false
        boolean left = false;//左树默认值 false
        boolean right = false;//右树默认值 false
        if ((p.getLeft() != null) && (q.getLeft() != null)){//左数不为空，再次调用isSameTree
            left = isSameTree(p.getLeft(),q.getLeft());
        }else if ((p.getLeft() == null) && (q.getLeft() == null)){//左树都为空，返回true
            left = true;
        }else {//有一方为空，返回false
            left = false;
        }

        if ((p.getRight() != null) && (q.getRight() != null)){
            right = isSameTree(p.getRight(),q.getRight());
        }else if ((p.getRight() == null) && (q.getRight() == null)){
            right = true;
        }else {
            right = false;
        }
        return left && right;//左右两树均为true，则相等
    }

    public static void main(String[] args){

    }
}
