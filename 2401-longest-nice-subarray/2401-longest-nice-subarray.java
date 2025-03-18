class Solution {
    private boolean canAdd(boolean[] bit, String bitNum) {
        for(int i = 0; i < bitNum.length(); i++) {
            if(bitNum.charAt(bitNum.length() - 1 - i) == '1') {
                if(bit[i])
                    return false;
            }
        }
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        boolean[] bit = new boolean[32];
        Queue<Integer> que = new LinkedList<>();
        int answer = Integer.MIN_VALUE;
        int subLength = 0;
        for(int num : nums) {
            String bitNum = Integer.toString(num, 2);
            while(!canAdd(bit, bitNum) && !que.isEmpty()) {
                String subBitNum = Integer.toString(que.poll(), 2);
                for(int i = 0; i < subBitNum.length(); i++) {
                    if(subBitNum.charAt(subBitNum.length() - 1 - i) == '1')
                        bit[i] = false;
                }
                subLength--;
            }
            for(int i = 0; i < bitNum.length(); i++) {
                if(bitNum.charAt(bitNum.length() - 1 - i) == '1')
                    bit[i] = true;
            }
            que.add(num);
            subLength++;
            answer = Math.max(answer, subLength);
        }
        return answer;
    }
}