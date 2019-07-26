package cn.likegirl.lintcode.最近公共祖先III;


/**
 * 578. 最近公共祖先 III
 * 中文English
 * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
 *
 * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
 *
 * 返回 null 如果两个节点在这棵树上不存在最近公共祖先的话。
 *
 * 样例
 * 样例1
 *
 * 输入:
 * {4, 3, 7, #, #, 5, 6}
 * 3 5
 * 5 6
 * 6 7
 * 5 8
 * 输出:
 * 4
 * 7
 * 7
 * null
 * 解释:
 *   4
 *  / \
 * 3   7
 *    / \
 *   5   6
 *
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * LCA(5, 8) = null
 *
 * 样例2
 *
 * 输入:
 * {1}
 * 1 1
 * 输出:
 * 1
 * 说明：
 * 这棵树只有一个值为1的节点
 * 注意事项
 * 这两个节点未必都在这棵树上出现。
 */
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType resultType = helper(root, A, B);
        if(resultType.a_exist && resultType.b_exist){
            return resultType.node;
        }
        return null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);

        boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == A;
        boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == B;

        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt.node != null && right_rt.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt.node != null) {
            return new ResultType(a_exist, b_exist, left_rt.node);
        }

        if (right_rt.node != null) {
            return new ResultType(a_exist, b_exist, right_rt.node);
        }
        return new ResultType(a_exist, b_exist, null);
    }
}


class ResultType {

    public boolean a_exist, b_exist;
    public TreeNode node;

    public ResultType(boolean a_exist, boolean b_exist, TreeNode node) {
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.node = node;
    }
}




