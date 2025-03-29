class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        Set<Integer> uniqueNum = new HashSet<>();
        for(int num : nums) {
            if(uniqueNum.add(num))
                nums[index++] = num;
        }
        int answerSize = uniqueNum.size();
        return answerSize;
    }
}