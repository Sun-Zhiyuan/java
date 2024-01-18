class singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int target = 0;
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        else{
            while(len>1) {
                int half = (len + 1) / 2;
                if (half % 2 == 1) {
                    if (nums[target+half] == nums[target+half - 1]) {
                        target += (half + 1);
                        len -= (half + 1);
                        System.out.println(1);
                    } else {
                        len = half;
                        System.out.println(2);
                    }
                }
                else {
                    if (nums[target+half] == nums[target+half - 1]) {
                        len = half - 1;
                        System.out.println(3);
                    } else {
                        target += half;
                        len -= half;
                        System.out.println(4);
                    }
                }
                System.out.println("len:"+len);
                System.out.println("target:"+target);
            }
        }
        return nums[target];
    }
}