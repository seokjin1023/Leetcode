class Solution {
    public int removeDuplicates(int[] nums) {
        int[] answer = new int[nums.length];
        int index = 0;
        Set<Integer> uniqueNum = new HashSet<>();
        for(int num : nums) {
            if(uniqueNum.add(num))
                answer[index++] = num;
        }
        int answerSize = uniqueNum.size();
        System.arraycopy(answer, 0, nums, 0, answerSize);
        return answerSize;
    }
}