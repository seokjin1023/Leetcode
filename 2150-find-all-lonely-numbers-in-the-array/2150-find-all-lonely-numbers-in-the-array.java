class Solution {
    public List<Integer> findLonely(int[] nums) {
        Set<Integer> lonelyNum = new HashSet<>();
        Set<Integer> isPresent = new HashSet<>();
        for(int num : nums) {
            boolean isLonely = true;
            for(int i = -1 ; i <= 1; i++) {
                if(isPresent.contains(num + i)) {
                    lonelyNum.remove(num + i);
                    isLonely = false;
                }
            }
            if(isLonely) lonelyNum.add(num);
            isPresent.add(num);
        }
        return new ArrayList<>(lonelyNum);
    }
}