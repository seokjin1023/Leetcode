class Solution {
    public String makeGood(String s) {
        char[] string = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : string) {
            if(sb.length() != 0) {
                if(Math.abs(sb.charAt(sb.length() - 1) - c) == 32)
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(c);
            }
            else
                sb.append(c);
        }
        return sb.toString();
    }
}