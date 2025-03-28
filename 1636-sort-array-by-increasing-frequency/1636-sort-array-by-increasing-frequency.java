class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<int[]> countNum = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            countNum.add(new int[]{entry.getValue(), entry.getKey()});
        countNum.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] answer = new int[nums.length];
        int index = 0;
        for(int[] num : countNum) {
            for(int i = 0; i < num[0]; i++) {
                answer[index++] = num[1];
            }
        }
        return answer;
    }
}