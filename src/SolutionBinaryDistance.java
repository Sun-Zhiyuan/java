import java.util.*;

class SolutionBinaryDistance {
    Map<Integer,TreeNode> parents = new HashMap<Integer,TreeNode>();
    List<Integer> answer = new ArrayList<Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        getAnswer(target,null,k,0);
        return answer;
    }
    public void findParent(TreeNode root){
        if(root.left!=null) {
            parents.put(root.left.val, root);
            findParent(root.left);
        }
        if(root.right!=null){
            parents.put(root.right.val,root);
            findParent(root.right);
        }
    }
    public void getAnswer(TreeNode target,TreeNode from,int k,int distance){
        if(target==null){
            return;
        }
        if(distance==k){
            answer.add(target.val);
            return;
        }
        getAnswer(target.left,target,k,distance+1);
        getAnswer(target.right,target,k,distance+1);
        if(parents.get(target.val)!=from){
            getAnswer(parents.get(target.val),target,k,distance+1);
        }
    }
}
