class Solution {
    final long mod = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        long[] countAlpha = new long[26];
        for(char c : s.toCharArray()) {
            countAlpha[c - 'a']++;
        }
        for(int i = 0; i < t; i++) {
            long countZ = countAlpha[25];
            for(int j = 24; j >= 0; j--) {
                countAlpha[j + 1] = countAlpha[j] % mod;
            }
            countAlpha[0] = countZ;
            countAlpha[1] += countZ;
        }
        long answer = 0;
        for(long num : countAlpha) {
            answer += num;
            answer %= mod;
        }

        return (int)answer;
    }
}