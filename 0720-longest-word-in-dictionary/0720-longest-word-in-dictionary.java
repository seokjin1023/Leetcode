class Solution {
    public String longestWord(String[] words) {
        String answer = "";
        Set<String> answerList = new HashSet<>();
        answerList.add("");
        for(int i = 1; i < 31; i++) {
            Set<String> toremove = new HashSet<>();
            for(String word : words) {
                if(word.length() != i) continue;

                String substr = word.substring(0, word.length() - 1);
                if(answerList.contains(substr)) {
                    answerList.add(word);
                    toremove.add(substr);
                }
            }
            for(String remove : toremove) {
                answerList.remove(remove);
            }
        }
        for(String candidate : answerList) {
            if(candidate.length() > answer.length())
                answer = candidate;
            else if(candidate.length() == answer.length())
                answer = answer.compareTo(candidate) <= 0 ? answer : candidate;
        }
        return answer;
    }
}