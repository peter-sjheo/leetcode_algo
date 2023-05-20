import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> char_stack = new Stack<>();
        //exam : "{{()}}"

        for(int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if(i==0 && (ch == '}' || ch == ')' || ch == ']')) {
                return false;
            }


            if(ch != ')' && ch != '}' && ch != ']') {
                char_stack.push(ch);
            } else {

                if(char_stack.size() == 0) {
                    return false;
                }

                Character pop_ch = char_stack.pop();
                if(pop_ch == '(' && (ch == '}' || ch == ']'))  {
                    return false;
                }

                if(pop_ch == '[' && (ch == ')' || ch == '}'))  {
                    return false;
                }

                if(pop_ch == '{' && (ch == ')' || ch == ']'))  {
                    return false;
                }
            }
        }

        if(char_stack.size() != 0) {
            return false;
        }

        return true;
    }
}
