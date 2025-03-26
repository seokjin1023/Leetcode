class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        List<Set<Character>> list = new ArrayList<>();
        for(String word : words) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
            list.add(set);
        }
        System.out.println(list);
        for(int i = 0; i < words.length; i++) {
            Set<Character> set = list.get(i);
            for(int j = i + 1; j < words.length; j++) {
                if(set.equals(list.get(j)))
                    count++;
            }
        }
        return count;
    }
}