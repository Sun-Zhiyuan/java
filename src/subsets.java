import java.util.ArrayList;
import java.util.List;

class subsets {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> empty = new ArrayList<>();
        answer.add(empty);
        if(nums.length==0){

        }
        else {
            for(int i = 0 ; i < nums.length ; i++){
                int len = answer.size();
                for(int j = 0 ; j < len ; j++){
                    List<Integer> temp = answer.get(j);//[[1,2],[1],[2],[]]->[1,2]
                    addOne(temp,nums[i]);
                }

            }
        }
        return answer;
    }
    public void addOne(List<Integer>temp,int a){
        List<Integer> between = new ArrayList<>(temp);
        between.add(a);
        answer.add(between);
    }

    public static void main(String[] args) {
        subsets subsets = new subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
}