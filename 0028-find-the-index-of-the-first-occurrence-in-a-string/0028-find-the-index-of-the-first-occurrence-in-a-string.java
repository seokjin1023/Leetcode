class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean isSame = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) return i;
        }
        return -1;
    }
}