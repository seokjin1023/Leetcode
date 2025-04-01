public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder answer = new StringBuilder(Integer.toUnsignedString(n, 2));
        while(answer.length() < 32) {
            answer.insert(0, '0');
        }
        return Integer.parseUnsignedInt(answer.reverse().toString(), 2);
    }
}