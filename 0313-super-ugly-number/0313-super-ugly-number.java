class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] primeIndex = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        int uglyIndex = 1;
        while(ugly[n - 1] == 0) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < primeIndex.length; i++) {
                long value = (long)ugly[primeIndex[i]] * primes[i];
                if(value <= (long)Integer.MAX_VALUE)
                    min = Math.min((int)value, min);
            }
            for(int i = 0; i < primeIndex.length; i++) {
                long value = (long)ugly[primeIndex[i]] * primes[i];
                if((int)value == min)
                    primeIndex[i]++;
            }
            ugly[uglyIndex++] = min;
        }
        return ugly[n - 1];
        
    }
}