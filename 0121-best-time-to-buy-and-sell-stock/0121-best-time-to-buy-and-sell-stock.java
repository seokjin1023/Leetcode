class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minBuy = prices[0];
        for(int i = 1; i < prices.length; i++) {
            answer = Math.max(prices[i] - minBuy, answer);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return answer;
    }
}