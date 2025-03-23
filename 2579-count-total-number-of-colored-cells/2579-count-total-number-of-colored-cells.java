class Solution {
    public long coloredCells(int n) {
        long[] count = new long[n + 1];
        count[1] = 1;
        for(int i = 2; i < n + 1; i++){
            count[i] = count[i - 1] + 4 * (i - 1);
        }
        return count[n];
    }
}