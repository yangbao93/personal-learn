package com.personal.codelearn.algorithm;

import com.personal.codelearn.algorithm.entity.TreeNode;

/**
 * @author ：yangbao
 * @description：
 * @version: $
 * @date ：Created in 2020/7/20 2:40 下午
 * @modified By：
 */
public class InvertTreeNode {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {//一定要检查指针为空
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

}
