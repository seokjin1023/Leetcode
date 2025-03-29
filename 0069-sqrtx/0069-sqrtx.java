class Solution {
    public int mySqrt(int x) {
        long start = 0L;
        long end = 50000L;
        while(start <= end) {
            long mid = (start + end) / 2;
            if(mid * mid == (long)x) return (int)mid;
            if(mid * mid > (long)x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return (int)end;
    }
}