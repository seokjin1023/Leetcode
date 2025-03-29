class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        boolean up = true;
        for(int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            if(up) {
                value++;
                up = false;
            }
            if(value == 10) {
                value = 0;
                up = true;
            }
            sb.append(value);
        }
        if(up) sb.append(1);
        return sb.reverse().toString().chars()
               .map(c -> c - '0')
               .toArray();
    }
}