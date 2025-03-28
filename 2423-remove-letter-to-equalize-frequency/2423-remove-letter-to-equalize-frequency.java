class Solution {
    public boolean equalFrequency(String word) {
        int length = word.length();
        int[] alpha = new int[26];
        char[] string = word.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : string) {
            alpha[c - 'a']++;
            set.add(c);
        }
        if(set.size() == 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : alpha) {
            if(num != 0)
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() == 1) {
            return map.containsKey(1);
        }

        if (map.size() == 2) {
            List<Integer> keys = new ArrayList<>(map.keySet());
            int a = keys.get(0), b = keys.get(1);

            if ((map.get(a) == 1 && (a == 1 || a == b + 1)) ||
                (map.get(b) == 1 && (b == 1 || b == a + 1))) {
                return true;
            }
        }
        return false;
    }
}