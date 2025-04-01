class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        int index = 0;
        for(char c : pattern.toCharArray()) {
            if(map.containsKey(c)) {
                if(!map.get(c).equals(words[index]))
                    return false;
            }
            else {
                if(!wordSet.add(words[index]))
                    return false;
                map.put(c, words[index]);
            }
            index++;
        }
        return true;
    }
}