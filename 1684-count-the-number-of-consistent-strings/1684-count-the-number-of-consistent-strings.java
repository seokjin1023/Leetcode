class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        Set<Character> allowedSet = new HashSet<>();
        for(char c : allowed.toCharArray())
            allowedSet.add(c);
        
        for(String word : words) {
            Set<Character> wordSet = new HashSet<>();
            for(char c : word.toCharArray())
                wordSet.add(c);
            wordSet.removeAll(allowedSet);
            if(wordSet.isEmpty())
                answer++;
        }
        return answer;
    }
}