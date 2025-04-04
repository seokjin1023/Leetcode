class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.merge(c, 1, (oldval, newval) -> oldval + newval);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(Character c : map.keySet())
            pq.add(new int[]{(int)c.charValue(), map.get(c)});
        while(!pq.isEmpty()) {
            int[] frequency = pq.poll();
            for(int i = 0; i < frequency[1]; i++) {
                sb.append((char)frequency[0]);
            }
        }
        return sb.toString();
    }
}