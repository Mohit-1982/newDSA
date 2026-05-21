Leetcode - 144
  Optimal : 
    class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preOrder(root, res);

        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);

        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
