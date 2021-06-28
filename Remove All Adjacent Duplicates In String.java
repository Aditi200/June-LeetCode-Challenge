class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(stack.size() == 0){
                stack.push(s.charAt(i));
            }
            else{
                char top = stack.peek();
                if(s.charAt(i) == top){
                    stack.pop();
                }
                else{
                stack.push(s.charAt(i));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(stack.size() != 0){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}