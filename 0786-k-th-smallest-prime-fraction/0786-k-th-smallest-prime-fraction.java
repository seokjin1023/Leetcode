class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> fraction = new ArrayList<>();
        for(int i = 0; i< arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                fraction.add(new int[]{arr[i], arr[j]});
            }
        }
        fraction.sort((a, b) -> Integer.compare(a[0] * b[1], b[0] * a[1]));
        return fraction.get(k - 1);
        
    }
}