class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;
        for(int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            if(s.length() % 2 != 0) continue;
            
            int frontSum = 0;
            int backSum = 0;
            for(int j = 0; j < s.length() / 2; j++) {
                frontSum += (int)(s.charAt(j) - '0');
            }
            for(int j = s.length() / 2; j < s.length(); j++)
                backSum += (int)(s.charAt(j) - '0');
            if(frontSum == backSum)
                answer++;
        }
        return answer;
    }
}