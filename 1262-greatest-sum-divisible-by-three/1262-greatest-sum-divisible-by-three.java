class Solution {
    public int maxSumDivThree(int[] nums) {
        int answer = 0;
        int[] rest1 = new int[2];
        Arrays.fill(rest1, Integer.MAX_VALUE);
        int[] rest2 = new int[2];
        Arrays.fill(rest2, Integer.MAX_VALUE);
        for(int num : nums) {
            answer += num;
            if(num % 3 == 1) {
                if(num < rest1[0]) {
                    rest1[1] = rest1[0];
                    rest1[0] = num;
                }
                else if(num < rest1[1])
                    rest1[1] = num;
            }
            else if(num % 3 == 2) {
                if(num < rest2[0]) {
                    rest2[1] = rest2[0];
                    rest2[0] = num;
                }
                else if(num < rest2[1])
                    rest2[1] = num;
            }
        }
        if(answer % 3 == 0) return answer;
        if(answer % 3 == 1) {
            int candidate1 = rest1[0];
            int candidate2 = Integer.MAX_VALUE;
            if(rest2[1] != Integer.MAX_VALUE)
                candidate2 = rest2[0] + rest2[1];
            return answer - Math.min(candidate1, candidate2);
        }
        if(answer % 3 == 2) {
            int candidate1 = rest2[0];
            int candidate2 = Integer.MAX_VALUE;
            if(rest1[1] != Integer.MAX_VALUE)
                candidate2 = rest1[0] + rest1[1];
            return answer - Math.min(candidate1, candidate2);
        }
        return -1;
    }
}