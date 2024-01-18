class SolutionMaxDecrease {
    public int maxDiff(int num) {
        int len = 0;
        int temp = num;
        int max = 0;
        int min = 0;
        while(temp!=0){
            temp = temp/10;
            len++;
        }
        int []nums = new int[len];
        for(int i = len-1 ; i >= 0 ; i--){
            int prefix = 0;
            for(int j = len-1 ; j >= i ;j--){
                prefix = prefix+(int)(nums[j]*Math.pow(10,j-i));
            }
            nums[i] = getNum(num,i)-prefix;
        }
        int []maxNums = nums.clone();
        int []minNums = nums.clone();
        int index = 0;
        while(len-1-index>=0&&maxNums[len-1-index]==9)
            index++;
        if(index == len)
            max = num;
        else{
            max = flushed(maxNums,9,index);
        }
        if(len==1)
            min = 1;
        else {
            int answer = 0;
            if (minNums[len - 1] == 1) {
                int minIndex = 0;
                while (len - 1 - minIndex >= 0 && (minNums[len - 1 - minIndex] == 1||minNums[len - 1 - minIndex] == 0)) {
                    minIndex++;
                }
                if (minIndex == len) {
                    min = num;
                }
                else {
                    int tempMin = minNums[len - 1 - minIndex];
                    for (int i = 0; i < nums.length; i++) {
                        if (minNums[i] == tempMin) {
                            minNums[i] = 0;
                        }
                    }
                    for (int i = 0; i < nums.length; i++) {
                        answer = answer + (int) (Math.pow(10, i) * minNums[i]);
                    }
                    min = answer;
                }
            }
            else {
                int tempMax = minNums[len-1];
                for (int i = 0; i < nums.length; i++) {
                    if (minNums[i] == tempMax) {
                        minNums[i] = 1;
                    }
                }
                for (int i = 0; i < nums.length; i++) {
                    answer = answer + (int) (Math.pow(10, i) * minNums[i]);
                }
                min = answer;
            }
        }
        for(int i = 0 ; i < len ; i++){
            System.out.println(nums[i]);
        }
        System.out.println(max);
        System.out.println(min);
        return max-min;
    }
    public int getNum(int num,int position){
        return (int)(num/Math.pow(10,position));
    }
    public int flushed(int []nums,int number,int index){
        int answer = 0;
        int tempMax = nums[nums.length-1-index];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == tempMax){
                nums[i] = number;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            answer = answer + (int)(Math.pow(10,i)*nums[i]);
        }
        return answer;
    }
}