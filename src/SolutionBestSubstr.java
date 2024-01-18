class SolutionBestSubstr {
    public long maxAlternatingSum(int[] nums) {
        long []odd = new long[nums.length];
        long []even = new long[nums.length];
        if(nums.length>=2) {
            even[1] = Math.max(nums[0], nums[1]);
            odd[1] = nums[0] - nums[1];
            for (int i = 2; i < nums.length; i++) {
                odd[i] = Math.max(even[i - 1] - nums[i], odd[i - 1]);
                even[i] = Math.max(Math.max(odd[i - 1] + nums[i], even[i - 1]), nums[i]);
            }
            for (int i = 1; i < nums.length; i++) {
                System.out.println(even[i]);
                System.out.println(odd[i]);
            }
            return even[nums.length - 1];
        }
        else {
            return nums[0];
        }
    }
}