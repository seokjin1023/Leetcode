class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int[][] alphabet = new int[26][2];
        boolean[] hasAlphabet = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!hasAlphabet[c - 'a']) {
                hasAlphabet[c - 'a'] = true;
                alphabet[c - 'a'][0] = i;
                alphabet[c - 'a'][1] = i;
            }
            else {
                alphabet[c - 'a'][1] = i;
            }
        }
        List<int[]> alphas = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(hasAlphabet[i])
                alphas.add(alphabet[i]);
        }
        alphas.sort((a, b) -> Integer.compare(a[0], b[0]));
        int start = 0;
        int endOfAlpha = 0;
        for(int i = 0; i < alphas.size(); i++) {
            int[] index = alphas.get(i);
            int startIndex = index[0], endIndex = index[1];
            if(startIndex > endOfAlpha) {
                answer.add(endOfAlpha - start + 1);
                start = startIndex;
                endOfAlpha = endIndex;
            }
            else {
                endOfAlpha = Math.max(endOfAlpha, endIndex);
            }
        }
        answer.add(endOfAlpha - start + 1);
        return answer;
    }
}