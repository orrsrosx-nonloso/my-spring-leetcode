package history_code;

//其实就是交换一下左右节点，然后再递归的交换左节点，右节点
//        根据动画图我们可以总结出递归的两个条件如下：
//
//        终止条件：当前节点为 null 时返回
//        交换当前节点的左右节点，再递归的交换当前节点的左节点，递归的交换当前节点的右节点
//        时间复杂度：每个元素都必须访问一次，所以是 O(n)O(n)O(n)
//        空间复杂度：最坏的情况下，需要存放 O(h)O(h)O(h) 个函数调用(h是树的高度)，所以是 O(h)O(h)O(h)
//        代码实现如下：

public class leet_226inverttree {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

}
