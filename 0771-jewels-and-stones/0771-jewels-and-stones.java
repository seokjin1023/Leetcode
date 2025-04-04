class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for(char c : jewels.toCharArray())
            set.add(c);
        for(char c : stones.toCharArray())
            if(set.contains(c)) answer++;
        return answer;
    }
}