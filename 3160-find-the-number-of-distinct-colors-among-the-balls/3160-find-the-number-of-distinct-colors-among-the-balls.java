class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, Integer> ballColor = new HashMap<>(); //ballNum, color
        Map<Integer, Set<Integer>> countColor = new HashMap<>(); //color, ballNums
        for(int i= 0; i < queries.length; i++) {
            int[] query = queries[i];
            int num = query[0];
            int color = query[1];
            if(ballColor.containsKey(num)) {
                Set<Integer> set = countColor.get(ballColor.get(num));
                set.remove(num);
                if(set.isEmpty())
                    countColor.remove(ballColor.get(num));
                else
                    countColor.put(ballColor.get(num), set);
            }
            ballColor.put(num, color);
            Set<Integer> set = countColor.computeIfAbsent(color, k -> new HashSet<>());
            set.add(num);
            countColor.put(color, set);

            answer[i] = countColor.size();
        }
        return answer;
    }
}