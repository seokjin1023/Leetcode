class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if(sum < 0) sum += k;
            map.merge(sum, 1, (oldval, newval) -> oldval + newval);
        }
        for(Integer rest : map.keySet()) {
            if(rest == 0) {
                int count = map.get(rest);
                answer += count * (count + 1) / 2;
            }
            else {
                int count = map.get(rest);
                answer += count * (count - 1) / 2;
            }
        }
        return answer;
    }
}