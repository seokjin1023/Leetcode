class Solution {
    private int add(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int addDigits(int num) {
        while(num >= 10) {
            num = add(num);
        }
        return num;
    }
}