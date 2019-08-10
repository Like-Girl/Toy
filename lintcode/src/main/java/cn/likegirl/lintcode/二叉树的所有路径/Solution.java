package cn.likegirl.lintcode.二叉树的所有路径;


import java.util.ArrayList;
import java.util.List;


/**
 * 480. 二叉树的所有路径
 * 中文English
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 *
 * 样例
 * 例1：
 *
 * 输入：
 *
 *    1
 *   / \
 * 2   3
 *  \
 *   5
 *
 * 输出：
 *
 *
 * [
 *   "1->2->5",
 *   "1->3"
 * ]
 * 例2：
 *
 * 输入：
 *
 *    1
 *  /
 * 2
 *
 *
 * 输出：
 *
 * [
 *   "1->2"
 * ]
 */
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        read(paths, root, "");
        return paths;

    }

    public static void read(List<String> paths, TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path = path.length() > 0 ? path + "->" + node.val : path + node.val;
        if (node.left == null && node.right == null) {
            // 存储
            paths.add(path);
            return;
        }
        read(paths, node.left, path);
        read(paths, node.right, path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node2.right = node5;
        root.left = node2;
        root.right = node3;
        System.out.println(binaryTreePaths(root));
    }
}