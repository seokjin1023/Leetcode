class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] string = s.toCharArray();
        for(char c : string) {
            if(!stack.isEmpty()) {
                if(Math.abs(c - stack.peek()) == 32) {
                    stack.pop();
                }
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}