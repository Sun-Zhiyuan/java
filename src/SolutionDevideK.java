import java.util.HashMap;
import java.util.Map;

class SolutionDevideK {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int []cumulate = new int[nums.length];
        int together = nums[0];
        boolean []flag = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(!flag[i]){
                cumulate[i] = together;
                flag[i] = true;
            }
            for(int j = i+1 ; j < nums.length ; j++){
                if(!flag[j]){
                    together = together+nums[j];
                    cumulate[j] = together;
                    flag[j] = true;
                }
                if(((cumulate[j]-cumulate[i])%k)==0){
                    System.out.println("j"+j+" "+"i"+i);
                    sum++;
                }
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(cumulate[i]%k==0) {
                sum++;
            }
        }
        return sum;
    }
}
class SolutionTwo {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            System.out.println(same);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
