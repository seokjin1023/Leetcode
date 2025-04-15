class Solution {
    private boolean isPalindromic(List<Integer> digits) {
        for(int i = 0; i < digits.size() / 2; i++) {
            if(digits.get(i) != digits.get(digits.size() - 1- i))
                return false;
        }
        return true;
    }
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i < n - 1; i++) {
            int currentN = n;
            List<Integer> digits = new ArrayList<>();
            while(currentN >= i) {
                digits.add(currentN % i);
                currentN /= i;
            }
            digits.add(currentN);
            Collections.reverse(digits);
            if(!isPalindromic(digits))
                return false;
        }
        return true;
    }
}