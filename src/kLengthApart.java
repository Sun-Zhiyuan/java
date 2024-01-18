class kLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        boolean flag = true;
        int index = 0;
        int i = 0;
        while(i<nums.length && nums[i]!=1){
            i++;
        }
        if(i==nums.length){
            return true;
        }
        i++;
        for( ; i < nums.length ; i++){
            if(nums[i] == 0){
                index++;
            }
            else {
                if(index<k){
                    flag = false;
                    break;
                }
                else {
                    index = 0;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        kLengthApart kLengthApart = new kLengthApart();
        System.out.println(kLengthApart.kLengthApart(new int[]{1,0,0,1,0,1},2));
    }
}