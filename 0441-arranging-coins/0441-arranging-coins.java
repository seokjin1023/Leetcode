class Solution {
    public int arrangeCoins(int n) {
        long k = (long)Math.floor((-1 + Math.sqrt(1 + 8.0 * (long)n)) / 2);
        if((long)n == (k + 1) * (k + 2) / 2) k++;
        return (int)k;
    }
}