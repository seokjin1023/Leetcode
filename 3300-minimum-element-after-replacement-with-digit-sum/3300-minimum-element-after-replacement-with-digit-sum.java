class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min, String.valueOf(num).chars().map(c -> c - '0').sum());
        }
        return min;
    }
}