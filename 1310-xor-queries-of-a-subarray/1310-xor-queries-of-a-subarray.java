class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0] + 1;
            int end = queries[i][1];
            int xor = arr[start - 1];
            while(start <= end) {
                xor = xor ^ arr[start++];
            }
            answer[i] = xor;
        }
        return answer;
    }
}