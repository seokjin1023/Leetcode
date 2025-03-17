class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        for(Integer num : map.keySet()) {
            if(map.get(num) % 2 != 0)
                return false;
        }
        return true;
    }
}