class Solution {
    public int minCapability(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        while(min <= max) {
            int mid = (max + min) / 2;
            boolean canMake = false;
            //여기서 되는지 찾고
            for(int i = 0; i < 2; i++) {
                if(canMake) break;
                int start = i;
                int countSteal = 0;
                while(start < nums.length) {
                    if(nums[start] <= mid) {
                        countSteal++;
                        start += 2;
                    }
                    else {
                        start++;
                    }
                }
                if(countSteal >= k)
                    canMake = true;
            }
            
            if(canMake) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            } 
            else
                min = mid + 1;
        }
        return answer;
    }
}