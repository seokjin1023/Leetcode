class Solution {
    public int minimumIndex(List<Integer> nums) {
        int length = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        int dominantNum = nums.get(0);
        for(Integer num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(Integer num : map.keySet()) 
            dominantNum = map.get(dominantNum) > map.get(num) ? dominantNum : num;
        int frontSize = 0, frontdominantNum = 0;
        int backSize = length, backdominantNum = map.get(dominantNum);
        for(int i = 0; i < length; i++) {
            frontSize++;
            backSize--;
            if(nums.get(i) == dominantNum) {
                frontdominantNum++;
                backdominantNum--;
            }
            if(frontdominantNum * 2 > frontSize && backdominantNum * 2 > backSize)
                return i;
        }
        return -1;
    } 
}