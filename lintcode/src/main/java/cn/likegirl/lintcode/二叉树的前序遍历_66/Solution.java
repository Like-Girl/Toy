package cn.likegirl.lintcode.二叉树的前序遍历_66;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> treeNodes = new ArrayList<>();
        read(root, treeNodes);
        return treeNodes;
    }

    /**
     * 递归
     * @param root       Tree
     * @param treeNodes  Tree Nodes
     */
    public void read(TreeNode root, List<Integer> treeNodes) {
        if(root == null){
            return;
        }
        treeNodes.add(root.val);
        read(root.left, treeNodes);
        read(root.right, treeNodes);
    }
}



