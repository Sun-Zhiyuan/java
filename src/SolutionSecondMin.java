import java.util.LinkedList;

class SolutionSecondMin {
    public int findSecondMinimumValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tail = new TreeNode();
        queue.add(tail);
        int answer = Integer.MAX_VALUE;
        int sum = 1;
        int max = 0;
        if(root.val==Integer.MAX_VALUE){
            return -1;
        }
        while(queue.size()>1){
            TreeNode node = queue.removeFirst();
            if(node!=tail) {
                if (node.left != null) {
                    queue.addLast(node.left);
                    sum++;
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    sum++;
                }
                if(node.val>max){
                    max = node.val;
                }
                if(node.val<answer&&node.val>root.val&&node!=root){
                    answer = node.val;
                }
            }
            else {
                queue.addLast(tail);
            }
        }
        if(sum == getNode(root,1)&&answer==Integer.MAX_VALUE&&max!=Integer.MAX_VALUE){
            System.out.println(answer);
            answer = -1;
        }
        return answer;
    }
    public int getNode(TreeNode node,int num){
        if(node.left!=null){
            num = getNode(node.left,num+1);
        }
        if(node.right!=null){
            num = getNode(node.right,num+1);
        }
        return num;
    }
}