class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        for(int i = 0; i < candies.length; i++) {
            high = Math.max(high, candies[i]);
        }
        int answer = 0;
        int mid;
        //어떻게 mid개의 candy를 가질 수 있는지 알 수 있을까
        while(low <= high) {
            long people = 0;
            mid = (low + high) / 2;
            if(mid == 0)
                break;
            for(int i = 0; i < candies.length; i++) {
                people += candies[i] / mid;
            }
            if(people >= k) {
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return answer;
    }
}