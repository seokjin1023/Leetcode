class Solution {
    public int minOperations(int[] nums, int k) {
        int[] distinct = Arrays.stream(nums)
                .distinct()
                .toArray();
        Arrays.sort(distinct);
        if(distinct[0] < k) return -1;
        if(k == distinct[0]) return distinct.length - 1;
        return distinct.length;

    }
}