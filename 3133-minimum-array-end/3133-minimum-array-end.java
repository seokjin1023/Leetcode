class Solution {
    public long minEnd(int n, int x) {
        if(n == 1)
            return (long)x;
        String end = Integer.toString(x, 2);
        int canPut = end.length() - Integer.bitCount(x);
        String front = Integer.toString(n - 1, 2);

        int index = front.length() - 1;
        StringBuilder answer = new StringBuilder();
        for(char c : new StringBuilder(end).reverse().toString().toCharArray()) {
            if(c == '1')
                answer.append('1');
            else
                answer.append(front.charAt(index--));
        }
        while(index >= 0) {
            answer.append(front.charAt(index--));
        }
        return Long.parseLong(answer.reverse().toString(), 2);
    }
}