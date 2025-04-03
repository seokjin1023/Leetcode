class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1)
            set1.add(num);
        for(int num : nums2)
            set2.add(num);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        set1.removeAll(intersection);
        set2.removeAll(intersection);
        List<Integer> answerList = new ArrayList<>();
        for(int num : set1)
            answerList.add(num);
        answer.add(answerList);
        answerList = new ArrayList<>();
        for(int num : set2)
            answerList.add(num);
        answer.add(answerList);
        return answer;
    }
}