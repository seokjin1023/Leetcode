class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < Math.min(nums1.length, k); i++) {
            que.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        for(int i = 0; i < k; i++) {
            int[] index = que.poll();
            answer.add(Arrays.asList(nums1[index[1]], nums2[index[2]]));
            if(index[2] + 1 < nums2.length)
                que.add(new int[]{nums1[index[1]] + nums2[index[2] + 1], index[1], index[2] + 1});
        }
        return answer;
    }
}