class Solution {
    public String countAndSay(int n) {
        String answer = "1";
        for(int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char currentChar = answer.charAt(0);
            for(int j = 1; j < answer.length(); j++) {
                if(currentChar != answer.charAt(j)) {
                    sb.append(Integer.toString(count));
                    sb.append(currentChar);
                    count = 1;
                    currentChar = answer.charAt(j);
                }
                else
                    count++;
            }
            sb.append(Integer.toString(count));
            sb.append(currentChar);
            answer = sb.toString();
        }
        return answer;
    }
}