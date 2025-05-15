class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int currentGroup = groups[0];
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < groups.length; i++) {
            if(currentGroup != groups[i]) continue;
            
            currentGroup = groups[i] == 0 ? 1 : 0;
            answer.add(words[i]);
        }
        return answer;
    }
}