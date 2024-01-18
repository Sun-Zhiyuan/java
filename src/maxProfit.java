class SolutionMaxProfit {
    public int maxProfit(int[] prices) {
        int [][]profit = new int[prices.length][3];
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        profit[0][2] = 0;
        for(int i = 1 ; i < prices.length ; i++){
            profit[i][0] = Math.max(profit[i-1][0],profit[i-1][2]-prices[i]);
            profit[i][1] = profit[i-1][0] + prices[i];
            profit[i][2] = Math.max(profit[i-1][2],profit[i-1][1]);
        }
        return Math.max(profit[prices.length-1][1],profit[prices.length-1][2]);
    }
}