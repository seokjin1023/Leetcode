class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            for(int j = i + 1; j < arr.length - 1; j++) {
                int second = arr[j];
                for(int k = j + 1; k < arr.length; k++) {
                    int third = arr[k];
                    if(Math.abs(first - second) <= a && Math.abs(second - third) <= b && Math.abs(first - third) <= c)
                        answer++;
                }
            }
        }
        return answer;
    }
}