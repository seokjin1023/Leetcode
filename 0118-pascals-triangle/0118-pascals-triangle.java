class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
            }
            answer.add(row);
        }
        return answer;
    }
}