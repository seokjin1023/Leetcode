class Solution {
    public int countLargestGroup(int n) {
        int[] group = new int[37];
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while(num >= 10) {
                sum += num % 10;
                num /= 10;
            }
            sum += num;
            group[sum]++;
        }
        int largest = 0;
        int count = 0;
        for(int i = 1; i < 37; i++) {
            if(largest == group[i])
                count++;
            else {
                if(largest < group[i]) {
                    count = 1;
                    largest = Math.max(largest, group[i]);
                }
            }
        }
        return count;
    }
}