class SolutionArrayNested {
    public int arrayNesting(int[] nums) {
        boolean []flag = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            flag[i] = true;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(flag[i]) {
                int sum = 0;
                while (flag[i]) {
                    sum++;
                    flag[i] = false;
                    i = nums[i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
