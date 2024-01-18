import java.util.ArrayList;
import java.util.List;

class SolutionMaxScore {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int left[] = new int[nums.length+1];
        int right[] = new int[nums.length+1];
        int sum[] = new int[nums.length+1];
        left[0] = 0;
        right[nums.length] = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]==0){
                left[i+1] = left[i]+1;
            }
            else {
                left[i+1] = left[i];
            }
        }
        for (int j : left) {
            System.out.println(j);
        }
        for(int i = nums.length-1 ; i >=0  ; i--){
            if(nums[i]==1){
                right[i] = right[i+1]+1;
            }
            else {
                right[i] = right[i+1];
            }
        }
        for (int j : right) {
            System.out.println(j);
        }
        int max = 0;
        for(int i = 0 ; i < sum.length ; i++){
            sum[i] = left[i] + right[i];
            if(sum[i]>max){
                max = sum[i];
            }
        }
        for(int i = 0 ; i < sum.length ; i++){
            if(sum[i]==max){
                answer.add(i);
            }
        }
        return answer;
    }
}