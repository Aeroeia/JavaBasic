package Stack;

import java.util.Stack;

public class inFixToSufix {
    public static void main(String[] args) {
        String infix = "(a+b)*c-d";
        String sufix = toSufix(infix);
        System.out.println(sufix);
    }
    public static String toSufix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<infix.length();i++) {
            char curr = infix.charAt(i);
            switch (curr){
                case '+','-','*','/'->{
                    if(stack.isEmpty()){
                        stack.push(curr);
                    }
                    else{
                        if(priority(stack.peek())>priority(curr)){
                            while(!stack.isEmpty() && priority(stack.peek())>=priority(curr)){
                                sb.append(stack.pop());
                            }
                            stack.push(curr);
                        }
                        else{
                            stack.push(curr);
                        }
                    }
                }
                case '('->{
                    stack.push(curr);
                }
                case ')'->{
                    while(!stack.isEmpty()&&stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(curr);
                }
            }
        }
       while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static int priority(char ch) {
        return switch (ch){
            case '*','/'->2;
            case '+','-'->1;
            default -> throw new IllegalArgumentException("不合法"+ch);
        };
    }
}
