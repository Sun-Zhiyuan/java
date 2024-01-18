public class MaxProfitDifficult {
    public int maxProfitDifficult(int[] prices) {
        if (prices.length < 4) {
            int profit = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            }
            return profit;
        } else {
            int profit = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            }
            int[] NoOwnZero = new int[prices.length];
            int[] NoOwnOne = new int[prices.length];
            int[] NoOwnTwo = new int[prices.length];
            int[] OwnOne = new int[prices.length];
            int[] OwnTwo = new int[prices.length];
            OwnOne[0] = -prices[0];
            OwnTwo[2] = -prices[0]+prices[1]-prices[2];
            OwnTwo[0] = OwnTwo[1] = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                NoOwnZero[i] = NoOwnZero[i - 1];
                OwnOne[i] = Math.max(NoOwnZero[i - 1] - prices[i], OwnOne[i - 1]);
                NoOwnOne[i] = Math.max(NoOwnOne[i - 1], OwnOne[i - 1] + prices[i]);
                OwnTwo[i] = Math.max(OwnTwo[i - 1], NoOwnOne[i - 1] - prices[i]);
                NoOwnTwo[i] = Math.max(NoOwnTwo[i - 1], OwnTwo[i - 1] + prices[i]);
            }
            return Math.max(NoOwnTwo[prices.length - 1],profit);
        }
    }
}
