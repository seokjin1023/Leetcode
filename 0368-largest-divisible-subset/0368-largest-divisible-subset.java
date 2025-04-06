class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int largestSet = 0;

            for (Integer key : map.keySet()) {
                List<Integer> list = map.get(key);
                int lastValue = list.get(list.size() - 1);

                if (num % lastValue == 0) {
                    if (list.size() > map.getOrDefault(largestSet, List.of()).size()) {
                        largestSet = key;
                    }
                }
            }

            if (largestSet == 0) {
                map.put(num, new ArrayList<>(List.of(num)));
            } else {
                List<Integer> newList = new ArrayList<>(map.get(largestSet));
                newList.add(num);
                map.put(num, newList);
            }
        }
        int largestSubset = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key).size() > map.getOrDefault(largestSubset, List.of()).size())
                largestSubset = key;
        }
        return map.get(largestSubset);
    }
}