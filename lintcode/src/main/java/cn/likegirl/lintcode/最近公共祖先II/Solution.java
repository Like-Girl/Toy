package cn.likegirl.lintcode.最近公共祖先II;

import java.util.ArrayList;
import java.util.List;

/**
 * 474. 最近公共祖先 II
 * 中文English
 * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
 *
 * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
 *
 * 每个节点除了左右儿子指针以外，还包含一个父亲指针parent，指向自己的父亲。
 *
 * 样例
 * 例1：
 *
 * 输入：
 *        4
 *       / \
 *      3  7
 *         / \
 *        5  6
 * 和3,5
 * 产量：4
 * 说明：LCA（3,5）= 4
 *
 * 例2：
 *
 * 输入：
 *        4
 *       / \
 *      3  7
 *         / \
 *        5  6
 * 和5,6
 * 输出：7
 * 说明：LCA（5,6）= 7
 *
 * @author LikeGirl
 */
public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        List<ParentTreeNode> pathA = getPath2Root(A);
        List<ParentTreeNode> pathB = getPath2Root(A);
        int sizeA = pathA.size() - 1;
        int sizeB = pathB.size() - 1;
        ParentTreeNode lowestAncestor = null;
        while (sizeA >= 0 && sizeB >= 0) {
            if (pathA.get(sizeA) != pathB.get(sizeB)) {
                break;
            }
            lowestAncestor = pathA.get(sizeA);
            sizeA--;
            sizeB--;
        }
        return lowestAncestor;
    }

    private List<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        for (; ; ) {
            if (node == null) {
                break;
            }
            path.add(node);
            node = node.parent;
        }
        return path;
    }

    public static void main(String[] args) {
        ParentTreeNode p2 = new ParentTreeNode();

        ParentTreeNode p_1 = new ParentTreeNode();

        p2.left = p_1;

        System.out.println(p2);
        System.out.println(p_1);

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestorII(p2, p_1, p2));


    }
}



