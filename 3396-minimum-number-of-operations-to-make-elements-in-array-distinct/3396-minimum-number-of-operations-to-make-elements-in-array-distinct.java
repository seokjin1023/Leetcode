class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n % 3 == 1)
            set.add(nums[nums.length - 1]);
        else if(n % 3 == 2) {
            set.add(nums[nums.length - 1]);
            if(!set.add(nums[nums.length - 2]))
                return n / 3 + 1;
        }
        for(int i = nums.length - 1 - n % 3; i >= 0; i -= 3) {
            for(int j = 0; j < 3; j++) {
                if(!set.add(nums[i - j]))
                    return i / 3 + 1;
            }
        }
        return 0;
    }
}