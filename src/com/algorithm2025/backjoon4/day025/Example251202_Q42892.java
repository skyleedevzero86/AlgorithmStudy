package com.algorithm2025.backjoon4.day025;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class TreeNode2 {
    int idx;
    int x;
    int y;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}

public class Example251202_Q42892 {

    private static class TreeNodeComparator implements java.util.Comparator<TreeNode2> {
        @Override
        public int compare(TreeNode2 a, TreeNode2 b) {
            if (a.y != b.y) {
                return Integer.compare(b.y, a.y);
            }
            return Integer.compare(a.x, b.x);
        }
    }


    private static void buildBinaryTree(TreeNode2 root, TreeNode2 child) {
        if (root.x > child.x) {
            if (root.left == null) {
                root.left = child;
            } else {
                buildBinaryTree(root.left, child);
            }
        } else {
            if (root.right == null) {
                root.right = child;
            } else {
                buildBinaryTree(root.right, child);
            }
        }
    }


    private static void preOrder(TreeNode2 root, List<Integer> result) {
        if (root == null) return;
        result.add(root.idx);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


    private static void postOrder(TreeNode2 root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.idx);
    }


    public static List<List<Integer>> solution(int[][] nodeinfo) {
        List<TreeNode2> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            int idx = i + 1;
            nodes.add(new TreeNode2(idx, x, y));
        }


        Collections.sort(nodes, new TreeNodeComparator());

        TreeNode2 root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            buildBinaryTree(root, nodes.get(i));
        }

        List<Integer> preOrderResult = new ArrayList<>();
        List<Integer> postOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        postOrder(root, postOrderResult);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(preOrderResult);
        answer.add(postOrderResult);

        return answer;
    }
}