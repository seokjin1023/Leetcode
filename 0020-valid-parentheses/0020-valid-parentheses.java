class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for(char c : array) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else if(c == ')') {
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
            else if(c == '}') {
                if(stack.peek() == '{') stack.pop();
                else return false;
            }
            else {
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}