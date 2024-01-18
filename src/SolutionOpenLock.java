class SolutionMaxProfitMiddle {
    public int maxProfit(int[] prices) {
        int []own = new int[prices.length];
        int []notOwn = new int[prices.length];
        own[0] = -prices[0];
        notOwn[0] = 0;
        for(int i = 1 ; i < prices.length ; i++){
            own[i] = Math.max(notOwn[i-1] - prices[i],own[i-1]);
            notOwn[i] = Math.max(notOwn[i-1],own[i-1]+prices[i]);
            System.out.println(i+" own: "+own[i]+" notOwn: "+notOwn[i]);
        }
        int temp = Math.max(notOwn[prices.length-1],own[prices.length-1]+prices[prices.length-1]);
        return Math.max(temp,0);
    }
}