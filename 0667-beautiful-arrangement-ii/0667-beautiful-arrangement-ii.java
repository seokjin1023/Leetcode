class Solution {
    public int[] constructArray(int n, int k) {
        Set<Integer> num = new HashSet<>();
        int[] answer = new int[n];
        answer[0] = 1;
        int addOrSub = n - 1;
        for(int i = 1; i < n; i++) {
            if(i < k) {
                if(i % 2 == 0)
                    answer[i] = answer[i - 1] - addOrSub;
                else
                    answer[i] = answer[i - 1] + addOrSub;
                addOrSub--;
            }
            else {
                if(k % 2 == 0)
                    answer[i] = answer[i - 1] - 1;
                else
                    answer[i] = answer[i - 1] + 1;
            }
        }
        return answer;
    }
}