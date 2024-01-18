public class SolutionMaxProfitEasy {
    public int maxProfit(int[] prices) {
        return getProfit(prices);
    }
    public int getProfit(int[] prices){
        if(prices.length==1){
            return 0;
        }
        else if(prices.length==2){
            return Math.max(prices[1]-prices[0],0);
        }
        else {
            if(prices.length%2==1) {
                int[] fArray = new int[prices.length / 2];
                int[] bArray = new int[prices.length / 2 +1];
                System.arraycopy(prices, 0, fArray, 0, fArray.length);
                System.arraycopy(prices, prices.length / 2, bArray, 0, bArray.length);
                int subtraction = getMax(bArray)-getMin(fArray);
                int front = getProfit(fArray);
                int back = getProfit(bArray);
                int FBMax = Math.max(front,back);
                int SMax = Math.max(subtraction,0);
                return Math.max(FBMax,SMax);
            }
            else{
                int[] fArray = new int[prices.length / 2];
                int[] bArray = new int[prices.length / 2];
                System.arraycopy(prices, 0, fArray, 0, fArray.length);
                System.arraycopy(prices, prices.length / 2, bArray, 0, bArray.length);
                int subtraction = getMax(bArray)-getMin(fArray);
                int front = getProfit(fArray);
                int back = getProfit(bArray);
                int FBMax = Math.max(front,back);
                int SMax = Math.max(subtraction,0);
                return Math.max(FBMax,SMax);
            }
        }
    }
    public int getMin(int[] prices) {
        int min = prices[0];
        for (int price : prices) {
            if (min > price) {
                min = price;
            }
        }
        return min;
    }
    public int getMax(int[] prices){
        int max = prices[0];
        for (int price : prices) {
            if (max < price) {
                max = price;
            }
        }
        return max;
    }
}
