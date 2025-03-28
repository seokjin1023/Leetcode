class Solution {
    public boolean isPalindrome(int x) {
        return new StringBuilder(Integer.toString(x)).reverse().toString().equals(Integer.toString(x));
    }
}