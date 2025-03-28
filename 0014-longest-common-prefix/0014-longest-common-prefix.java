class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        for(int i = 0; i < strs[0].length(); i++) {
            boolean isCommon = true;
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != c) {
                    isCommon = false;
                    break;
                }
            }
            if(isCommon)
                sb.append(c);
            else
                break;
        }
        return sb.toString();
    }
}