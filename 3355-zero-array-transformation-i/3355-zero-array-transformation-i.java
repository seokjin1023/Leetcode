class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] plusCount = new int[nums.length];
        int[] minusCount = new int[nums.length];
        for(int i = 0; i < queries.length; i++) {
            plusCount[queries[i][0]]++;
            minusCount[queries[i][1]]++;
        }
        int canDecrease = 0;
        for(int i = 0; i < nums.length; i++) {
            canDecrease += plusCount[i];
            
            if(canDecrease < nums[i])
                return false;
            
            canDecrease -= minusCount[i];
        }
        return true;
    }
}