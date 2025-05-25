class Solution {
    public int longestPalindrome(String[] words) {
        int answer = 0;
        boolean canAdd = false;
        Map<String, Integer> countWord = new HashMap<>();

        for(String word : words) {
            int count = countWord.getOrDefault(word, 0);
            count++;
            countWord.put(word, count);
        }
        
        for(Map.Entry<String, Integer> entry : countWord.entrySet()) {
            int count = entry.getValue();
            String word = entry.getKey();
            String revWord = String.valueOf(word.charAt(1)) + word.charAt(0);
            if(word.equals(revWord)) {
                answer += (count / 2) * 4;
                if(count % 2 == 1) 
                    canAdd = true;
                continue;
            }

            if(countWord.containsKey(revWord)) {
                int revCount = countWord.get(revWord);
                int pairNum = Math.min(revCount, count);
                countWord.put(revWord, revCount - pairNum);
                countWord.put(word, count - pairNum);
                answer += pairNum * 4;
            }
        }
        if(canAdd)
            answer += 2;
        return answer;
    }
}