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
        int answer = Integer.MAX_VALUE;
        for(int num : allNum) {
            if(!canNotBe.contains(num))
                answer = Math.min(answer, num);
        }
        if(answer == Integer.MAX_VALUE)
            return 0;
        return answer;
    }
}