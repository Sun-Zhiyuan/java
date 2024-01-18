import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

class SolutionTree {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getPost(root,list);
        return list;
    }
    public void getPost(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        getPost(node.left,list);
        getPost(node.right,list);
        list.add(node.val);
    }
}
