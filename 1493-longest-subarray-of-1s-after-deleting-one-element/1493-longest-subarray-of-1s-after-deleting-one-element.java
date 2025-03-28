class Solution {
    public int longestSubarray(int[] nums) {
        int length = nums.length;
        List<Integer> indexOf0 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                indexOf0.add(i);
        }
        if(indexOf0.size() == length) return 0;
        if(indexOf0.size() == 0 || indexOf0.size() == 1) return length - 1;
        int maxLength = indexOf0.get(1) - 1;
        for(int i = 2; i < indexOf0.size(); i++) {
            int subLength = indexOf0.get(i) - indexOf0.get(i - 2) - 2;
            maxLength = Math.max(maxLength, subLength);
        }
        maxLength = Math.max(maxLength, length - indexOf0.get(indexOf0.size() - 2) - 2);
        return maxLength;
    }
}