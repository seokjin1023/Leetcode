class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n; // 2^n

        for (int i = 0; i < total; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        int sum = 0;
        for(List<Integer> list : subsets) {
            int xorValue = 0;
            for(Integer val : list) {
                xorValue ^= val;
            }
            sum += xorValue;
        }
        return sum;
    }
}