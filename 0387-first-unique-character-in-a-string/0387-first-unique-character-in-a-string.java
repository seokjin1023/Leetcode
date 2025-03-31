class Solution {
    public int firstUniqChar(String s) {
        Queue<int[]> que = new LinkedList<>();
        int[] alphabet = new int[26];
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int alpha = c - 'a';
            if(alphabet[alpha] == 0) 
                que.add(new int[]{alpha, i});
            alphabet[alpha]++;
        }
        int answer = -1;
        while(!que.isEmpty()) {
            int[] candidate = que.poll();
            if(alphabet[candidate[0]] == 1) {
                answer = candidate[1];
                break;
            }
        }
        return answer;
    }
}