class SolutionChangeOne {
    public boolean checkPossibility(int[] nums) {
        int sum = 0;
        if(nums.length==1||nums.length==2){
            return true;
        }
        if(nums[0]>nums[1]){
            sum++;
            nums[0] = 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
            if(sum>=2){
                break;
            }
            if(i==nums.length-2){
                if(sum==0){
                    break;
                }
                else{
                    if(nums[i]>nums[i+1]){
                        sum++;
                        break;
                    }
                }
            }
            while (nums[i] > nums[i + 1] && sum < 2) {
                sum++;
                if (nums[i-1]<=nums[i+1]) {
                    nums[i] = nums[i - 1];
                }
                else if(i+2< nums.length){
                    nums[i+1] = nums[i+2];
                }
            }
        }
        return sum < 2;
    }
}