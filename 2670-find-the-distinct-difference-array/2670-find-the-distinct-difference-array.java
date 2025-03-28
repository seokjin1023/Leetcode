class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> countNum = new HashMap<>();
        for(int num : nums)
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        Set<Integer> set = new HashSet<>();
        int[] diff = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            countNum.put(nums[i], countNum.get(nums[i]) - 1);
            if(countNum.get(nums[i]) == 0)
                countNum.remove(nums[i]);
            diff[i] = set.size() - countNum.size();
        }
        return diff;
    }
}