class Solution {
    public boolean divideArray(int[] nums) {
        int[] countNum = new int[501];
        for(int num : nums)
            countNum[num]++;
        for(int i = 1; i < 501; i++) {
            if(countNum[i] % 2 != 0)
                return false;
        }
        return true;
    }
}