import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesisExample {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N;i++){
                String str = br.readLine();
              System.out.println(correctParenthesis(str));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String correctParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        return stack.size()==0?"YES":"NO";

    }
}
