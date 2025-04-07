class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total % 2 == 1) return false;

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int target = total / 2;
        for(int num : nums) {
            if(set.contains(target - num)) return true;
            
            Set<Integer> newSet = new HashSet<>();
            newSet.add(num);
            for(Integer key : set) {
                if(key + num < target)
                    newSet.add(key + num);
            }
            set.addAll(newSet);
        }
        return false;
    }
}