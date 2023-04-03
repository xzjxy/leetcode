package tree;

public class TreeDemo01 {
    /**
      1 binary tree: degree 只有 0、1和2三种可能性，
      2 degree; 每个 node 的子树 的数目为 改 node 的度
      3 full binary tree: 节点总数为 2^n - 1
      * 4 perfect binary tree: 除最后一层为满二叉树， 且最后一层节点从左往右排列
       性质：
     4.1： 完美二叉树的深度 ： [log(n)]+1 (n代表节点数)
     4.2： 对完美二叉树，从上往下，从左往右进行编号， 1： 为根节点， [i/2] 为节点 i 的父节点  2：节点 i 的的左子树为 2i, 右子树为 2i+1
           3:如果 2i>n， 则 i 节点没有左子树； 如果 2i+1 > n 则 i 节点没有右子树
     */

}
