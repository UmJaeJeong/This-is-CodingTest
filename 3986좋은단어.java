import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class GoodWordExample {
    static int count= 0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N입력
        try {
            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N;i++){
                String inputData = br.readLine();
                //함수
                correctWord(inputData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }

    public static void correctWord(String inputData){
        //inputData 홀수 일경우
        if(inputData.length()%2 == 1) return;

        Stack<Character> stack = new Stack<>();
        stack.push(inputData.charAt(0));
        //index 1~ N-1까지 반복
        for(int i=1; i<inputData.length();i++){
            if(stack.size()>0&& stack.peek() == inputData.charAt(i)){
                stack.pop();
            }else{
                stack.push(inputData.charAt(i));
            }
        }
        if(stack.isEmpty())count++;
    }
}
