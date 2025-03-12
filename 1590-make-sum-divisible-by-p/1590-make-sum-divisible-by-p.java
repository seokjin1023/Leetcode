class Solution {
    public int minSubarray(int[] nums, int p) {
        int minLength = Integer.MAX_VALUE;
        int[] prefixMod = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0L;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixMod[i] = (int)(sum % p);
        }
        if(sum % p == 0)
            return 0;
        if(sum < p)
            return -1;
        
        int targetMod = (int)(sum % p);
        map.put(0, -1); //만약 targetMod와 일치하는 값이 있을 경우를 대비
        for(int i = 0; i < prefixMod.length; i++) {
            int requiredMod = (prefixMod[i] - targetMod + p) % p;
            if(map.containsKey(requiredMod)) {
                if(i - map.get(requiredMod) != prefixMod.length)
                    minLength = Math.min(minLength, i - map.get(requiredMod));
            }
            map.put(prefixMod[i], i);
        }
        if(minLength == Integer.MAX_VALUE)
            return -1;
        return minLength;
    }
}