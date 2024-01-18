import java.util.LinkedList;

class SolutionBinaryMax {
    public int maxLevelSum(TreeNode root) {
        int []curSum = new int[getHeight(root)];
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode marker = null;
        queue.add(marker);
        while(queue.size()>1){
            TreeNode x = queue.removeFirst();
            if(x!=marker){
                curSum[level] = curSum[level] + x.val;
                if(x.left!=null)
                    queue.addLast(x.left);
                if(x.right!=null)
                    queue.addLast(x.right);
            }
            else{
                level++;
                queue.addLast(marker);
            }
        }
        int sum = Integer.MIN_VALUE;
        int sumLevel = 0;
        for(int i = 0 ; i < getHeight(root) ; i++){
            System.out.println(curSum[i]);
            System.out.println(sum);
            if(curSum[i]>sum){
                sumLevel = i;
                sum = curSum[i];
                System.out.println(i);
            }
        }
        return sumLevel+1;
    }
    public int getHeight (TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right? left + 1 : right + 1;
    }
}