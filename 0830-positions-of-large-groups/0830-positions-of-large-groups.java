class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> answer = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)) {
                if(end - start >= 2) {
                    answer.add(List.of(start, end));
                }
                start = i;
                end = i;
            }
            else
                end++;
        }
        if(end - start >= 2)
            answer.add(List.of(start, end));
        return answer;
    }
}