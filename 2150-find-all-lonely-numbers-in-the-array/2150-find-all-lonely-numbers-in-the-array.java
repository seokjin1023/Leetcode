class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        for(Integer num : map.keySet()) {
            if(map.get(num) == 1) {
                if(!map.containsKey(num - 1) && !map.containsKey(num + 1))
                    answer.add(num);
            }
        }
        return answer;
    }
}