class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> canNotBe = new HashSet<>();
        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] == backs[i])
                canNotBe.add(fronts[i]);
        }
        
        int[] allNum = new int[fronts.length + backs.length];
        for(int i = 0; i < fronts.length; i++) {
            allNum[2 * i] = fronts[i];
            allNum[2 * i + 1] = backs[i];
        }
        Arrays.sort(allNum);
        for(int num : allNum) {
            if(!canNotBe.contains(num))
                return num;
        }
        return 0;
    }
}