class SolutionStock  {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length==1||prices.length==0){
            return 0;
        }
        else {
            return Math.max(getMax(prices),max);
        }
    }
    public int getMax(int[] prices){
        if(prices.length%2==0&&prices.length>=2){
            int[] front = new int[prices.length/2];
            int[] later = new int[prices.length/2];
            System.arraycopy(prices, 0, front, 0, prices.length / 2);
            System.arraycopy(prices, prices.length / 2, later, 0, prices.length/2);
            int frontMin = Integer.MAX_VALUE;
            int laterMax = Integer.MIN_VALUE;
            for(int i = 0 ; i < prices.length/2 ; i++){
                if(frontMin>front[i]){
                    frontMin = front[i];
                }
                if(laterMax<later[i]){
                    laterMax = later[i];
                }
            }
            int result = laterMax-frontMin;
            return Math.max(Math.max(getMax(front),getMax(later)),result);
        }
        else if(prices.length%2==1&&prices.length>=2){
            int[] front = new int[prices.length/2];
            int[] later = new int[prices.length/2+1];
            System.arraycopy(prices, 0, front, 0, prices.length / 2);
            System.arraycopy(prices, prices.length / 2, later, 0, prices.length/2+1);
            int frontMin = Integer.MAX_VALUE;
            int laterMax = Integer.MIN_VALUE;
            for(int i = 0 ; i < prices.length/2 ; i++) {
                if (frontMin > front[i]) {
                    frontMin = front[i];
                }
            }
            for(int i = 0 ; i < prices.length/2+1;i++){
                if(laterMax<later[i]){
                    laterMax = later[i];
                }
            }
            int result = laterMax-frontMin;
            return Math.max(Math.max(getMax(front),getMax(later)),result);
        }
        else
            return 0;
    }
}