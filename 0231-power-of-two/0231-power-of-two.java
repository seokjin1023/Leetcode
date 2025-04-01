class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n >= 0)
            return Integer.bitCount(n) == 1 ? true : false;
        return false;
    }
}