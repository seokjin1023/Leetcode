class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1)
            set1.add(num);
        for(int num : nums2)
            set2.add(num);
        
        int[] answer = new int[2];
        int count = 0;
        for(int num : nums1)
            if(set2.contains(num)) count++;
        answer[0] = count;
        count = 0;
        for(int num : nums2)
            if(set1.contains(num)) count++;
        answer[1] = count;

        return answer;
    }
}