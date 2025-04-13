class Solution {
    private final int mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2; 

        long pow5 = modPow(5, evenCount, mod);
        long pow4 = modPow(4, oddCount, mod);

        return (int)((pow5 * pow4) % mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}