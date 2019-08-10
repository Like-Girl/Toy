package cn.likegirl.lintcode.最近公共祖先;

/**
 * 88. 最近公共祖先
 * 中文English
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 *
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1},1,1
 * 输出：1
 * 解释：
 *  二叉树如下（只有一个节点）:
 *          1
 *  LCA(1,1) = 1
 * 样例 2:
 *
 * 输入：{4,3,7,#,#,5,6},3,5
 * 输出：4
 * 解释：
 *  二叉树如下:
 *
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 *
 *  LCA(3, 5) = 4
 * 注意事项
 * 假设给出的两个节点都在树中存在
 */
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}




