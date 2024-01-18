class SolutionMaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int []sum = new int[arr.length];
        int max = arr[0];
        for(int i = 0 ; i < k ; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            sum[i] = max*(i+1);
        }
        for(int i = k ; i < sum.length ; i++){
            int []temp = new int[k];
            for(int j = 1 ; j <= k ; j++){
                int tempMax = 0;
                for(int l = 0 ; l < j ; l++){
                    if(arr[i-l]>tempMax){
                        tempMax = arr[i-l];
                    }
                }
                temp[j-1] = sum[i-j]+tempMax*j;
                for(int p = 0 ; p < temp.length ; p++){
                    if(temp[p]>sum[i]){
                        sum[i] = temp[p];
                    }
                }
            }
        }
        for (int j : sum) {
            System.out.println(j);
        }
        return sum[arr.length-1];
    }
}
